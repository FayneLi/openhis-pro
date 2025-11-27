package org.openhis.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.whale.common.enums.EnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 体检结果
 * 
 * @author Thanking
 * @date 2025-10-21
 */
@Getter
@AllArgsConstructor
public enum PhysicalExamResult implements EnumInterface {
    /**
     * 未体检
     */
    NOT_EXAMINED(0, "0", "未体检"),
    /**
     * 体检不合格
     */
    EXAMINATION_FAILED(1, "1", "体检不合格"),
    /**
     * 体检合格
     */
    EXAMINATION_PASSED(2, "2", "体检合格");

    @EnumValue
    private final Integer value;
    private final String code;
    private final String info;

    public static PhysicalExamResult getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (PhysicalExamResult val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}
