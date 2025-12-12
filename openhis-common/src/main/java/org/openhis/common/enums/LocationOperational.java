/*
 * Copyright ©2023 CJB-CNIT Team. All rights reserved
 */
package org.openhis.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.whale.common.enums.EnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 操作状态
 *
 * @author zwh
 * @date 2025-03-31
 */
@Getter
@AllArgsConstructor
public enum LocationOperational implements EnumInterface {

    USE(1, "1", "使用"),

    NOT_USED(2, "2", "未使用");

    @EnumValue
    private final Integer value;
    private final String code;
    private final String info;

    public static LocationOperational getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (LocationOperational val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}
