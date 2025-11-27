package org.openhis.domain.crosssystem.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.openhis.domain.crosssystem.enums.PacsPatientSex;
import org.openhis.domain.crosssystem.enums.PacsPatientType;

import java.util.Date;

/**
 * PACS申请参数
 *
 * @author system
 */
@Data
@Accessors(chain = true)
public class PacsApplyDto {

    /**
     * 必填 【申请单号】 业务上需要保证唯一
     */
    private String applyNo;
    /**
     * 必填 【患者编号】
     */
    private String patientNo;
    /**
     * 必填 【患者类型】 门诊01 住院02 手动登记03 体检04
     */
    private PacsPatientType patientType;
    /**
     * 必填 【患者姓名】
     */
    private String patientName;
    /**
     * 必填 【性别】 PACS中 男01 女02 未知03
     */
    private PacsPatientSex patientSex;
    /**
     * 非必填 【联系电话】
     */
    private String patientMobile;
    /**
     * 必填 【申请日期】 格式：yyyy-MM-dd HH:mm:ss
     */
    private Date applyDate;
    /**
     * 必填 【申请医生姓名】
     */
    private String applyDoctorName;
    /**
     * 必填 【申请医生编码】
     */
    private String applyDoctorCode;
    /**
     * 必填 【申请部门名称】
     */
    private String applyDeptName;
    /**
     * 必填 【申请部门编码】
     */
    private String applyDeptCode;
    /**
     * 必填 【年龄】
     */
    private Integer age;
    /**
     * 必填 【执行科室编码】
     */
    private String execDeptCode;
    /**
     * 必填 【执行科室名称】
     */
    private String execDeptName;
    /**
     * 必填 【检查部位】
     */
    private String examPart;
    /**
     * 非必填 【身份证号】
     */
    private String idCard;
    /**
     * 非必填 【病区ID】
     */
    private String wardId;
    /**
     * 非必填 【病房号】
     */
    private String roomNo;
    /**
     * 非必填 【病床号】
     */
    private String bedNo;
    /**
     * 非必填 【是否急诊】
     */
    private String emergency;
    /**
     * 非必填 【临床诊断】
     */
    private String diagnose;

    /**
     * 必填 【检查项目编码】
     */
    private String groupCode;

    /**
     * 必填 【检查项目名称】
     */
    private String groupName;

}