/*
 * Copyright ©2023 CJB-CNIT Team. All rights reserved
 */
package org.openhis.common.enums;

import com.whale.common.enums.EnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 生成来源 | 适用医嘱请求和账单
 *
 * @author zwh
 * @date 2025-03-10
 */
@Getter
@AllArgsConstructor
public enum GenerateSource implements EnumInterface {

    /**
     * 医生开立
     */
    DOCTOR_PRESCRIPTION(1, "1", "医生开立"),

    /**
     * 护士划价
     */
    NURSE_PRICING(2, "2", "护士划价"),

    /**
     * 挂号登记
     */
    REGISTRATION_REGISTER(3, "3", "挂号登记"),

    /**
     * 医嘱执行
     */
    ORDER_EXECUTE(4, "4", "医嘱执行"),

    /**
     * 自动滚费
     */
    AUTO_ROLL_FEES(5, "5", "自动滚费");

    private final Integer value;
    private final String code;
    private final String info;

    public static GenerateSource getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (GenerateSource val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}
