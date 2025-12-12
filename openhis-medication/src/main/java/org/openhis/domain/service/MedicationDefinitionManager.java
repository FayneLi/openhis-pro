package org.openhis.domain.service;


import com.whale.common.utils.spring.SpringUtils;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.executor.BatchResult;
import org.axonframework.eventhandling.EventBus;
import org.openhis.common.event.MedicationDefinitionCreatedEvent;
import org.openhis.domain.entity.MedicationDefinition;
import org.axonframework.eventhandling.GenericEventMessage;
import org.openhis.domain.repository.IMedicationDefinitionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicationDefinitionManager {

    @Autowired
    IMedicationDefinitionRepository medicationDefinitionRepository;

    public boolean validateEdit(Long medicationId) {
        return true;
    }

    public void importTemplate(HttpServletResponse response) {
    }

    public String create(MedicationDefinition medicationDefinition) {

        //需要更新后面的查询表，需要保证查询表主键与修改表主键一致
        List<MedicationDefinition> medicationDefinitionList=new ArrayList<>();
        medicationDefinitionList.add(medicationDefinition);
        List<BatchResult> batchResults = medicationDefinitionRepository.insertOrUpdate(medicationDefinitionList);
        batchResults.forEach(batchResult -> {
            List<Object> parameterObjects = batchResult.getParameterObjects();
            BeanUtils.copyProperties(parameterObjects, medicationDefinition);
        });
        MedicationDefinitionCreatedEvent mdcEvent = new MedicationDefinitionCreatedEvent();
        BeanUtils.copyProperties(medicationDefinition, mdcEvent);
        if (medicationDefinition.getId()>0){
            EventBus eventBus = SpringUtils.getBean(EventBus.class);
            eventBus.publish(GenericEventMessage.asEventMessage(mdcEvent));
            return "success";
        }else
        {
            return "failed";
        }
    }
}
