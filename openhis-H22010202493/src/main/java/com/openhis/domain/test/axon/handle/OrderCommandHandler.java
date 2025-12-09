//package com.openhis.domain.test.handle;
//
//import com.openhis.domain.test.command.CreateOrderCommand;
//import com.openhis.domain.test.entity.ClassRoomDetils;
//import com.openhis.domain.test.entity.Classroom;
//import com.openhis.domain.test.event.OrderCreatedEvent;
//import org.axonframework.commandhandling.CommandHandler;
//import org.axonframework.eventhandling.EventBus;
//import org.axonframework.eventhandling.GenericEventMessage;
//import org.springframework.stereotype.Component;
//
//import static org.axonframework.modelling.command.AggregateLifecycle.apply;
//@Component
//public class OrderCommandHandler {
//
//    private final EventBus eventBus;
//
//    public OrderCommandHandler(EventBus eventBus) {
//        this.eventBus = eventBus;
//    }
//
//    // 3. 命令处理程序（接收命令并发布事件）
//    @CommandHandler
//    public void handle(CreateOrderCommand command) {
//        // 业务逻辑：创建订单并校验
//        Classroom order = new Classroom(command.getId(), command.getClassRoomDetils());
//
//
//        System.out.println("教室，ID: " + command.getId());
//        System.out.println("教室详情: " + command.getClassRoomDetils().getName());
//        System.out.println("教室号码: " + command.getClassRoomDetils().getNo());
//        System.out.println("这是命令监听,我们需要在这里做数据的业务变更");
//        command.getClassRoomDetils().setName("一年二班");
//        command.getClassRoomDetils().setNo("102");
//        System.out.println("业务变更结束");
//        // 发布事件（应用事件到聚合根）
////        apply(new OrderCreatedEvent(command.getId(), command.getClassRoomDetils()));
//        //发布事件不用聚合根
//        eventBus.publish(GenericEventMessage.asEventMessage(
//                new OrderCreatedEvent("ORDER_001", new ClassRoomDetils("101", "一年一班"))
//        ));
//    }
//}
