package com.openhis.domain.test.axon.event;


import com.openhis.domain.test.axon.entity.ClassRoomDetils;

// 2. 定义事件（事件记录状态变更）
    public class OrderCreatedEvent {
        private final String id;
        private final ClassRoomDetils classRoomDetils;
        public Boolean flag;

        public OrderCreatedEvent(String id, ClassRoomDetils classRoomDetils) {
            this.id = id;
            this.classRoomDetils = classRoomDetils;
            this.flag = false;



        }

        // Getters
        public String getId() { return id; }
        public ClassRoomDetils getClassRoomDetils() { return classRoomDetils; }
        public Boolean getFlag() { return flag; }
        public void setFlag(Boolean flag) { this.flag = flag; }
    }