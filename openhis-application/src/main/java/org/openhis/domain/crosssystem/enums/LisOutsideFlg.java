package org.openhis.domain.crosssystem.enums;

/**
 * LIS外检FLG
 *
 * @author system
 */
public enum LisOutsideFlg {
    /**
     * 非外检
     */
    NO(0, "非外检"),
    /**
     * 外检
     */
    YES(1, "外检");

    private final Integer code;
    private final String name;

    LisOutsideFlg(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static LisOutsideFlg getByCode(Integer code) {
        if (code == null) {
            return null;
        }
        for (LisOutsideFlg val : values()) {
            if (val.getCode().equals(code)) {
                return val;
            }
        }
        return null;
    }
}
