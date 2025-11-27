package org.openhis.common.enums;

import com.whale.common.enums.EnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 项目类型
 */
@Getter
@AllArgsConstructor
public enum ItemCategoryCode implements EnumInterface {

    /**
     * 中成药
     */
    CHINESE_PATENT_DRUG(1, "1", "中成药"),

    /**
     * 西药
     */
    WESTERN_MEDICINE(2, "2", "西药"),

    /**
     * 外购药品
     */
    EXTERNALLY_PROCURED_DRUGS(3, "3", "外购药品"),

    /**
     * 中草药
     */
    CHINESE_HERBAL_MEDICINE(4, "4", "中草药"),

    /**
     * 耗材
     */
    DEVICE(7, "7", "耗材"),

    /**
     * 诊疗
     */
    SERVICE(8, "8", "诊疗"),

    /**
     * 其他
     */
    OTHER(9, "9", "其他");

    private final Integer value;
    private final String code;
    private final String info;

    public static ItemCategoryCode getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (ItemCategoryCode val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}
