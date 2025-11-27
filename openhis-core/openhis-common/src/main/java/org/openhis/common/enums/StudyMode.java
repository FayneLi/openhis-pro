package org.openhis.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.whale.common.enums.EnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 学习形式
 * 
 * @author Thanking
 * @date 2025-10-21
 */
@Getter
@AllArgsConstructor
public enum StudyMode implements EnumInterface {
    /**
     * 全日制
     */
    FULL_TIME(1, "1", "全日制"),
    /**
     * 非全日制
     */
    PART_TIME(2, "2", "非全日制");

    @EnumValue
    private final Integer value;
    private final String code;
    private final String info;

    public static StudyMode getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (StudyMode val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}
