package org.openhis.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.whale.common.enums.EnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LocationStatus implements EnumInterface {

    ACTIVE(1, "active", "启用"),

    INACTIVE(2, "inactive", "停用"),

    SUSPENDED(3, "suspended", "临时停用"),

    ARRANGE(4, "arrange", "整理"),

    OCCUPY(5, "occupy", "占用"),

    IDLE(6, "idle", "空闲"),

    POLLUTION(7, "pollution", "污染"),

    ISOLATE(8, "isolate", "隔离");

    @EnumValue
    private final Integer value;
    private final String code;
    private final String info;

    public static LocationStatus getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (LocationStatus val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}
