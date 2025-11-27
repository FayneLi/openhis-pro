package com.whale.admin.web.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 保存租户配置项详情Dto
 *
 * @author system
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class SaveTenantOptionDetailDto {

    /**
     * 名称
     */
    private Integer tenantId;

    /**
     * 内容
     */
    private List<TenantOptionDto> optionList;

}
