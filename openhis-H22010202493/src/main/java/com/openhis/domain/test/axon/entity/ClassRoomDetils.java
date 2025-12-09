package com.openhis.domain.test.axon.entity;

import lombok.Data;

@Data
public class ClassRoomDetils {
    private String no;
    private String name;

    public ClassRoomDetils(String no, String name) {
        this.no = no;
        this.name = name;
    }
}
