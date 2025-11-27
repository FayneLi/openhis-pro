/*
 * Copyright ©2023 CJB-CNIT Team. All rights reserved
 */
package org.openhis.common.enums;

import com.whale.common.enums.EnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 包装情况
 *
 * @author yuxj
 * @date 2025-07-29
 */
@Getter
@AllArgsConstructor
public enum PackagingCondition implements EnumInterface {

    /**
     * 包装完好
     */
    INTACT_PACKAGING(1, "1","包装完好"),
    /**
     * 包装破损
     */
    DAMAGED_PACKAGING(2, "2","包装破损"),
    /**
     * 包装损坏
     */
    SEVERELY_DAMAGED_PACKAGING(3, "3","包装损坏");

    private Integer value;
    private String code;
    private String info;

    public static PackagingCondition getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (PackagingCondition val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}
