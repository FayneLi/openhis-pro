package org.openhis.domain.crosssystem.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * LIS申请单封装类
 *
 * @author system
 */
@Data
@Accessors(chain = true)
public class LisPatientInfo {

    /**
     * 必填 【申请单号】 业务上需要保证唯一
     */
    private String applyNo;
    /**
     * 必填 【患者编号】
     */
    private String patientNo;
    /**
     * 必填 【病人类型】 门诊01 住院02 手动登记03 体检04
     */
    private String patientType;
    /**
     * 必填 【病人姓名】
     */
    private String patientName;
    /**
     * 必填 【病人性别】 未知01 男02 女03
     */
    private String patientSex;
    /**
     * 非必填 【联系电话】
     */
    private String patientMobile;
    /**
     * 必填 【申请日期】 格式：yyyy-MM-dd HH:mm:ss.S
     */
    private String applyDate;
    /**
     * 必填 【申请医生姓名】
     */
    private String applyDoctor;
    /**
     * 必填 【申请科室】
     */
    private String applyDept;
    /**
     * 必填 【年龄】
     */
    private Integer age;
    /**
     * 必填 【年龄单位】 岁01
     */
    private String ageUnit;
    /**
     * 必填 【执行科室编码】
     */
    private String execDeptCode;
    /**
     * 必填 【执行科室名称】
     */
    private String execDeptName;
    /**
     * 非必填 【身份证号码】
     */
    private String idCard;
    /**
     * 非必填 【病区ID】
     */
    private String wardId;
    /**
     * 必填 【病房号】
     */
    private String roomNo;
    /**
     * 必填 【床位号】
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
     * 必填 【外检FLG】 非外检0 外检1
     */
    private Integer outsideFlg;

    /**
     * 必填【申请部门编码】
     */
    private String applyDeptCode;
    /**
     * 必填【申请部门名称】
     */
    private String applyDeptName;

}