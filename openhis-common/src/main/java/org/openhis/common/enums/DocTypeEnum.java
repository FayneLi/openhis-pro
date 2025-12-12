package org.openhis.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.whale.common.enums.EnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 就诊类型
 */
@Getter
@AllArgsConstructor
public enum DocTypeEnum implements EnumInterface {
    OUT_DOC(0, "OUT_DOC", "门诊病历"),
    IN_DOC(1, "IN_DOC", "住院病历"),
    NURSING_DOC(2, "NURSING_DOC", "护理评估"),
    NURSING_RECORD_DOC(3, "NURSING_RECORD_DOC", "护理记录"),
    TEMPERATURE_DOC(4, "NURSING_RECORD_DOC", "体温单"),
    NOTICE_DOC(5, "NOTICE_DOC", "告知书"),
    AGREEMENT_DOC(6, "AGREEMENT_DOC", "知情同意书"),
    IN_CASE_DOC(7, "IN_CASE_DOC", "病案首页");

    @EnumValue
    private final Integer value;
    private final String code;
    private final String info;

    public static DocTypeEnum getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (DocTypeEnum val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}
