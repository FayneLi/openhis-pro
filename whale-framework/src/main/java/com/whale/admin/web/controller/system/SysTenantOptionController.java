package com.whale.admin.web.controller.system;

import com.whale.admin.service.ISysTenantOptionService;
import com.whale.admin.web.dto.SaveTenantOptionDetailDto;
import com.whale.admin.web.dto.TenantOptionDto;
import com.whale.common.core.application.BaseController;
import com.whale.common.core.domain.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 租户配置项信息controller
 *
 * @author system
 */
@RestController
@RequestMapping("/system/tenant-option")
public class SysTenantOptionController extends BaseController {
    @Autowired
    private ISysTenantOptionService sysTenantOptionService;

    /**
     * 查询租户配置项详情列表
     *
     * @param tenantId 租户ID
     * @return 租户配置项详情列表
     */
    @PreAuthorize("@ss.hasPermi('system:tenant:operate')")
    @GetMapping("/detail-list/{tenantId}")
    public R<List<TenantOptionDto>> getTenantOptionDetailList(@PathVariable Integer tenantId) {
        return R.ok(sysTenantOptionService.getTenantOptionDetailList(tenantId));
    }

    /**
     * 保存租户配置项详情列表
     *
     * @param saveTenantOptionDetailDto 参数DTO
     * @return 结果
     */
    @PreAuthorize("@ss.hasPermi('system:tenant:operate')")
    @PostMapping("/detail-list")
    public R<?> saveTenantOptionDetailList(@RequestBody SaveTenantOptionDetailDto saveTenantOptionDetailDto) {
        return sysTenantOptionService.saveTenantOptionDetailList(saveTenantOptionDetailDto);
    }

    /**
     * 查询租户配置项前端form表单列表
     *
     * @return 租户配置项前端form表单列表
     */
    @PreAuthorize("@ss.hasPermi('system:tenant:operate')")
    @GetMapping("/form-list")
    public R<?> getTenantOptionFormList() {
        return R.ok(sysTenantOptionService.getTenantOptionFormList());
    }
}
