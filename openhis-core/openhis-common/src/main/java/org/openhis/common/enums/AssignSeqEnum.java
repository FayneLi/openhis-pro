/*
 * Copyright ©2023 CJB-CNIT Team. All rights reserved
 */
package org.openhis.common.enums;

/**
 * 采番前缀枚举
 *
 * @author zxy
 * @date 2025-02-24
 */
public enum AssignSeqEnum {

    /**
     * 患者编号
     */
    PATIENT_NUM("1", "患者编号", "PN"),

    /**
     * 采购单据号
     */
    PURCHASE_NUM("2", "采购单据号", "PUR"),

    /**
     * 就诊编号
     */
    ENCOUNTER_NUM("3", "就诊编号", "EN"),

    /**
     * 药品请求编码
     */
    MEDICATION_RES_NO("5", "药品请求编码", "MR"),

    /**
     * 耗材请求编码
     */
    DEVICE_RES_NO("6", "耗材请求编码", "DR"),

    /**
     * 服务项目请求编码
     */
    SERVICE_RES_NO("7", "服务项目请求编码", "SR"),

    /**
     * 费用项目编码
     */
    CHARGE_ITEM_NO("8", "费用项目编码", "CI"),

    /**
     * 药品项目编码
     */
    MEDICATION_NUM("9", "药品项目编码", "MD"),

    /**
     * 器材项目编码
     */
    DEVICE_NUM("10", "项目编码", "DD"),

    /**
     * 支付编码
     */
    PAYMENT_NO("11", "支付编码", "SF"),

    /**
     * 诊疗项目编码
     */
    ACTIVITY_DEFINITION_NUM("11", "诊疗编码", "AC"),

    /**
     * 诊断定义编码
     */
    CONDITION_DEFINITION_NUM("11", "诊断编码", "CD"),

    /**
     * 科室业务编码
     */
    ORGANIZATION_BUS_NO("14", "科室业务编码", "ORG"),

    /**
     * 位置业务编码
     */
    LOCATION_BUS_NO("15", "科室业务编码", "LOC"),

    /**
     * 厂商/产地单据号
     */
    SUPPLIER_BUS_NO("16", "供应商编号", "SUP"),

    /**
     * 盘点单据号
     */
    STOCKTAKING_NUM("17", "盘点单据号", "STO"),

    /**
     * 报损单单据号
     */
    LOSS_BUS_NO("18", "报损单编号", "LOS"),

    /**
     * 采购退货单据号
     */
    RETURN_BUS_NO("17", "退货编号", "RET"),

    /**
     * 领用出库单据号
     */
    REQUISITION_NUM("19", "领用出库单据号", "REQ"),

    /**
     * 退货出库单据号
     */
    RETURN_ISSUE_NUM("20", "退货出库单据号", "RIS"),

    /**
     * 处方号-通用药物
     */
    PRESCRIPTION_COMMON_NO("21", "处方号-通用药物", "PCN"),

    /**
     * 处方号-麻醉药品
     */
    PRESCRIPTION_NARCOTIC_NO("22", "处方号-麻醉药品", "PNN"),

    /**
     * 处方号-毒性药品
     */
    PRESCRIPTION_TOXIC_NO("23", "处方号", "PTN"),

    /**
     * 处方号-一类精神药
     */
    PRESCRIPTION_A_PSYCHOTROPIC_NO("24", "处方号", "PAN"),

    /**
     * 处方号-二类精神药
     */
    PRESCRIPTION_B_PSYCHOTROPIC_NO("25", "处方号", "PBN"),

    /**
     * 住院编号
     */
    ADMISSION_NUM("26", "住院号", "ZY"),

    /**
     * 调拨单据号
     */
    TRANSFER_NUM("27", "调拨单据号", "TRA"),
    /**
     * 发票单据号
     */
    INVOICE_NUM("28", "发票单据号", "INV"),

    /**
     * 药品发放编码
     */
    MEDICATION_DIS_NO("29", "药品发放编码", "MS"),

    /**
     * 耗材发放编码
     */
    DEVICE_DIS_NO("30", "耗材发放编码", "DS"),

    /**
     * 医院内部处方编号
     */
    ELEP_MEDICATION_NO("31", "医院内部处方编号", "ER"),

    /**
     * 医保收费批号
     */
    YB_CLINIC_ORDER("32", "医保订单编号", "YBORD"),

    /**
     * 医保收费批号
     */
    YB_CLINIC_FEE("34", "费用明细流水号", "F"),

    /**
     * 自费收费批号
     */
    SF_CLINIC_ORDER("33", "自费订单编号", "SFORD"),

    /**
     * 处方号-中草药
     */
    PRESCRIPTION_CHINESE_HERBAL_MEDICINE("34", "处方号-中草药", "PCM"),

    /**
     * 身体部位编码
     */
    BODY_STRUCTURE_NO("35", "身体部位编码", "BS"),

    /**
     * 订货单单号
     */
    PHARMACY_WAREHOUSE_PURCHASE("36", "药库订货单", "PWP"),

    /**
     * 药房请领单单号
     */
    PURCHASE_REQUISITION("37", "药房请领单", "PRE"),

    /**
     * 药房入库单单号
     */
    PURCHASE_STOCKIN("38", "药房入库单", "PST"),

    /**
     * 药房退库单单号
     */
    PURCHASE_RETURN("39", "药房退库单", "PET"),

    /**
     * 发药单单号
     */
    DISPENSING_ORDER("40", "发药单", "DIO"),

    /**
     * 药房损益单单号
     */
    PURCHASE_PRPFITLOSS("41", "药房损益单", "PPR"),

    /**
     * 药房盘点单单号
     */
    PURCHASE_STOCKTAKING("42", "药房盘点单", "PTO"),
    /**
     * 药房调入单单号
     */
    PURCHASE_TRANSFERIN("43", "药房调入单", "PTI"),

    /**
     * 药房调出单单号
     */
    PURCHASE_TRANSFEROUT("44", "药房调出单", "PTU"),

    /**
     * 医嘱签发编码
     */
    ADVICE_SIGN("45", "医嘱签发编码", "ASI"),

    /**
     * 物资订货单
     */
    MATERIAL_PURCHASE("46", "物资订货单", "MPU"),

    /**
     * 物资进货单
     */
    MATERIAL_STOCKIN("47", "物资进货单", "MSI"),

    /**
     * 物资退货单
     */
    MATERIAL_RETURN("48", "物资退货单", "MRE"),

    /**
     * 物资出库单
     */
    MATERIAL_STOCKOUT("49", "物资出库单", "MSO"),

    /**
     * 物资退库单
     */
    MATERIAL_PRODUCT_RETURN("50", "物资退库单", "MPR"),

    /**
     * 物资损益单
     */
    MATERIAL_PRPFITLOSS("51", "物资损益单", "MPP"),

    /**
     * 物资盘点单
     */
    MATERIAL_STOCKTAKING("52", "物资盘点单", "MST"),

    /**
     * 物资调入单
     */
    MATERIAL_TRANSFERIN("53", "物资调入单", "MTI"),

    /**
     * 物资调出单
     */
    MATERIAL_TRANSFEROUT("54", "物资调出单", "MTO"),

    /**
     * 科室请领单单号
     */
    DEPARTMENT_REQUISITION("55", "科室请领单", "DRE"),

    /**
     * 科室入库单单号
     */
    DEPARTMENT_STOCKIN("56", "科室入库单", "DST"),

    /**
     * 科室退库单单号
     */
    DEPARTMENT_RETURN("57", "科室退库单", "DET"),

    /**
     * 科室损益单单号
     */
    DEPARTMENT_PRPFITLOSS("58", "科室损益单", "DPR"),

    /**
     * 科室盘点单单号
     */
    DEPARTMENT_STOCKTAKING("59", "科室盘点单", "DTO"),

    /**
     * 科室调入单单号
     */
    DEPARTMENT_TRANSFERIN("60", "科室调入单", "DTI"),

    /**
     * 科室调出单单号
     */
    DEPARTMENT_TRANSFEROUT("61", "科室调出单", "DTU"),

    /**
     * 诊疗处方号
     */
    ACTIVITY_PSYCHOTROPIC_NO("62", "诊疗处方号", "PAR"),

    /**
     * b 病历文书
     */
    PURCHASE_DOCUMENT("63", "病历文书", "DOC"),

    /**
     * 调价单
     */
    CHANGE_PRICE_BUZ("64", "调整零售价", "CPB"),

    /**
     * 药品汇总单号
     */
    MEDICINE_SUMMARY_NO("65", "药品汇总单号", "MSY"),

    /**
     * 公费医疗自付比例调整申请编号
     */
    GF_RATIO_APPLICATION("66", "公费医疗自付比例调整申请编号", "GRA"),

    /**
     * 参与者编码
     */
    PRACTITIONER_NO("67", "参与者编码", "PER"),

    /**
     * 号源编码
     */
    HEALTHCARE_SERVICE_NO("68", "号源编码", "HS");

    private final String code;
    private final String info;
    private final String prefix;

    AssignSeqEnum(String code, String info, String prefix) {
        this.code = code;
        this.info = info;
        this.prefix = prefix;
    }

    public String getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }

    public String getPrefix() {
        return prefix;
    }
}