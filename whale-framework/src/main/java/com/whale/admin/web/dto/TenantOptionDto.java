package com.whale.admin.web.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 租户配置项Dto
 *
 * @author system
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class TenantOptionDto {

    /**
     * 编码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 内容
     */
    private String content;

}
