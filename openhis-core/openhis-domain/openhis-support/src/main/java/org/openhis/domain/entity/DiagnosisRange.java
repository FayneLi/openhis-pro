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
 * 诊断归属绑定Entity实体
 *
 * @author system
 * @date 2025-02-20
 */
@Data
@TableName("support_diagnosis_range")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class DiagnosisRange extends BaseEntity {

    /** ID */
    @TableId(type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /** 用户ID或科室/机构ID */
    private Long objectId;

    /** 诊断定义ID */
    private Long definitionId;

    /** 绑定类型 */
    private Integer bindingEnum;

}
