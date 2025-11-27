package org.openhis.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.whale.common.enums.EnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ActivityDefCategory implements EnumInterface {

    /**
     * 治疗
     */
    TREATMENT(21, "21", "治疗"),

    /**
     * 检验
     */
    PROOF(22, "22", "检验"),

    /**
     * 检查
     */
    TEST(23, "23", "检查"),

    /**
     * 手术
     */
    PROCEDURE(24, "24", "手术"),

    /**
     * 麻醉
     */
    ANESTHESIA(25, "25", "麻醉"),

    /**
     * 护理
     */
    NURSING(26, "26", "护理"),

    /**
     * 膳食
     */
    DIET(27, "27", "膳食"),

    /**
     * 输血
     */
    METACHYSIS(28, "28", "输血"),

    /**
     * 输氧
     */
    OXYGEN_THERAPY(29, "29", "输氧"),

    /**
     * 转科
     */
    TRANSFER(32, "32", "转科"),

    /**
     * 术后
     */
    POSTOPERATIVE(33, "33", "术后"),

    /**
     * 出院
     */
    DISCHARGE(34, "34", "出院"),

    /**
     * 转院
     */
    TRANSFER_HOSPITAL(35, "35", "转院"),

    /**
     * 死亡
     */
    death(36, "36", "死亡"),

    /**
     * 产后
     */
    POSTPARTUM(37, "37", "产后"),

    /**
     * 病情
     */
    CONDITION(38, "38", "病情"),

    /**
     * 护理常规
     */
    NURSING_ROUTINE(39, "39", "护理常规"),

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

    @EnumValue
    private final Integer value;
    private final String code;
    private final String info;

    public static ActivityDefCategory getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (ActivityDefCategory val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}
