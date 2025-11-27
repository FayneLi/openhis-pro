package com.whale.admin.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 租户配置项表
 *
 * @author system
 */
@Data
@TableName("sys_tenant_option")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class SysTenantOption implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID（使用数据库序列生成）
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 租户ID
     */
    private Integer tenantId;

    /**
     * 配置项编码
     */
    private String optionCode;

    /**
     * 配置项内容
     */
    private String optionContent;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新人
     */
    @TableField(fill = FieldFill.UPDATE)
    private String updateBy;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

}
