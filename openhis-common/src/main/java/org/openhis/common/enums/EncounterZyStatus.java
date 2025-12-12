package org.openhis.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.whale.common.enums.EnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 住院就诊状态
 */
@Getter
@AllArgsConstructor
public enum EncounterZyStatus implements EnumInterface {
    TO_BE_REGISTERED(1, "to-be-registered", "待登记"),

    REGISTERED(2, "registered", "待入科"),

    AWAITING_DISCHARGE(3, "awaiting-discharge", "待出院"),

    DISCHARGED_FROM_HOSPITAL(4, "discharged-from-hospital", "已出院"),

    ADMITTED_TO_THE_HOSPITAL(5, "admitted-to-the-hospital", "已入院"),

    PENDING_TRANSFER(6, "pending-transfer", "待转科"),

    ALREADY_SETTLED(7, "already-settled", "已结算");

    @EnumValue
    private final Integer value;
    private final String code;
    private final String info;

    public static EncounterZyStatus getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (EncounterZyStatus val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}
