package org.openhis.domain.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.openhis.domain.entity.ActivityDefinition;
import org.springframework.stereotype.Repository;

@Repository
public interface IActivityDefinitionRepository extends BaseMapper<ActivityDefinition> {
}
