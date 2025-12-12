package org.openhis.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.whale.common.enums.EnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 费用类别
 */
@Getter
@AllArgsConstructor
public enum FeeTypeClass implements EnumInterface {
    // 费用类别
    ORDINARY_HOSPITALIZATION(21, "21", "普通住院"), FOREIGN_HOSPITALIZATION(25, "25", "异地住院"),
    SINGLE_DIAGNOSIS_HOSPITALIZATION(26, "26", "单病种住院"), INJURY_HOSPITALIZATION(22, "22", "外伤住院"),
    TRANSFER_HOSPITALIZATION(23, "23", "转外诊治住院"), EMERGENCY_TRANSFER_HOSPITALIZATION(24, "24", "急诊转住院"),
    PALLIATIVE_CARE_HOSPITALIZATION(2114, "2114", "舒缓疗护住院"), LOW_COPAY_HOSPITALIZATION(3101, "3101", "低自付住院");

    @EnumValue
    private final Integer value;
    private final String code;
    private final String info;

    public static FeeTypeClass getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (FeeTypeClass val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}
