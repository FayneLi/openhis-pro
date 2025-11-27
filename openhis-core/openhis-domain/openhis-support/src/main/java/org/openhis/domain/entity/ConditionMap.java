package org.openhis.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.whale.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 新增国临码功能单表增删改查
 * @author ws
 * @date 2025-10-15
 */
@Data
@TableName("support_condition_map")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class ConditionMap extends BaseEntity {
    /** ID */
    @TableId(type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /** 国临编码 */
    private String glNo;

    /** 国临name */
    private String glName;

    /** 医保编码 */
    private String icd10No;

    /** 医保name */
    private String icd10Name;

}