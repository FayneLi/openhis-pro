/*
 * Copyright ©2023 CJB-CNIT Team. All rights reserved
 */
package org.openhis.common.enums;

import com.whale.common.enums.EnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 单据类别
 *
 * @author zwh
 * @date 2025-03-05
 */
@Getter
@AllArgsConstructor
public enum SupplyCategory implements EnumInterface {

    /**
     * 库存供应
     */
    STOCK_SUPPLY(1, "1", "库存供应"),

    /**
     * 非库存供应
     */
    NON_STOCK(2, "2", "非库存供应");

    // /**
    // * 普通
    // */
    // NORMAL(3, "3","0.普通"),
    // /**
    // * 采购计划生成
    // */
    // PURCHASE_PLAN_GENERATION(4, "4","1.采购计划生成"),
    // /**
    // * 外购药品入库
    // */
    // PURCHASED_DRUGS_WAREHOUSING(5, "5","0.外购药品入库"),
    // /**
    // * 自制药品入库
    // */
    // HOMEMADE_DRUGS_WAREHOUSING(6, "6","1.自制药品入库"),
    // /**
    // * 代销药品入库
    // */
    // CONSIGNMENT_DRUGS_WAREHOUSING(7, "7","2.代销药品入库"),
    // /**
    // * 其他药品入库
    // */
    // OTHER_DRUGS_WAREHOUSING(8, "8","3.其他药品入库"),
    // /**
    // * 赠送药品入库
    // */
    // DONATED_DRUGS_WAREHOUSING(9, "9","4.赠送药品入库"),
    // /**
    // * 申请采购
    // */
    // PURCHASE_APPLICATION(10, "10","1.申请采购"),
    // /**
    // * 院内出库
    // */
    // IN_HOSPITAL_OUTBOUND(11, "11","0.院内出库"),
    // /**
    // * 院外出库
    // */
    // OUT_OF_HOSPITAL_OUTBOUND(12, "12","1.院外出库"),
    // /**
    // * 其他出库
    // */
    // OTHER_OUTBOUND(13, "13","2.其他出库"),
    // /**
    // * 普通损益
    // */
    // GENERAL_PROFIT_AND_LOSS(14, "14","0.普通损益"),
    // /**
    // * 盘点损益
    // */
    // STOCKTAKING_PROFIT_AND_LOSS(15, "15","1.盘点损益"),
    // /**
    // * 制剂消耗
    // */
    // PREPARATION_CONSUMPTION(16, "16","2.制剂消耗"),
    // /**
    // * 常备抢救药品
    // */
    // STANDBY_RESCUE_MEDICINES(16, "16","2.常备抢救药品"),
    // /**
    // * 破损过期药品
    // */
    // DAMAGED_EXPIRED_MEDICINES(16, "16","3.破损过期药品"),
    // /**
    // * 捐赠药品
    // */
    // DONATED_MEDICINES(16, "16","4.捐赠药品"),
    // /**
    // * 普通盘点
    // */
    // GENERAL_STOCKTAKING(17, "17","0.普通盘点"),
    // /**
    // * 月度盘点
    // */
    // MONTHLY_STOCKTAKING(18, "18","1.月度盘点"),
    // /**
    // * 门诊病人发药
    // */
    // OUTPATIENT_PATIENT_DISPENSING(19, "19","0.门诊病人发药"),
    // /**
    // * 住院病人发药
    // */
    // INPATIENT_PATIENT_DISPENSING(20, "20","1.住院病人发药"),
    // /**
    // * 住院病人汇总发药
    // */
    // INPATIENT_PATIENT_SUMMARY_DISPENSING(21, "21","2.住院病人汇总发药"),
    // /**
    // * 赠送
    // */
    // PRESENT(22, "22","1.赠送"),
    // /**
    // * 视光材料
    // */
    // OPTICAL_MATERIALS(23, "23","2.视光材料"),
    // /**
    // * 调价分类 药品
    // */
    // REQUEST_CATEGORY_CHANGE_PRICE_MEDICATION(24, "24","药品调价单"),
    // /**
    // * 调价分类 耗材
    // */
    // REQUEST_CATEGORY_CHANGE_PRICE_DEVICE(25, "25","耗材调价单"),
    // /**
    // * 调价分类 诊疗
    // */
    // REQUEST_CATEGORY_CHANGE_PRICE_ACTIVITY(26, "26","诊疗调价单"),
    // /**
    // * 调价分类 挂号
    // */
    // REQUEST_CATEGORY_CHANGE_PRICE_HEALTH(27, "27","挂号调价单");

    private Integer value;
    private String code;
    private String info;

    public static SupplyCategory getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (SupplyCategory val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}
