package org.openhis.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.whale.common.enums.EnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 绑定类型
 */
@Getter
@AllArgsConstructor
public enum BindingType implements EnumInterface {

    PERSONAL(1, "personal", "个人"),

    ORGANIZATION(2, "organization", "科室"),

    HOSPITAL(3, "hospital", "全院");

    @EnumValue
    private final Integer value;
    private final String code;
    private final String info;

    public static BindingType getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (BindingType val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}
