package org.openhis.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.whale.common.enums.EnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 优先级
 */
@Getter
@AllArgsConstructor
public enum PriorityLevel implements EnumInterface {

    NOT_URGENT(1, "NU", "不紧急"),

    ORDINARY(2, "OR", "普通"),

    PRIORITY(3, "PR", "优先"),

    EMERGENCY(4, "EM", "紧急"),

    DANGER(5, "DA", "危");

    @EnumValue
    private final Integer value;
    private final String code;
    private final String info;

    public static PriorityLevel getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (PriorityLevel val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}
