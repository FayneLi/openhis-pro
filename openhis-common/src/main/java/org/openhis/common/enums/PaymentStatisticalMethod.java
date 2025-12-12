/*
 * Copyright ©2023 CJB-CNIT Team. All rights reserved
 */
package org.openhis.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * PaymentStatisticalMethod (0: MEMBER_FIRST; 1: MEMBER_SECOND;)
 *
 * @author SunJQ
 * @date 2025-08-08
 */
@Getter
@AllArgsConstructor
public enum PaymentStatisticalMethod {

    /**
     * 字典fin_type_code
     */
    FIN_TYPE_CODE(1, "fin_type_code"),
    /**
     * 医保分类med_chrgitm_type
     */
    MED_CHRGITM_TYPE(2, "med_chrgitm_type");

    private Integer value;
    private String description;

    public static PaymentStatisticalMethod getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (PaymentStatisticalMethod val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}
