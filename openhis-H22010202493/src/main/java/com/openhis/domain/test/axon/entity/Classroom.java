package com.openhis.domain.test.axon.entity;

import lombok.Data;

@Data
public class Classroom {

    private String classroomId;

    private ClassRoomDetils classRoomDetils;

    public Classroom(String classroomId, ClassRoomDetils classRoomDetils) {
        this.classroomId = classroomId;
        this.classRoomDetils = classRoomDetils;
    }

    //    private Student studentDetails;
//
//    private Teacher teacherDetails;

}
