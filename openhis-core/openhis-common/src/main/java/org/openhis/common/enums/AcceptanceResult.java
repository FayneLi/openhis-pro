/*
 * Copyright ©2023 CJB-CNIT Team. All rights reserved
 */
package org.openhis.common.enums;

import com.whale.common.enums.EnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 验收结果
 *
 * @author yuxj
 * @date 2025-07-29
 */
@Getter
@AllArgsConstructor
public enum AcceptanceResult implements EnumInterface {


    /**
     * 合格
     */
    QUALIFIED(1, "1","合格"),
    /**
     * 不合格
     */
    UNQUALIFIED(2, "2","不合格");

    private Integer value;
    private String code;
    private String info;

    public static AcceptanceResult getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (AcceptanceResult val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}
