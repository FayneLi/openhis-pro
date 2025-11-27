package org.openhis.domain.crosssystem.enums;

/**
 * LIS年龄单位
 *
 * @author system
 */
public enum LisAgeUnit {
    /**
     * 岁
     */
    YEAR("01", "岁");

    private final String code;
    private final String name;

    LisAgeUnit(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static LisAgeUnit getByCode(String code) {
        if (code == null) {
            return null;
        }
        for (LisAgeUnit val : values()) {
            if (val.getCode().equals(code)) {
                return val;
            }
        }
        return null;
    }
}
