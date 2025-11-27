/*
 * Copyright ©2023 CJB-CNIT Team. All rights reserved
 */
package org.openhis.common.enums;

import com.whale.common.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 医嘱定价来源
 *
 * @author SunJQ
 * @date 2025-04-28
 */
@Getter
@AllArgsConstructor
public enum OrderPricingSource {

    /**
     * 批次售价
     */
    BATCH_SELLING_PRICE(1,
        "batchSellingPrice", "批次售价"),
    /**
     * 零售价
     */
    RETAIL_PRICE(2, "retailPrice", "零售价");

    private Integer value;
    private String code;
    private String info;

    public static OrderPricingSource getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (OrderPricingSource val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }

    public static OrderPricingSource getByCode(String code) {
        if (StringUtils.isEmpty(code)) {
            return null;
        }
        for (OrderPricingSource val : values()) {
            if (val.getCode().equals(code)) {
                return val;
            }
        }
        return null;
    }
}
