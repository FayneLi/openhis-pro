package org.openhis.domain.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.openhis.domain.entity.DeviceDefinition;
import org.springframework.stereotype.Repository;

@Repository
public interface IDeviceDefinitionRepository extends BaseMapper<DeviceDefinition> {
}
