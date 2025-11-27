package org.openhis.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.whale.common.enums.EnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EncounterActivityStatus implements EnumInterface {
    PLANNED(1, "planned", "已安排"),

    ACTIVE(2, "active", "使用中"),

    RESERVED(3, "reserved", "已保留"),

    COMPLETED(4, "completed", "已完成");

    @EnumValue
    private final Integer value;
    private final String code;
    private final String info;

    public static EncounterActivityStatus getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (EncounterActivityStatus val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}
