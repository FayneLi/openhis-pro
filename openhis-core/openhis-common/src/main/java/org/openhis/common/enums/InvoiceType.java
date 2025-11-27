/*
 * Copyright ©2023 CJB-CNIT Team. All rights reserved
 */
package org.openhis.common.enums;

import com.whale.common.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * InvoiceType (0: MEMBER_FIRST; 1: MEMBER_SECOND;)
 *
 * @author SunJQ
 * @date 2025-04-28
 */
@Getter
@AllArgsConstructor
public enum InvoiceType {

    /**
     * 开具
     */
    ISSUING_INVOICES("0", "开具"),
    /**
     * 冲销
     */
    REVERSING_INVOICES("1", "冲销");

    private String value;
    private String description;

    public static InvoiceType getByValue(String value) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        for (InvoiceType val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}
