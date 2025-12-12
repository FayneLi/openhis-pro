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
 * 科室文书对照表
 *
 * @author wanghaiming
 * @date 2025-08-14
 */
@Data
@TableName("doc_definition_organization")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class DocDefinitionOrganization extends BaseEntity {

    /**
     * ID
     */
    @TableId(type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private Long definitionId;
    private String busNo;
    private Long organizationId;

}
