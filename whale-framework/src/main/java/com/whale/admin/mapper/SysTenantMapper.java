package com.whale.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whale.admin.domain.SysTenant;
import org.apache.ibatis.annotations.Mapper;

/**
 * 租户信息表Mapper接口
 *
 * @author system
 */
@Mapper
public interface SysTenantMapper extends BaseMapper<SysTenant> {

}
