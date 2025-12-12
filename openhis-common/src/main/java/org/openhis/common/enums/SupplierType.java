package org.openhis.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.whale.common.enums.EnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SupplierType implements EnumInterface {

    MANUFACTURER(1, "1", "生产商"),

    SUPPLIER(2, "2", "供应商");

    @EnumValue
    private final Integer value;
    private final String code;
    private final String info;

    public static SupplierType getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (SupplierType val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}
