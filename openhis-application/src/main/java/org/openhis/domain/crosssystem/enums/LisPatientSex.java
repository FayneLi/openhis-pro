package org.openhis.domain.crosssystem.enums;

/**
 * LIS病人性别
 *
 * @author system
 */
public enum LisPatientSex {
    /**
     * 未知
     */
    UNKNOWN("01", "未知"),
    /**
     * 男
     */
    MALE("02", "男"),
    /**
     * 女
     */
    FEMALE("03", "女");

    private final String code;
    private final String name;

    LisPatientSex(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static LisPatientSex getByCode(String code) {
        if (code == null) {
            return null;
        }
        for (LisPatientSex val : values()) {
            if (val.getCode().equals(code)) {
                return val;
            }
        }
        return null;
    }
}
