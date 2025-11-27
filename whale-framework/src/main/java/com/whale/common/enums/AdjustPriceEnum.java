package com.whale.common.enums;

/**
 * Desc: 调价类型枚举
 *
 * @Author raymond
 * @Date 09:14 2025/10/16
 * @return
 **/
public enum AdjustPriceEnum {

    MEDICINE(0, "药品"),
    CONSUMABLES(1, "耗材"),
    DIAGNOSIS(2, "诊疗"),
    REGISTER(3, "挂号");


    private final Integer code;
    private final String info;

    AdjustPriceEnum(Integer code, String info) {
        this.code = code;
        this.info = info;
    }

    public Integer getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
}
