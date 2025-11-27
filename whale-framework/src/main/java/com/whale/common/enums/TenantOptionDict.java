package com.whale.common.enums;

/**
 * 租户配置项字典（不存在DB中，以此文件为基准，新增修改只需在这里改）
 *
 * @author system
 */
public enum TenantOptionDict {

    /**
     * 医院名称
     */
    YB_HOSPITAL_NAME("hospitalName", "医保-医院名称", 0),

    /**
     * 医保-医疗机构等级(3101接口)
     */
    YB_MEDINS_LV("medinsLv", "医保_医疗机构等级", 1),
    /**
     * 定点医药机构编号
     */
    YB_FIXMEDINS_CODE("fixmedinsCode", "医保_定点医药机构编号", 2),
    /**
     * 电子发票appid
     */
    EINVOICE_APP_ID("app_id", "电子发票-appid", 3),

    /**
     * 电子发票key
     */
    EINVOICE_KEY("key", "电子发票-key", 4),

    /**
     * 电子发票url
     */
    EINVOICE_URL("url", "电子发票-url", 5),

    /**
     * 医保开关
     */
    YB_SWITCH("yb_switch", "医保开关", 6),

    /**
     * 电子地址
     */
    ELE_ADDRESS("eleAddress", "电子处方-请求地址", 22),

    /**
     * 服务地址
     */
    ADDRESS("address", "服务地址", 23),

    /**
     * 超时时间
     */
    TIME("time", "超时时间", 24),

    /**
     * 是否加密
     */
    YB_IS_ENCRYPT("isEncrypt", "医保-是否加密", 25),
    /**
     * 医保区划
     */
    YB_INSUPLC_ADMDVS("insuplc_admdvs", "医保-区划", 26),

    /**
     * 电子处方appId
     */
    ELE_PRE_APP_ID("pre_app_id", "电子处方-appId", 27),

    /**
     * 电子处方appSecret
     */
    ELE_PRE_APP_SECRET("pre_app_secret", "电子处方-appSecret", 28),

    /**
     * 电子处方私钥
     */
    ELE_APP_PRVKEY("APP_PRVKEY", "电子处方-私钥", 29),

    /**
     * 电子处方公钥
     */
    ELE_PLAF_PUBKEY("PLAF_PUBKEY", "电子处方-公钥", 30),

    /**
     * 医院等级
     */
    EINVOICE_HOSPITAL_LV("hospital_lv", "电子发票-医院等级", 39),

    /**
     * 无视LIS&PACS报错
     */
    LIS_PACS_ERROR_IGNORE("lisPacsErrorIgnore", "无视LIS&PACS报错", 40),
    /**
     * LIS接口地址
     */
    LIS_API_URL("lisApiUrl", "LIS接口地址", 40),
    /**
     * LISAppId
     */
    LIS_APP_ID("lisAppId", "LISAppId", 41),
    /**
     * LISAppSecret
     */
    LIS_APP_SECRET("lisAppSecret", "LISAppSecret", 42),
    /**
     * PACS接口地址
     */
    PACS_API_URL("pacsApiUrl", "PACS接口地址", 43),
    /**
     * PACSAppId
     */
    PACS_APP_ID("pacsAppId", "PACSAppId", 44),
    /**
     * PACSAppSecret
     */
    PACS_APP_SECRET("pacsAppSecret", "PACSAppSecret", 45),
    /**
     * PACSAppSecret
     */
    INVOICE_FORWARD_URL("invoiceUrl", "电子发票-中转服务的路径", 46),
    /**
     * PACSAppSecret
     */
    FORWARD_SWITCH("forwardSwitch", "电子发票-中转服务开关", 47),
    /**
     * 食源性开关
     */
    FOODBORNE_SWITCH("foodborneSwitch", "食源性开关", 48),
    /**
     * 食源性接口地址 ../goto（格式如下：http://172.16.7.247/infections/goto 需指定到/goto）
     */
    FOODBORNE_API_URL("foodborneApiUrl", "食源性接口地址 ../goto", 49),
    /**
     * 食源性医疗机构
     */
    FOODBORNE_HOSPITAL("foodborneHospital", "食源性医疗机构", 50),
    /**
     * 食源性登录账号
     */
    FOODBORNE_USER_NAME("foodborneUserName", "食源性登录账号", 51),
    /**
     * BPC商户号
     */
    BPC_MID("bpcMid", "BPC商户号", 52),
    /**
     * BPC终端号
     */
    BPC_TID("bpcTid", "BPC终端号", 53),
    /**
     * BPCMD5签名密钥
     */
    BPC_MD5_SHARED_SECRET("bpcMd5SharedSecret", "BPCMD5签名密钥", 54),
    /**
     * BPC请求URL
     */
    BPC_REQUEST_URL("bpcRequestUrl", "BPC请求URL", 55),
    /**
     * 电子发票开关
     */
    INVOICE_SWITCH("invoiceSwitch", "电子发票开关", 56),

    /**
     * 医嘱定价来源
     */
    ORDER_PRICING_SOURCE("orderPricingSource", "医嘱定价来源", 57);

    private final String code;
    private final String name;
    private final Integer sort;

    TenantOptionDict(String code, String name, Integer sort) {
        this.code = code;
        this.name = name;
        this.sort = sort;
    }

    public static TenantOptionDict getByCode(String code) {
        if (code == null) {
            return null;
        }
        for (TenantOptionDict val : values()) {
            if (val.getCode().equals(code)) {
                return val;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Integer getSort() {
        return sort;
    }
}
