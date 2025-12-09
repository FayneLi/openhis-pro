package com.openhis.domain.test.axon.Aggregate;

import com.openhis.domain.test.axon.command.CreateOrderCommand;
import com.openhis.domain.test.axon.entity.ClassRoomDetils;
import com.openhis.domain.test.axon.entity.Classroom;
import com.openhis.domain.test.axon.event.OrderCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

// 聚合根（订单）
@Aggregate
public class OrderAggregate {
    @AggregateIdentifier
    private String orderId;
    private ClassRoomDetils orderDetails;
    private String status;

    // 空构造函数（Axon要求）
    public OrderAggregate() {}

    // 命令处理：创建订单
    @CommandHandler
    public OrderAggregate(CreateOrderCommand command) {
        // 校验逻辑
        // 业务逻辑：创建订单并校验
        Classroom order = new Classroom(command.getId(), command.getClassRoomDetils());


        System.out.println("教室，ID: " + command.getId());
        System.out.println("教室详情: " + command.getClassRoomDetils().getName());
        System.out.println("教室号码: " + command.getClassRoomDetils().getNo());
        System.out.println("这是命令监听,我们需要在这里做数据的业务变更");
        command.getClassRoomDetils().setName("一年二班");
        command.getClassRoomDetils().setNo("102");
        System.out.println("业务变更结束");
        // 发布事件（应用事件到聚合根）
        apply(new OrderCreatedEvent(command.getId(), command.getClassRoomDetils()));
    }


//    @EventHandler
//    public void on(OrderCreatedEvent event) {
//        if (event.flag==true) {
//            return;
//        }
//        // 处理逻辑：如更新订单状态、发送通知
//        System.out.println("教室，ID: " + event.getId());
//        System.out.println("教室详情: " + event.getClassRoomDetils().getName());
//        System.out.println("教室号码: " + event.getClassRoomDetils().getNo());
//        event.flag=true;
//    }

    // 事件处理：更新聚合状态
    @EventSourcingHandler
    public void on(OrderCreatedEvent event) {
        this.orderId = event.getId();
        this.orderDetails = event.getClassRoomDetils();
        this.status = "1"; // 初始状态
        System.out.println("事件处理：更新聚合状态");
    }
}