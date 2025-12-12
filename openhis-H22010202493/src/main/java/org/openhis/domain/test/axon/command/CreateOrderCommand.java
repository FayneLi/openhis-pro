package org.openhis.domain.test.axon.command;


import org.openhis.domain.test.axon.entity.ClassRoomDetils;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

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