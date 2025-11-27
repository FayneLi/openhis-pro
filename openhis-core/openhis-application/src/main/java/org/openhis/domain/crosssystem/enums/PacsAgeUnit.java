package org.openhis.domain.crosssystem.enums;

/**
 * PACS年龄单位
 *
 * @author system
 */
public enum PacsAgeUnit {
    /**
     * 岁
     */
    YEAR("1", "岁");

    private final String code;
    private final String name;

    PacsAgeUnit(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static PacsAgeUnit getByCode(String code) {
        if (code == null) {
            return null;
        }
        for (PacsAgeUnit val : values()) {
            if (val.getCode().equals(code)) {
                return val;
            }
        }
        return null;
    }
}
