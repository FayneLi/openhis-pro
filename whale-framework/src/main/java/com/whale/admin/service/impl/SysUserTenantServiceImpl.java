package com.whale.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whale.admin.domain.SysUserTenant;
import com.whale.admin.mapper.SysUserTenantMapper;
import com.whale.admin.service.ISysUserTenantService;
import org.springframework.stereotype.Service;

/**
 * 用户租户绑定表Service业务层处理
 *
 * @author system
 */
@Service
public class SysUserTenantServiceImpl extends ServiceImpl<SysUserTenantMapper, SysUserTenant>
        implements ISysUserTenantService {

}
