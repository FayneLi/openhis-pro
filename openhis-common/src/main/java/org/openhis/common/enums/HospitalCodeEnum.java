/*
 * Copyright ©2023 CJB-CNIT Team. All rights reserved
 */
package org.openhis.common.enums;

import com.whale.common.enums.EnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 医院编码枚举
 *
 * @author zwh
 * @date 2025-06-24
 */
@Getter
@AllArgsConstructor
public enum HospitalCodeEnum implements EnumInterface {

    /**
     * 长大
     */
    CCU(1, "H22010200672", "长大"),

    /**
     * 农大
     */
    JLAU(2, "H22017200667", "农大"),;

    private Integer value;
    private String code;
    private String info;

    public static HospitalCodeEnum getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (HospitalCodeEnum val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }

    public static HospitalCodeEnum getByCode(String code) {
        if (code == null) {
            return null;
        }
        for (HospitalCodeEnum val : values()) {
            if (val.getCode().equals(code)) {
                return val;
            }
        }
        return null;
    }
}
