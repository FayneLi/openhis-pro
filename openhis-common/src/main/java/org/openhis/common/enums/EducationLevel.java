package org.openhis.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.whale.common.enums.EnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 学历层次
 * 
 * @author Thanking
 * @date 2025-10-21
 */
@Getter
@AllArgsConstructor
public enum EducationLevel implements EnumInterface {
    /**
     * 预科生
     */
    PREPARATORY(0, "0", "预科生"),
    /**
     * 本科生
     */
    UNDERGRADUATE(1, "1", "本科生"),
    /**
     * 硕士研究生
     */
    POSTGRADUATE(2, "2", "硕士研究生"),
    /**
     * 博士研究生
     */
    DOCTORAL(3, "3", "博士研究生");

    @EnumValue
    private final Integer value;
    private final String code;
    private final String info;

    public static EducationLevel getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (EducationLevel val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}
