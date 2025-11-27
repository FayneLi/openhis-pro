package com.whale.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whale.admin.domain.SysUserTenant;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户租户绑定表Mapper接口
 *
 * @author system
 */
@Mapper
public interface SysUserTenantMapper extends BaseMapper<SysUserTenant> {

}
