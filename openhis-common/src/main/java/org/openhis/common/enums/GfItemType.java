package org.openhis.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.whale.common.enums.EnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 公费项目分类
 * 
 * @author Thanking
 * @date 2025-10-24
 */
@Getter
@AllArgsConstructor
public enum GfItemType implements EnumInterface {
    /**
     * 药品
     */
    MEDICATION(1, "1", "药品"),
    /**
     * 诊疗
     */
    ACTIVITY(2, "2", "诊疗");

    @EnumValue
    private final Integer value;
    private final String code;
    private final String info;

    public static GfItemType getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (GfItemType val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}
