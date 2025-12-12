package org.openhis.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.whale.common.enums.EnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LocationMode implements EnumInterface {
    INSTANCE(1, "instance", "具体"),

    KIND(2, "Kind", "种类");

    @EnumValue
    private final Integer value;
    private final String code;
    private final String info;

    public static LocationMode getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (LocationMode val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}
