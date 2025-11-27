/*
 * Copyright ©2023 CJB-CNIT Team. All rights reserved
 */
package org.openhis.common.enums;

import com.whale.common.enums.EnumInterface;
import com.whale.common.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 护理医嘱分类
 *
 * @author zwh
 * @date 2025-03-14
 */
@Getter
@AllArgsConstructor
public enum NursingOrdersClass implements EnumInterface {

    /**
     * 护理
     */
    NURSING(26, "26", "护理"),

    /**
     * 病情
     */
    CONDITION(38, "38", "病情"),

    /**
     * 护理常规
     */
    NURSING_ROUTINE(39, "39", "护理常规"),

    /**
     * 膳食
     */
    DIET(27, "27", "膳食"),

    /**
     * 体位
     */
    POSITION(40, "40", "体位"),

    /**
     * 陪护
     */
    COMPANION_CARE(41, "41", "陪护"),

    /**
     * 隔离等级
     */
    ISOLATION_LEVEL(42, "42", "隔离等级");

    private Integer value;
    private String code;
    private String info;

    public static NursingOrdersClass getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (NursingOrdersClass val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }

    public static NursingOrdersClass getByCode(String code) {
        if (StringUtils.isEmpty(code)) {
            return null;
        }
        for (NursingOrdersClass val : values()) {
            if (val.getCode().equals(code)) {
                return val;
            }
        }
        return null;
    }
}
