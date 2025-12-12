package org.openhis.domain.test.liteflow.component;

import org.openhis.domain.test.liteflow.entity.ClassEntity;
import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.annotation.LiteflowMethod;
import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.enums.LiteFlowMethodEnum;

@LiteflowComponent
public class InitCmps {

    @LiteflowMethod(value = LiteFlowMethodEnum.PROCESS, nodeId = "init")
    public void processCheckCmp(NodeComponent bindCmp){
        //拿到请求参数
        ClassEntity req = bindCmp.getRequestData();
        //参数验证完成
    }

    @LiteflowMethod(value = LiteFlowMethodEnum.PROCESS, nodeId = "initCl")
    public void processSlotInitCmp(NodeComponent bindCmp){
        //把主要参数冗余到slot里
        ClassEntity req = bindCmp.getRequestData();
        ClassEntity context = bindCmp.getContextBean(ClassEntity.class);
        context.setClassName(req.getClassName());
        context.setPackageName(req.getPackageName());
    }
}
