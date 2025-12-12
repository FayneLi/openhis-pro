package org.openhis.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.whale.common.enums.EnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 公费比例类型
 * 
 * @author Thanking
 * @date 2025-10-22
 */
@Getter
@AllArgsConstructor
public enum GfRatioType implements EnumInterface {
    /**
     * 大项比例
     */
    TYPE_RATIO(1, "1", "大项比例"),
    /**
     * 单项比例
     */
    INDIVIDUAL_RATIO(2, "2", "单项比例");

    @EnumValue
    private final Integer value;
    private final String code;
    private final String info;

    public static GfRatioType getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (GfRatioType val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}
