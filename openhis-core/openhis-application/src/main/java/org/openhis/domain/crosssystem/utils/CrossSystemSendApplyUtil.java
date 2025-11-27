package org.openhis.domain.crosssystem.utils;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.whale.admin.web.util.TenantOptionUtil;
import com.whale.common.enums.TenantOptionDict;
import com.whale.common.exception.ServiceException;
import com.whale.common.utils.DateUtils;
import com.whale.common.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.BasicHttpClientConnectionManager;
import org.apache.hc.client5.http.socket.ConnectionSocketFactory;
import org.apache.hc.client5.http.socket.PlainConnectionSocketFactory;
import org.apache.hc.client5.http.ssl.DefaultHostnameVerifier;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.client5.http.ssl.TrustAllStrategy;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.config.Registry;
import org.apache.hc.core5.http.config.RegistryBuilder;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.ssl.SSLContextBuilder;
import org.apache.hc.core5.util.Timeout;
import org.openhis.domain.crosssystem.dto.*;
import org.openhis.domain.crosssystem.enums.LisAgeUnit;
import org.openhis.domain.crosssystem.enums.PacsAgeUnit;
import org.springframework.stereotype.Component;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Component
public class CrossSystemSendApplyUtil {

    /**
     * 发送LIS申请
     *
     * @param lisApplyDto LIS申请参数
     */
    public void sendApplyToLis(LisApplyDto lisApplyDto) {
        // 读取配置参数
        String apiUrl = TenantOptionUtil.getOptionContent(TenantOptionDict.LIS_API_URL);
        String appId = TenantOptionUtil.getOptionContent(TenantOptionDict.LIS_APP_ID);
        String appSecret = TenantOptionUtil.getOptionContent(TenantOptionDict.LIS_APP_SECRET);
        if (StringUtils.isEmpty(apiUrl) || StringUtils.isEmpty(appId) || StringUtils.isEmpty(appSecret)) {
            throw new ServiceException("请在租户管理页面配置LIS相关接口参数");
        }
        // 作成申请参数
        LisPatientInfo lisPatientInfo = new LisPatientInfo()
                // 必填 【申请单号】 业务上需要保证唯一
                .setApplyNo(lisApplyDto.getApplyNo())
                // 必填 【患者编号】
                .setPatientNo(lisApplyDto.getPatientNo())
                // 必填 【病人类型】 门诊01 住院02 手动登记03 体检04
                .setPatientType(lisApplyDto.getPatientType() == null ? null : lisApplyDto.getPatientType().getCode())
                // 必填 【病人姓名】
                .setPatientName(lisApplyDto.getPatientName())
                // 必填 【病人性别】 未知01 男02 女03
                .setPatientSex(lisApplyDto.getPatientSex() == null ? null : lisApplyDto.getPatientSex().getCode())
                // 非必填 【联系电话】
                .setPatientMobile(lisApplyDto.getPatientMobile())
                // 必填 【申请日期】 格式：yyyy-MM-dd HH:mm:ss.S
                .setApplyDate(DateUtils.parseDateToStr("yyyy-MM-dd HH:mm:ss.S", lisApplyDto.getApplyDate()))
                // 必填 【申请医生姓名】
                .setApplyDoctor(lisApplyDto.getApplyDoctor())
                // 必填 【申请科室】
                .setApplyDept(lisApplyDto.getApplyDept())
                // 必填 【年龄】
                .setAge(lisApplyDto.getAge())
                // 必填 【年龄单位】 岁01
                .setAgeUnit(LisAgeUnit.YEAR.getCode())
                // 必填 【执行科室编码】
                .setExecDeptCode(lisApplyDto.getExecDeptCode())
                // 必填 【执行科室名称】
                .setExecDeptName(lisApplyDto.getExecDeptName())
                // 非必填 【身份证号码】
                .setIdCard(lisApplyDto.getIdCard())
                // 非必填 【病区ID】
                .setWardId(lisApplyDto.getWardId())
                // 必填 【病房号】
                .setRoomNo(lisApplyDto.getRoomNo())
                // 必填 【床位号】
                .setBedNo(lisApplyDto.getBedNo())
                // 非必填 【是否急诊】
                .setEmergency(lisApplyDto.getEmergency())
                // 非必填 【临床诊断】
                .setDiagnose(lisApplyDto.getDiagnose())
                // 必填 【外检FLG】 非外检0 外检1
                .setOutsideFlg(lisApplyDto.getOutsideFlg() == null ? null : lisApplyDto.getOutsideFlg().getCode())
                // 必填【申请部门编码】
                .setApplyDeptCode(lisApplyDto.getApplyDeptCode())
                // 必填【申请部门名称】
                .setApplyDeptName(lisApplyDto.getApplyDeptName());
        LisGroupInfo lisGroupInfo = new LisGroupInfo()
                // 必填 【检查项目编码】 多个用“+”连接
                .setGroupCode(lisApplyDto.getGroupList().stream().map(LisApplyGroupDto::getGroupCode)
                        .collect(Collectors.joining("+")))
                // 必填 【检查项目名称】多个用“+”连接
                .setGroupName(lisApplyDto.getGroupList().stream().map(LisApplyGroupDto::getGroupName)
                        .collect(Collectors.joining("+")));
        // 创建无视SSL验证的HttpClient
        CloseableHttpClient httpClient = createIgnoreSslHttpClient();
        CloseableHttpResponse response = null;
        // 发起HTTP请求
        try {
            HttpPost httpPost = new HttpPost(apiUrl);
            httpPost.setHeader("App-Id", appId);
            httpPost.setHeader("App-Secret", appSecret);
            Map<String, Object> requestUrlParam = new HashMap<>();
            requestUrlParam.put("patientInfo", lisPatientInfo);
            requestUrlParam.put("groupInfo", lisGroupInfo);
            String s = JSON.toJSONString(requestUrlParam);
            StringEntity stringEntity = new StringEntity(s, ContentType.APPLICATION_JSON);
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
            JSONObject object = JSON.parseObject(EntityUtils.toString(response.getEntity(), "utf-8"));
            // 获取结果CODE
            String code = String.valueOf(object.get("code"));

            if (!"100000".equals(code)) {
                log.error("LIS失败申请报文：" + s);
                throw new ServiceException("LIS申请返回失败信息：" + object);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ServiceException("LIS申请发生未知错误：" + e.getMessage());
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 发送PACS申请
     *
     * @param pacsApplyDto PACS申请参数
     */
    public void sendApplyToPacs(PacsApplyDto pacsApplyDto) {
        String apiUrl = TenantOptionUtil.getOptionContent(TenantOptionDict.PACS_API_URL);
        String appId = TenantOptionUtil.getOptionContent(TenantOptionDict.PACS_APP_ID);
        String appSecret = TenantOptionUtil.getOptionContent(TenantOptionDict.PACS_APP_SECRET);
        if (StringUtils.isEmpty(apiUrl) || StringUtils.isEmpty(appId) || StringUtils.isEmpty(appSecret)) {
            throw new ServiceException("请在租户管理页面配置PACS相关接口参数");
        }
        // 作成申请参数
        PacsPatientInfo pacsPatientInfo = new PacsPatientInfo()
                // 必填 【申请单号】 业务上需要保证唯一
                .setApplyNo(pacsApplyDto.getApplyNo())
                // 必填 【患者编号】
                .setPatientNo(pacsApplyDto.getPatientNo())
                // 必填 【患者类型】 门诊01 住院02 手动登记03 体检04
                .setPatientType(pacsApplyDto.getPatientType() == null ? null : pacsApplyDto.getPatientType().getCode())
                // 必填 【患者姓名】
                .setPatientName(pacsApplyDto.getPatientName())
                // 必填 【性别】 PACS中 男01 女02 未知03
                .setPatientSex(pacsApplyDto.getPatientSex() == null ? null : pacsApplyDto.getPatientSex().getCode())
                // 非必填 【联系电话】
                .setPatientMobile(pacsApplyDto.getPatientMobile())
                // 必填 【申请日期】 格式：yyyy-MM-dd HH:mm:ss
                .setApplyDate(DateUtils.parseDateToStr("yyyy-MM-dd HH:mm:ss", pacsApplyDto.getApplyDate()))
                // 必填 【申请医生姓名】
                .setApplyDoctorName(pacsApplyDto.getApplyDoctorName())
                // 必填 【申请医生编码】
                .setApplyDoctorCode(pacsApplyDto.getApplyDoctorCode())
                // 必填 【申请部门名称】
                .setApplyDeptName(pacsApplyDto.getApplyDeptName())
                // 必填 【申请部门编码】
                .setApplyDeptCode(pacsApplyDto.getApplyDeptCode())
                // 必填 【年龄】
                .setAge(pacsApplyDto.getAge() == null ? "" : pacsApplyDto.getAge().toString())
                // 必填 【年龄单位】 岁1
                .setAgeUnit(PacsAgeUnit.YEAR.getCode())
                // 必填 【执行科室编码】
                .setExecDeptCode(pacsApplyDto.getExecDeptCode())
                // 必填 【执行科室名称】
                .setExecDeptName(pacsApplyDto.getExecDeptName())
                // 必填 【检查部位】
                .setExamPart(pacsApplyDto.getExamPart())
                // 非必填 【身份证号】
                .setIdCard(pacsApplyDto.getIdCard())
                // 非必填 【病区ID】
                .setWardId(pacsApplyDto.getWardId())
                // 非必填 【病房号】
                .setRoomNo(pacsApplyDto.getRoomNo())
                // 非必填 【病床号】
                .setBedNo(pacsApplyDto.getBedNo())
                // 非必填 【是否急诊】
                .setEmergency(pacsApplyDto.getEmergency())
                // 非必填 【临床诊断】
                .setDiagnose(pacsApplyDto.getDiagnose());
        PacsGroupInfo pacsGroupInfo = new PacsGroupInfo()
                // 必填 【检查项目编码】
                .setGroupCode(pacsApplyDto.getGroupCode())
                // 必填 【检查项目名称】
                .setGroupName(pacsApplyDto.getGroupName());

        // 创建无视SSL验证的HttpClient
        CloseableHttpClient httpClient = createIgnoreSslHttpClient();
        CloseableHttpResponse response = null;
        // 发起HTTP请求
        try {
            HttpPost httpPost = new HttpPost(apiUrl);
            httpPost.setHeader("App-Id", appId);
            httpPost.setHeader("App-Secret", appSecret);
            Map<String, Object> requestUrlParam = new HashMap<>();
            requestUrlParam.put("patientInfo", pacsPatientInfo);
            requestUrlParam.put("groupInfo", pacsGroupInfo);
            String s = JSON.toJSONString(requestUrlParam);
            StringEntity stringEntity = new StringEntity(s, ContentType.APPLICATION_JSON);
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
            JSONObject object = JSON.parseObject(EntityUtils.toString(response.getEntity(), "utf-8"));
            // 获取结果CODE
            String code = String.valueOf(object.get("code"));
            if (!"100000".equals(code)) {
                log.error("PACS失败申请报文：" + s);
                throw new ServiceException("PACS申请返回失败信息：" + object);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ServiceException("PACS申请发生未知错误：" + e.getMessage());
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 创建无视SSL验证的HTTP客户端
     *
     * @return CloseableHttpClient实例
     */
    private CloseableHttpClient createIgnoreSslHttpClient() {
        try {
            // 创建信任所有证书的SSL上下文
            SSLContext sslContext = SSLContextBuilder.create()
                    .loadTrustMaterial(new TrustAllStrategy())
                    .build();

            // 使用显式创建的默认主机名验证器
            SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(
                    sslContext,
                    new DefaultHostnameVerifier());

            // 注册SSL socket factory
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.getSocketFactory())
                    .register("https", sslSocketFactory)
                    .build();

            // 创建连接管理器并设置socket factory registry
            BasicHttpClientConnectionManager connectionManager = new BasicHttpClientConnectionManager(socketFactoryRegistry);

            // 配置请求超时
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(Timeout.ofMilliseconds(5000))
                    .setResponseTimeout(Timeout.ofMilliseconds(3000))
                    .build();

            // 构建HttpClient
            return HttpClients.custom()
                    .setConnectionManager(connectionManager)
                    .setDefaultRequestConfig(requestConfig)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException("创建SSL忽略的HTTP客户端失败：" + e.getMessage(), e);
        }
    }
}
