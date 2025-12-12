package org.openhis.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.whale.common.enums.EnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 在校状态
 * 
 * @author Thanking
 * @date 2025-10-21
 */
@Getter
@AllArgsConstructor
public enum StudentStatus implements EnumInterface {
    /**
     * 在校
     */
    IN_SCHOOL(0, "0", "在校"),
    /**
     * 休学
     */
    ON_LEAVE(1, "1", "休学"),
    /**
     * 离校
     */
    LEFT_SCHOOL(2, "2", "离校");

    @EnumValue
    private final Integer value;
    private final String code;
    private final String info;

    public static StudentStatus getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (StudentStatus val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}
