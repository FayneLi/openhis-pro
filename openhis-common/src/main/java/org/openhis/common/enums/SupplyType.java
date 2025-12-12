/*
 * Copyright ©2023 CJB-CNIT Team. All rights reserved
 */
package org.openhis.common.enums;

import com.whale.common.enums.EnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 单据类型
 *
 * @author zwh
 * @date 2025-03-05
 */
@Getter
@AllArgsConstructor
public enum SupplyType implements EnumInterface {

    /**
     * 采购入库
     */
    PURCHASE_INVENTORY(1, "1", "采购入库"),

    /**
     * 商品调拨
     */
    PRODUCT_TRANSFER(2, "2", "商品调拨"),

    /**
     * 汇总发药
     */
    SUMMARY_DISPENSE(3, "3", "汇总发药"),

    /**
     * 商品盘点
     */
    PRODUCT_STOCKTAKING(4, "4", "商品盘点"),

    /**
     * 采购退货
     */
    PRODUCT_RETURN(5, "5", "采购退货"),

    /**
     * 报损单
     */
    LOSS_REPORT_FORM(6, "6", "报损单"),

    /**
     * 领用出库
     */
    ISSUE_INVENTORY(7, "7", "领用出库"),

    /**
     * 商品批量调拨
     */
    PRODUCT_BATCH_TRANSFER(8, "8", "商品批量调拨"),

    /**
     * 领用退货
     */
    RETURN_ISSUE(9, "9", "领用退货"),

    /**
     * 商品批量盘点
     */
    PRODUCT_BATCH_STOCKTAKING(10, "10", "商品批量盘点"),

    /**
     * 发药
     */
    DISPENSE_MEDICATION(11, "11", "发药"),
    /**
     * 退药
     */
    RETURN_MEDICATION(12, "12", "退药") ,

    /**
     * 药库订货单
     */
    CABINET_PURCHASE(13, "13", "药库订货单"),

    /**
     * 药库进货单
     */
    CABINET_STOCKIN(14, "14", "药库进货单"),
    /**
     * 药库退货单
     */
    CABINET_RETURN(15, "15", "药库退货单"),
    /**
     * 药库出库单
     */
    CABINET_STOCKOUT(16, "16", "药库出库单"),
    /**
     * 药库退库单
     */
    CABINET_PRODUCT_RETURN(17, "17", "药库退库单"),
    /**
     * 药库损益单
     */
    CABINET_PRPFITLOSS(18, "18", "药库损益单"),

    /**
     * 药库盘点单
     */
    CABINET_STOCKTAKING(19, "19", "药库盘点单"),

    /**
     * 药房请领单
     */
    PURCHASE_REQUISITION(20, "20", "药房请领单"),
    /**
     * 药房入库单
     */
    PURCHASE_STOCKIN(21,"21", "药房入库单" ),
    /**
     * 药房退库单
     */
    PURCHASE_RETURN(22,"22", "药房退库单"),
    /**
     * 发药单
     */
    DISPENSING_ORDER(23,"23", "发药单"),
    /**
     * 药房损益单
     */
    PURCHASE_PRPFITLOSS(24,"24", "药房损益单"),
    /**
     * 药房盘点单
     */
    PURCHASE_STOCKTAKING(25,"25", "药房盘点单"),
    /**
     * 药房调入单
     */
    PURCHASE_TRANSFERIN(26,"26", "药房调入单"),
    /**
     * 药房调出单
     */
    PURCHASE_TRANSFEROUT(27,"27", "药房调出单"),

    /**
     * 物资订货单
     */
    MATERIAL_PURCHASE(28, "28", "物资订货单"),

    /**
     * 物资进货单
     */
    MATERIAL_STOCKIN(29, "29", "物资进货单"),
    /**
     * 物资退货单
     */
    MATERIAL_RETURN(30, "30", "物资退货单"),
    /**
     * 物资出库单
     */
    MATERIAL_STOCKOUT(31, "31", "物资出库单"),
    /**
     * 物资退库单
     */
    MATERIAL_PRODUCT_RETURN(32, "32", "物资退库单"),
    /**
     * 物资损益单
     */
    MATERIAL_PRPFITLOSS(33, "33", "物资损益单"),

    /**
     * 物资盘点单
     */
    MATERIAL_STOCKTAKING(34, "34", "物资盘点单"),
    /**
     * 物资调入单
     */
    MATERIAL_TRANSFERIN(35,"35", "物资调入单"),
    /**
     * 物资调出单
     */
    MATERIAL_TRANSFEROUT(36,"36", "物资调出单"),

    /**
     * 科室请领单
     */
    DEPARTMENT_REQUISITION(37, "37", "科室请领单"),
    /**
     * 科室入库单
     */
    DEPARTMENT_STOCKIN(38,"38", "科室入库单" ),
    /**
     * 科室退库单
     */
    DEPARTMENT_RETURN(39,"39", "科室退库单"),
    /**
     * 科室损益单
     */
    DEPARTMENT_PRPFITLOSS(40,"40", "科室损益单"),
    /**
     * 科室盘点单
     */
    DEPARTMENT_STOCKTAKING(41,"41", "科室盘点单"),
    /**
     * 科室调入单
     */
    DEPARTMENT_TRANSFERIN(42,"42", "科室调入单"),
    /**
     * 科室调出单
     */
    DEPARTMENT_TRANSFEROUT(43,"43", "科室调出单"),

    /**
     * 自动盘点
     */
    AUTO_STOCKTAKING(44, "44", "自动盘点"),

    /**
     * 库存明细
     */
    INVENTORY_PRODUCT(45, "45", "库存明细"),
    /**
     * 药品调价
     */
    REQUEST_MEDICATION_CHANGE_PRICE(46, "46", "药品调价"),
    /**
     * 耗材调价
     */
    REQUEST_DEVICE_CHANGE_PRICE(47, "47", "耗材调价"),
    /**
     * 诊疗调价
     */
    REQUEST_ACTIVITY_CHANGE_PRICE(48, "48", "诊疗调价"),
    /**
     * 挂号调价
     */
    REQUEST_HEALTH_CHANGE_PRICE(49, "49", "挂号调价"),
    /**
     * 挂号调价
     */
    REQUEST_CHANGE_PRICE(50, "50", "货品调价");


    private Integer value;
    private String code;
    private String info;

    public static SupplyType getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (SupplyType val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}
