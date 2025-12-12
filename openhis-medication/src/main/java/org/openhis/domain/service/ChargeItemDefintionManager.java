package org.openhis.domain.service;

import com.whale.common.constant.CommonConstants;
import com.whale.common.core.domain.R;
import com.whale.common.utils.MessageUtils;
import com.whale.common.utils.bean.BeanUtils;
import com.whale.common.utils.spring.SpringUtils;
import org.apache.ibatis.executor.BatchResult;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.GenericEventMessage;
import org.openhis.common.constant.PromptMsgConstant;
import org.openhis.domain.entity.ChargeItemDefinition;
import org.openhis.domain.entity.ItemUpFromDirectoryDto;
import org.openhis.domain.repository.IChargeItemDefinitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChargeItemDefintionManager {

    @Autowired
    IChargeItemDefinitionRepository chargeItemDefinitionRepository;

    /**
     * 添加药品/器材/诊疗的项目定价
     *
     * @param itemUpFromDirectoryDto 药品/器材/诊疗目录信息
     */
    public R<ChargeItemDefinition> addItem(ItemUpFromDirectoryDto itemUpFromDirectoryDto) {



        ChargeItemDefinition chargeItemDefinition = new ChargeItemDefinition();
        BeanUtils.copyProperties(itemUpFromDirectoryDto, chargeItemDefinition);

        List<ChargeItemDefinition> chargeItemDefinitions = new ArrayList<>();
        chargeItemDefinitions.add(chargeItemDefinition);
        List<BatchResult> batchResults = chargeItemDefinitionRepository.insertOrUpdate(chargeItemDefinitions);
        batchResults.forEach(batchResult -> {
            List<Object> parameterObjects = batchResult.getParameterObjects();
            org.springframework.beans.BeanUtils.copyProperties(parameterObjects, chargeItemDefinitions);
        });

        if (batchResults.size() > 0) {
            //这里是做完药品更新要做的事件监听
            EventBus eventBus = SpringUtils.getBean(EventBus.class);
            eventBus.publish(GenericEventMessage.asEventMessage(chargeItemDefinition));
            return R.ok(chargeItemDefinition, MessageUtils.createMessage(PromptMsgConstant.Common.M00002, new Object[] {""}));
        }else {
            return R.fail(null, MessageUtils.createMessage(PromptMsgConstant.Common.M00008, null));
        }
    }
}
