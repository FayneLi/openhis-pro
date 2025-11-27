package org.openhis.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.whale.common.enums.EnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TraceNoStatus implements EnumInterface {

    IN(1, "1", "进"),

    OUT(2, "2", "出"),;

    @EnumValue
    private final Integer value;
    private final String code;
    private final String info;

    public static TraceNoStatus getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (TraceNoStatus val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}
