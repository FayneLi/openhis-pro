package com.openhis.domain.test.liteflow.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


import com.openhis.domain.test.liteflow.entity.ClassEntity;
import jakarta.annotation.Resource;
import org.axonframework.eventhandling.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.yomahub.liteflow.core.FlowExecutor;


@Controller
public class FlowExecutorTestController {

    @Resource
    private FlowExecutor flowExecutor;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap modelMap){
        try {
            ClassEntity context =new ClassEntity();
            context.setClassName("com.openhis.domain.test.liteflow.entity.ClassEntity");
            context.setPackageName("com.openhis.domain.test");

//            FlowExecutor flowExecutor = new FlowExecutor();
            System.out.println(flowExecutor.getLiteflowConfig().getRuleSource());
            //传输上下文
            flowExecutor.execute2Resp("mainChain",context,ClassEntity.class);
        }catch (Exception e) {

        }

        return "index";
    }


}
