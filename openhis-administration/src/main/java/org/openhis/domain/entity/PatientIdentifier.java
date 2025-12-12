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
 * 患者标识管理Entity实体
 *
 * @author system
 * @date 2025-02-20
 */
@Data
@TableName("adm_patient_identifier")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class PatientIdentifier extends BaseEntity {

    /** ID */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /** 患者ID */
    private Long patientId;

    /** 标识类型编码 */
    private String typeCode;

    /** 标识号 */
    private String identifierNo;

    /** 标识状态枚举 */
    private Integer stateEnum;

    /** 有效时间Start */
    private Date startTime;

    /** 有效时间end */
    private Date endTime;

}
