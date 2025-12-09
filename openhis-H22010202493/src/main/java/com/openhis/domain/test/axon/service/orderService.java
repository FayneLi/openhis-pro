package com.openhis.domain.test.axon.service;

import com.openhis.domain.test.axon.command.CreateOrderCommand;
import com.openhis.domain.test.axon.entity.ClassRoomDetils;
import com.whale.common.utils.uuid.UUID;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
public class orderService {

    private final CommandGateway commandGateway;

    // 注入CommandGateway
    public orderService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    // 同步发布命令（返回结果）
    public String createOrderSync(ClassRoomDetils classRoomDetils) {
        String orderId = UUID.randomUUID().toString();
        CreateOrderCommand command = new CreateOrderCommand(orderId, classRoomDetils);
        System.out.print("这是同步发布命令方法"+command.getClassRoomDetils().getName());
        // 同步等待命令执行结果（返回聚合根ID或业务结果）
        return commandGateway.sendAndWait(command);
    }

    // 异步发布命令（返回CompletableFuture）
//    public CompletableFuture<String> createOrderAsync(ClassRoomDetils classRoomDetils) {
//        String orderId = UUID.randomUUID().toString();
//        CreateOrderCommand command = new CreateOrderCommand(orderId, classRoomDetils);
//        return commandGateway.send(command); // 异步执行，结果通过Future获取
//    }

}
