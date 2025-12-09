package com.openhis.domain.test.axon.handle;

import com.openhis.domain.test.axon.event.OrderCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

// 事件处理器2：同一事件可被多个处理器监听（示例）
    @Component
    public class InventoryEventHandler {
        @EventHandler
        public void on(OrderCreatedEvent event) {
            if (event.flag==true) {
                return;
            }
            // 处理逻辑：如扣减库存
            System.out.println("订单ID: " + event.getClassRoomDetils());
            event.flag=true;
        }

    }