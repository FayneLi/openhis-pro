package org.openhis.domain.crosssystem.enums;

/**
 * PACS性别
 *
 * @author system
 */
public enum PacsPatientSex {
    /**
     * 男
     */
    MALE("01", "男"),
    /**
     * 女
     */
    FEMALE("02", "女"),
    /**
     * 未知
     */
    UNKNOWN("03", "未知");

    private final String code;
    private final String name;

    PacsPatientSex(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static PacsPatientSex getByCode(String code) {
        if (code == null) {
            return null;
        }
        for (PacsPatientSex val : values()) {
            if (val.getCode().equals(code)) {
                return val;
            }
        }
        return null;
    }
}
