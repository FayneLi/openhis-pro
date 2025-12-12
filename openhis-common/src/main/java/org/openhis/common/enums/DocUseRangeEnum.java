package org.openhis.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.whale.common.enums.EnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 就诊类型
 */
@Getter
@AllArgsConstructor
public enum DocUseRangeEnum implements EnumInterface {
    //    使用范围 0-暂不使用 1-全院使用 2-指定科室使用 3-个人使用
    NO_IN_USE(0, "NO_IN_USE", "暂不使用"),

    ALL_HOSPITAL_USE(1, "ALL_HOSPITAL_USE", "全院使用"),

    DEPT_USE(2, "DEPT_USE", "指定科室使用"),
    USE_BY_SELF(3, "USE_BY_SELF", "个人使用");

    @EnumValue
    private final Integer value;
    private final String code;
    private final String info;

    public static DocUseRangeEnum getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (DocUseRangeEnum val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}
