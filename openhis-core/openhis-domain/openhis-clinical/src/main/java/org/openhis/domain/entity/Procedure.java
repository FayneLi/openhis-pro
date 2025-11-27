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
 * 手术与医嘱管理Entity实体
 *
 * @author system
 * @date 2025-02-20
 */
@Data
@TableName("cli_procedure")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class Procedure extends BaseEntity {

    /** ID */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /** 医嘱id */
    private Long requestId;

    /** 医嘱所在表 */
    private String requestTable;

    /** 当前状态 */
    private Integer statusEnum;

    /** 当前状态原因 */
    private String statusReasonText;

    /** 分类 */
    private Integer categoryEnum;

    /** 手术编码 */
    private String procedureCode;

    /** 就诊Id */
    private Long encounterId;

    /** 患者Id */
    private Long patientId;

    /** 发生日期和时间 */
    private Date occurrenceTime;

    /** 发生时期 */
    private String occurrencePeriod;

    /** 发生年龄 */
    private String occurrenceAge;

    /** 发生时间描述 */
    private String occurrenceText;

    /** 记录日期 */
    private Date recordedTime;

    /** 记录人 */
    private Long recorderId;

    /** 是否有报告 */
    private Integer reportFlag;

    /** 报告证据 */
    private Long reportedPatientId;

    /** 执行科室 */
    private Long orgId;

    /** 执行位置 */
    private Long locationId;

    /** 理由 */
    private String reasonText;

    /** 身体部位 */
    private String bodySiteJson;

    /** 身体结构 */
    private Long bodyStructureId;

    /** 结果 */
    private String resultText;

    /** 报告 */
    private String reportJson;

    /** 并发症 */
    private String complicationJson;

    /** 跟进指南 */
    private String followUpJson;

    /** 组号 */
    private Long groupId;

    /** 取消执行id */
    private Long refundId;
}
