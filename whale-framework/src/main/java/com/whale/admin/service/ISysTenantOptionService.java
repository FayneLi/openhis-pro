package com.whale.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.whale.admin.domain.SysTenantOption;
import com.whale.admin.web.dto.SaveTenantOptionDetailDto;
import com.whale.admin.web.dto.TenantOptionDto;
import com.whale.common.core.domain.R;

import java.util.List;
import java.util.Map;

/**
 * 租户配置项表Service接口
 *
 * @author system
 */
public interface ISysTenantOptionService extends IService<SysTenantOption> {

    /**
     * 查询全部租户配置项
     *
     * @param tenantId 租户ID
     * @return 全部租户配置项
     */
    Map<String, String> getAllTenantOption(Integer tenantId);

    /**
     * 查询租户配置项详情列表
     *
     * @param tenantId 租户ID
     * @return 租户配置项详情列表
     */
    List<TenantOptionDto> getTenantOptionDetailList(Integer tenantId);

    /**
     * 保存租户配置项详情列表
     *
     * @param saveTenantOptionDetailDto 参数DTO
     * @return 结果
     */
    R<?> saveTenantOptionDetailList(SaveTenantOptionDetailDto saveTenantOptionDetailDto);

    /**
     * 查询租户配置项前端form表单列表
     *
     * @return 租户配置项前端form表单列表
     */
    List<TenantOptionDto> getTenantOptionFormList();
}
