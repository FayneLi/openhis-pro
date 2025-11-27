package org.openhis.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whale.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 公费医疗学生名单管理表Entity实体
 *
 * @author system
 * @date 2025-02-20
 */
@Data
@TableName("adm_patient_student")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class PatientStudent extends BaseEntity {

    /** ID */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /** 姓名 */
    private String name;

    /** 拼音码 */
    private String pyStr;

    /** 五笔码 */
    private String wbStr;

    /** 性别 */
    private Integer gender;

    /** 年龄 */
    private Integer age;

    /** 学号 */
    private String studentId;

    /** 身份证号 */
    private String idNumber;

    /** 电话 */
    private String phone;

    /** 学院 */
    private String college;

    /** 专业 */
    private String major;

    /** 学历层次（0预科生1本科生2硕士研究生3博士研究生） */
    private Integer educationLevel;

    /** 入校时间 */
    private Date enrollmentDate;

    /** 离校时间 */
    private Date graduationDate;

    /** 年级 */
    private String grade;

    /** 学习形式（1全日制2非全日制） */
    private Integer studyMode;

    /** 在校状态（0在校1休学2离校） */
    private Integer studentStatus;

    /** 体检结果（0未体检1体检不合格2体检合格） */
    private Integer physicalExamResult;

    /** 辅导员 */
    private String counselor;

    /** 辅导员电话 */
    private String counselorPhone;

    /** 患者ID */
    private Long patientId;

}