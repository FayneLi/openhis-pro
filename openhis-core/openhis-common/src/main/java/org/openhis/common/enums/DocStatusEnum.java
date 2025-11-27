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
public enum DocStatusEnum implements EnumInterface {
    DRAFT(0, "DRAFT", "草稿/暂存"),
    SAVED(1, "SAVED", "提交"),
    ARCHIVED(2, "ARCHIVED", "归档"),
    UPDATED(3, "UPDATED", "修改");
    @EnumValue
    private final Integer value;
    private final String code;
    private final String info;

    public static DocStatusEnum getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (DocStatusEnum val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}
