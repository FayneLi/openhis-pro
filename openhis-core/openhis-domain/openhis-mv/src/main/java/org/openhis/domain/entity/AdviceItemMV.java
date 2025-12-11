package org.openhis.domain.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.whale.common.annotation.Dict;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.GenericEventMessage;

import java.math.BigDecimal;

public class AdviceItemMV {

    /** 医嘱类型 */
    private Integer adviceType; // 1:药品 , 2: 耗材 , 3:项目

    /** 编号 */
    private String busNo;

    /**
     * 医嘱详细分类(中草药，西药，检查，检验)
     */
    private String categoryCode;

    /** 药品性质 (普通，精麻类)*/
    private String pharmacologyCategoryCode;

    /** 拆零比 */
    private BigDecimal partPercent;

    /** 剂量换算 */
    private BigDecimal unitConversionRatio;

    /** 拆分属性-门诊 */
    private Integer partAttributeEnum;

    /** 住院临时医嘱拆分属性 */
    private Integer thoPartAttributeEnum;

    /** 医嘱定义ID */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long adviceDefinitionId;

    /**
     * 医嘱定义对应表名
     */
    private String adviceTableName;

    /**
     * 物理位置id | 可能是 发药药房id,耗材房id,执行科室id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long positionId;

    /** 医嘱名称 */
    private String adviceName;

    /**
     * 医嘱编码
     */
    private String adviceBusNo;

    /** 拼音码 */
    private String pyStr;

    /** 五笔码 */
    private String wbStr;

    /** 医保编码 */
    private String ybNo;

    /** 商品名称 */
    private String productName;

    /**
     * 活动类型
     */
    private Integer activityType;
    private String activityType_enumText;

    /** 是否皮试 */
    private Integer skinTestFlag;
    private String skinTestFlag_enumText;

    /** 是否为注射药物 */
    private Integer injectFlag;
    private String injectFlag_enumText;

    /** 包装单位 */
    @Dict(dictCode = "unit_code")
    private String unitCode;
    private String unitCode_dictText;

    /** 最小单位 */
    @Dict(dictCode = "unit_code")
    private String minUnitCode;
    private String minUnitCode_dictText;

    /**
     * 规格
     */
    private String volume;

    /**
     * 用法
     */
    @Dict(dictCode = "method_code")
    private String methodCode;
    private String methodCode_dictText;

    /**
     * 使用频次
     */
    @Dict(dictCode = "rate_code")
    private String rateCode;
    private String rateCode_dictText;

    /**
     * 单次剂量
     */
    private String dose;

    /** 剂量单位 */
    @Dict(dictCode = "unit_code")
    private String doseUnitCode;
    private String doseUnitCode_dictText;

    /**
     * 供应商
     */
    private String supplier;

    /** 供应商ID */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long supplierId;

    /**
     * 生产厂家
     */
    private String manufacturer;

    /** 费用定价主表ID */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long chargeItemDefinitionId;

    /** 所属科室 */
    private Long orgId;

    /** 所在位置 */
    private Long locationId;

    /** 是否限制使用 */
    private Integer restrictedFlag;

    /** 限制使用范围 */
    private String restrictedScope;

    /** 用药说明 */
    @Dict(dictCode = "dosage_instruction")
    private String dosageInstruction;
    private String dosageInstruction_dictText;
    /*
    收费项目等级
     */
    @Dict(dictCode = "chrgitm_lv")
    private String chrgitmLv;
    private String chrgitmLv_dictText;


}
