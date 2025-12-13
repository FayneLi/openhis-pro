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
import org.openhis.common.enums.ConditionCode;
import org.openhis.domain.entity.ChargeItemDefDetail;
import org.openhis.domain.entity.ChargeItemDefinition;
import org.openhis.domain.entity.ItemUpFromDirectoryDto;
import org.openhis.domain.repository.IChargeItemDefinitionDetailRepository;
import org.openhis.domain.repository.IChargeItemDefinitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChargeItemDefintionManager {

    @Autowired
    IChargeItemDefinitionRepository chargeItemDefinitionRepository;

    @Autowired
    IChargeItemDefinitionDetailRepository chargeItemDefinitionDetailRepository;

    /**
     * 添加药品/器材/诊疗的项目定价
     *
     * @param itemUpFromDirectoryDto 药品/器材/诊疗目录信息
     */
    public R<ChargeItemDefinition> addItem(ItemUpFromDirectoryDto itemUpFromDirectoryDto) {



        ChargeItemDefinition chargeItemDefinition = new ChargeItemDefinition();
        BeanUtils.copyProperties(itemUpFromDirectoryDto, chargeItemDefinition);


        int inserted = chargeItemDefinitionRepository.insert(chargeItemDefinition);

        if (inserted > 0) {
            //这里是做完药品更新要做的事件监听
            EventBus eventBus = SpringUtils.getBean(EventBus.class);
            eventBus.publish(GenericEventMessage.asEventMessage(chargeItemDefinition));
            return R.ok(chargeItemDefinition, MessageUtils.createMessage(PromptMsgConstant.Common.M00002, new Object[] {""}));
        }else {
            return R.fail(null, MessageUtils.createMessage(PromptMsgConstant.Common.M00008, null));
        }
    }


    /**
     * 添加药品/器材/诊疗的项目定价
     *
     * @param itemUpFromDirectoryDto 药品/器材/诊疗目录信息
     */
    public R<List<ChargeItemDefDetail>> addItemDetail(ItemUpFromDirectoryDto itemUpFromDirectoryDto) {
        List<ChargeItemDefDetail> chargeItemDefDetails = new ArrayList<>();
        List<ChargeItemDefDetail> shargeItemDefDetails = new ArrayList<>();
        // 诊疗没有购入价
        if (!CommonConstants.TableName.WOR_ACTIVITY_DEFINITION.equals(itemUpFromDirectoryDto.getInstanceTable())) {
            // 插入购入价
            ChargeItemDefDetail chargeItemDefDetail1 = new ChargeItemDefDetail();
            chargeItemDefDetail1.setDefinitionId(itemUpFromDirectoryDto.getDefinitionId())
                    // 条件:采购
                    .setConditionCode(ConditionCode.PURCHASE.getCode())
                    // 购入价
                    .setAmount(itemUpFromDirectoryDto.getPurchasePrice());
            shargeItemDefDetails.add(chargeItemDefDetail1);
        }

        // 插入零售价
        ChargeItemDefDetail chargeItemDefDetail2 = new ChargeItemDefDetail();
        chargeItemDefDetail2.setDefinitionId(itemUpFromDirectoryDto.getDefinitionId())
                // 条件:单位
                .setConditionCode(ConditionCode.UNIT.getCode())
                // 单位枚举
                .setConditionValue(itemUpFromDirectoryDto.getUnitCode())
                // 零售价
                .setAmount(itemUpFromDirectoryDto.getRetailPrice());

        shargeItemDefDetails.add(chargeItemDefDetail2);

        // 插入最高零售价
        ChargeItemDefDetail chargeItemDefDetail3 = new ChargeItemDefDetail();
        chargeItemDefDetail3.setDefinitionId(itemUpFromDirectoryDto.getDefinitionId())
                // 条件:限制
                .setConditionCode(ConditionCode.LIMIT.getCode())
                // 最高零售价
                .setAmount(itemUpFromDirectoryDto.getMaximumRetailPrice());

        shargeItemDefDetails.add(chargeItemDefDetail3);
        List<BatchResult> batchResults = chargeItemDefinitionDetailRepository.insertOrUpdate(shargeItemDefDetails);
        batchResults.forEach(batchResult -> {
            List<Object> parameterObjects = batchResult.getParameterObjects();
            org.springframework.beans.BeanUtils.copyProperties(parameterObjects, chargeItemDefDetails);
        });
        if (batchResults.size() > 0) {
            return R.ok(chargeItemDefDetails, MessageUtils.createMessage(PromptMsgConstant.Common.M00002, new Object[] {""}));
        }else {
            return R.fail(null, MessageUtils.createMessage(PromptMsgConstant.Common.M00008, null));
        }

    }
}
