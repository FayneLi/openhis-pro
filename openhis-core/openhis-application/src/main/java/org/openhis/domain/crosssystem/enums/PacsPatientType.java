package org.openhis.domain.crosssystem.enums;

/**
 * PACS患者类型
 *
 * @author system
 */
public enum PacsPatientType {
    /**
     * 门诊
     */
    OUTPATIENT("01", "门诊"),
    /**
     * 住院
     */
    INPATIENT("02", "住院"),
    /**
     * 手动登记
     */
    MANUAL_REGISTRATION("03", "手动登记"),
    /**
     * 体检
     */
    HEALTH_CHECKUP("04", "体检");

    private final String code;
    private final String name;

    PacsPatientType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static PacsPatientType getByCode(String code) {
        if (code == null) {
            return null;
        }
        for (PacsPatientType val : values()) {
            if (val.getCode().equals(code)) {
                return val;
            }
        }
        return null;
    }
}
