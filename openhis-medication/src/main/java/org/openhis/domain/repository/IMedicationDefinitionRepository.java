package org.openhis.domain.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.openhis.domain.entity.MedicationDefinition;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface IMedicationDefinitionRepository extends BaseMapper<MedicationDefinition> {

}
