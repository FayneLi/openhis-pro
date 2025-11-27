package org.openhis.domain.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.openhis.domain.entity.MedicationDefinition;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedicationDefinitionRepository extends BaseMapper<MedicationDefinition> {
}
