package com.openhis.domain.test.axon.handle;

import com.openhis.domain.test.axon.event.OrderCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

// 事件处理器1：处理订单创建事件
//@ProcessingGroup("com.openhis.domain.test.handle")
@Component
public class OrderEventHandler {
    @EventHandler
    public void on(OrderCreatedEvent event) {
        if (event.flag==true) {
            return;
        }
        // 处理逻辑：如更新订单状态、发送通知
        System.out.println("教室，ID: " + event.getId());
        System.out.println("教室详情: " + event.getClassRoomDetils().getName());
        System.out.println("教室号码: " + event.getClassRoomDetils().getNo());
        event.flag=true;
    }
}