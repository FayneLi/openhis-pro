package org.openhis.domain.test.axon;


import org.openhis.domain.test.axon.entity.ClassRoomDetils;

public class MedicationRequestCommand {



    // 1. 定义命令（命令携带操作数据）
    public class CreateOrderCommand {
        private final String id;
        private final ClassRoomDetils classRoomDetils;

        public CreateOrderCommand(String id,ClassRoomDetils classRoomDetils) {
            this.id = id;
            this.classRoomDetils = classRoomDetils;
        }

        // Getters
        public String getId() { return id; }
        public ClassRoomDetils getClassRoomDetils() { return classRoomDetils; }
    }





    // 2. 定义事件（事件记录状态变更）
    public class OrderCreatedEvent {
        private final String id;
        private final ClassRoomDetils classRoomDetils;

        public OrderCreatedEvent(String id, ClassRoomDetils classRoomDetils) {
            this.id = id;
            this.classRoomDetils = classRoomDetils;
        }

        // Getters
        public String getId() { return id; }
        public ClassRoomDetils getClassRoomDetils() { return classRoomDetils; }
    }




    // 3. 命令处理程序（接收命令并发布事件）
//    @CommandHandler
//    public void handle(CreateOrderCommand command) {
//        // 业务逻辑：创建订单并校验
//        Classroom classroom = new Classroom(command.getId(), command.getClassRoomDetils());
//        System.out.println("上面是业务创建实体类并校验，下面是发布事件的方法！！！！！");
//        // 发布事件（应用事件到聚合根）
//        apply(new OrderCreatedEvent(command.getId(), command.getClassRoomDetils()));
//    }


//    // 事件处理器1：处理订单创建事件
//    @Component
//    public class OrderEventHandler {
//        @EventHandler
//        public void on(OrderCreatedEvent event) {
//            // 处理逻辑：如更新订单状态、发送通知
//            System.out.println("订单创建成功，ID: " + event.getId());
//            System.out.println("订单详情: " + event.getClassRoomDetils());
//        }
//    }
//
//    // 事件处理器2：同一事件可被多个处理器监听（示例）
//    @Component
//    public class InventoryEventHandler {
//        @EventHandler
//        public void on(OrderCreatedEvent event) {
//            // 处理逻辑：如扣减库存
//            System.out.println("库存扣减，订单ID: " + event.getClassRoomDetils());
//        }
//    }


}
