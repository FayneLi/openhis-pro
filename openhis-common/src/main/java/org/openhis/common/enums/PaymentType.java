/*
 * Copyright ©2023 CJB-CNIT Team. All rights reserved
 */
package org.openhis.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.whale.common.enums.EnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

/**
 * PaymentType (0: MEMBER_FIRST; 1: MEMBER_SECOND;)
 *
 * @author SunJQ
 * @date 2025-03-29
 */
@Getter
@AllArgsConstructor
public enum PaymentType implements EnumInterface {

    /**
     * 付费
     */
    PAY(0, "0", "付费", BigDecimal.ONE),
    /**
     * 退费
     */
    UN_PAY(1, "0", "退费", new BigDecimal("-1"));

    @EnumValue
    private Integer value;
    private String code;
    private String info;
    private BigDecimal multiplier;

    public static PaymentType getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (PaymentType val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}
