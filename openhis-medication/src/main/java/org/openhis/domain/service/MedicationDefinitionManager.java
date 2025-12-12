package org.openhis.domain.service;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.whale.common.core.domain.R;
import com.whale.common.utils.AssignSeqUtil;
import com.whale.common.utils.ChineseConvertUtils;
import com.whale.common.utils.MessageUtils;
import com.whale.common.utils.spring.SpringUtils;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.executor.BatchResult;
import org.axonframework.eventhandling.EventBus;
import org.openhis.common.constant.PromptMsgConstant;
import org.openhis.common.enums.AssignSeqEnum;
import org.openhis.common.enums.PublicationStatus;
import org.openhis.common.event.MedicationDefinitionCreatedEvent;
import org.openhis.domain.entity.MedicationDefinition;
import org.axonframework.eventhandling.GenericEventMessage;
import org.openhis.domain.entity.MedicationManageUpDto;
import org.openhis.domain.repository.IMedicationDefinitionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicationDefinitionManager {

    @Resource
    private AssignSeqUtil assignSeqUtil;

    @Autowired
    IMedicationDefinitionRepository medicationDefinitionRepository;


    public boolean validateEdit(Long medicationId) {
        return true;
    }

    public void importTemplate(HttpServletResponse response) {
    }

    @Transactional(rollbackFor = Exception.class)
    public  R<MedicationDefinition>  create(MedicationManageUpDto medicationManageUpDto) {
        MedicationDefinition medicationDefinition = new MedicationDefinition();
        BeanUtils.copyProperties(medicationManageUpDto, medicationDefinition);
        medicationDefinition.setStatusEnum(PublicationStatus.ACTIVE.getValue());
        // 使用10位数基础采番
        String code = assignSeqUtil.getSeq(AssignSeqEnum.MEDICATION_NUM.getPrefix(), 10);
        medicationDefinition.setBusNo(code);
        // 拼音码
        medicationDefinition.setPyStr(ChineseConvertUtils.toPinyinFirstLetter(medicationDefinition.getName()));
        medicationDefinition
                .setMerchandisePyStr(ChineseConvertUtils.toPinyinFirstLetter(medicationDefinition.getMerchandiseName()));
        // 五笔码
        medicationDefinition.setWbStr(ChineseConvertUtils.toWBFirstLetter(medicationDefinition.getName()));
        medicationDefinition
                .setMerchandiseWbStr(ChineseConvertUtils.toWBFirstLetter(medicationDefinition.getMerchandiseName()));



        // 根据药品编码判断药品是否存在
        List<MedicationDefinition> medicationDefinitions =
                medicationDefinitionRepository.selectList(new LambdaQueryWrapper<MedicationDefinition>()
                        .eq(MedicationDefinition::getBusNo, medicationDefinition.getBusNo()));
        if (medicationDefinitions.size() > 0) {
            return R.fail(null, MessageUtils.createMessage(PromptMsgConstant.Common.M00008, null));
        }

        // 新增药品目录
        int insert = medicationDefinitionRepository.insert(medicationDefinition);
        medicationDefinition.setId(medicationDefinition.getId());

        if (insert != 1) {
            return R.fail(null, MessageUtils.createMessage(PromptMsgConstant.Common.M00008, null));
        }

        // 获取生成的主键值
//        Long generatedId = medicationDefinition.getId();
        // 将生成的 ID 存储到子表中
//        medicationDefinition.setMedicationDefId(generatedId);


        //需要更新后面的查询表，需要保证查询表主键与修改表主键一致
        List<MedicationDefinition> medicationDefinitionList=new ArrayList<>();
        medicationDefinitionList.add(medicationDefinition);
        List<BatchResult> batchResults = medicationDefinitionRepository.insertOrUpdate(medicationDefinitionList);
        batchResults.forEach(batchResult -> {
            List<Object> parameterObjects = batchResult.getParameterObjects();
            BeanUtils.copyProperties(parameterObjects, medicationDefinition);
        });

        if (medicationDefinition.getId()>0){
            //这里是做完药品更新要做的事件监听
            EventBus eventBus = SpringUtils.getBean(EventBus.class);
            eventBus.publish(GenericEventMessage.asEventMessage(medicationDefinition));

            return R.ok(medicationDefinition, MessageUtils.createMessage(PromptMsgConstant.Common.M00002, new Object[] {"药品目录"}));
        }else {
            return R.fail(null, MessageUtils.createMessage(PromptMsgConstant.Common.M00008, null));
        }
    }
}
