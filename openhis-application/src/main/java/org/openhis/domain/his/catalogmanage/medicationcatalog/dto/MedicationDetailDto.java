package org.openhis.domain.his.catalogmanage.medicationcatalog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.whale.common.annotation.Dict;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 药品目录Dto
 *
 * @author lpt
 * @date 2025-02-25
 */
@Data
@Accessors(chain = true)
@Schema(description = "药品目录详情DTO", title = "MedicationDetailDto",
        requiredProperties = {"name", "doseUnitCode"}) // 显式指定必填字段
public class MedicationDetailDto extends MedicationDto{

    /** ID */
    @Schema(description = "主键ID", example = "10001", type = "string") // 因ToStringSerializer转字符串，标注type
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /** 药品编码 */
    @Schema(description = "药品定义ID", example = "20001", type = "string")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long medicationDefId;

    /** 所属科室 */
    @Schema(description = "所属机构ID", example = "30001", type = "string")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long orgId;

    /** 所在位置 */
    @Schema(description = "存储位置ID", example = "40001", type = "string")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long locationId;

    /** 剂型 */
    @Schema(description = "剂型编码", example = "JX001")
    private String doseFormCode;

    /** 规格 */
    @Schema(description = "药品规格", example = "5ml:0.5g")
    private String totalVolume;

    /** 成分 */
    @Schema(description = "药品成分项", example = "阿莫西林")
    private String ingredientItem;

    /** 是否为活性 */
    @Schema(description = "是否为活性状态 1-是 0-否", example = "1", allowableValues = {"0", "1"})
    private Integer activeFlag;

    /** 批次号 */
    @Schema(description = "药品批次号", example = "2025040901")
    private String lotNumber;

    /** 生效日期 */
    @Schema(description = "生效日期", example = "2025-04-09 00:00:00", format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date effectiveDate;

    /** 到期日期 */
    @Schema(description = "到期日期", example = "2028-04-09 00:00:00", format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expirationDate;

    /** 用法 */
    @Schema(description = "用药方法编码", example = "YF001")
    private String methodCode;

    /** 用药频次 */
    @Schema(description = "用药频次编码", example = "PC001")
    private String rateCode;

    /** 单次剂量 */
    @Schema(description = "单次用药剂量", example = "0.5")
    private BigDecimal dose;

    /** 剂量单位 */
    @Schema(description = "剂量单位编码（字典码：unit_code）", required = true, example = "DW001")
    @Dict(dictCode = "unit_code")
    @NotBlank(message = "剂量单位不能为空")
    private String doseUnitCode;

    @Schema(description = "剂量单位编码对应的文本值", example = "克")
    private String doseUnitCode_dictText;

    /** 单次最大剂量 */
    @Schema(description = "单次最大用药剂量", example = "1.0")
    private BigDecimal maxUnit;

    /** 药品定义 */
    @Schema(description = "药品定义描述", example = "阿莫西林胶囊，用于敏感菌所致的呼吸道感染等")
    private String definition;

    /** 药品编号 */
    @Schema(description = "药品业务编号", example = "YP20250409001")
    private String busNo;

    /** 药品名称 */
    @Schema(description = "药品名称", required = true, example = "阿莫西林胶囊")
    @NotBlank(message = "药品名称不能为空")
    private String name;

    /** 适用范围 */
    @Schema(description = "适用范围枚举 1-门诊 2-住院 3-通用", example = "3", allowableValues = {"1", "2", "3"})
    private Integer domainEnum;

    /** 药品版本 */
    @Schema(description = "药品版本号", example = "V1.0")
    private String version;

    /** 英文药名 */
    @Schema(description = "药品英文名称", example = "Amoxicillin Capsules")
    private String nameEn;

    /** 药品名称拼音码 */
    @Schema(description = "药品名称拼音简码", example = "AMXLJN")
    private String pyStr;

    /** 药品五笔码 */
    @Schema(description = "药品名称五笔简码", example = "SGRM")
    private String wbStr;

    /** 药品分类 */
    @Schema(description = "药品分类编码", example = "FL001")
    private String categoryCode;

    /** 商品名称 */
    @Schema(description = "药品商品名称", example = "阿莫仙")
    private String merchandiseName;

    /** 商品名称拼音码 */
    @Schema(description = "商品名称拼音简码", example = "AMX")
    private String merchandisePyStr;

    /** 商品五笔码 */
    @Schema(description = "商品名称五笔简码", example = "SGR")
    private String merchandiseWbStr;

    /** 药品单位 */
    @Schema(description = "药品单位编码（字典码：unit_code）", example = "DW001")
    @Dict(dictCode = "unit_code")
    private String unitCode;

    @Schema(description = "药品单位编码对应的文本值", example = "盒")
    private String unitCode_dictText;

    /** 最小单位 */
    @Schema(description = "药品最小单位编码", example = "DW002")
    private String minUnitCode;

    /** 所含耗材 */
    @Schema(description = "药品包含的耗材说明", example = "一次性注射器")
    private String comprisedText;

    /** 成分 */
    @Schema(description = "药品主要成分", example = "阿莫西林")
    private String ingredient;

    /** 拆零比 */
    @Schema(description = "药品拆零比例", example = "0.1")
    private BigDecimal partPercent;

    /** 剂量形式 */
    @Schema(description = "剂量形式（字典码：dose_form_code）", example = "1")
    @Dict(dictCode = "dose_form_code")
    private Integer doseFrom;

    @Schema(description = "剂量形式对应的文本值", example = "胶囊")
    private String doseFrom_dictText;

    /** 批准文号 */
    @Schema(description = "药品批准文号", example = "国药准字H20060575")
    private String approvalNumber;

    /** 医保是否对码 */
    @Schema(description = "医保是否对码 1-是 0-否", example = "1", allowableValues = {"0", "1"})
    private Integer ybMatchFlag;

    /** 医保编码 */
    @Schema(description = "医保目录编码", example = "YB2025001")
    private String ybNo;

    /** 药理作用分类 */
    @Schema(description = "药理作用分类编码", example = "YL001")
    private String pharmacologyCategoryCode;

    /** 是否皮试 */
    @Schema(description = "是否需要皮试 1-是 0-否", example = "0", allowableValues = {"0", "1"})
    private Integer skinTestFlag;

    /** 是否为注射药物 */
    @Schema(description = "是否为注射类药物 1-是 0-否", example = "0", allowableValues = {"0", "1"})
    private Integer injectFlag;

    /** 生产厂家 */
    @Schema(description = "生产厂家ID", example = "50001", type = "string")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long manufacturerId;

    /** 生产厂商文本 */
    @Schema(description = "生产厂家名称", example = "广州白云山医药集团股份有限公司")
    private String manufacturerText;

    /** 供应商 */
    @Schema(description = "供应商ID", example = "60001", type = "string")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long supplyId;

    /** 是否限制使用 */
    @Schema(description = "是否限制使用 1-是 0-否", example = "0", allowableValues = {"0", "1"})
    private Integer restrictedFlag;

    /** 限制使用范围 */
    @Schema(description = "限制使用范围说明", example = "仅限呼吸内科使用")
    private String restrictedScope;

    /** 儿童用药标志 */
    @Schema(description = "儿童用药标志 1-适用 0-不适用", example = "1", allowableValues = {"0", "1"})
    private Integer childrenFlag;

    /** 产品特性 */
    @Schema(description = "产品特性枚举 1-处方药 2-非处方药 3-特殊管理药品", example = "1", allowableValues = {"1", "2", "3"})
    private Integer characteristic;

    /** 购入价 */
    @Schema(description = "药品购入价格", example = "10.5")
    private BigDecimal purchasePrice;

    /** 零售价 */
    @Schema(description = "药品零售价格", example = "15.8")
    private BigDecimal retailPrice;

    /** 最高零售价 */
    @Schema(description = "药品最高零售限价", example = "18.0")
    private BigDecimal maximumRetailPrice;

    /** 医保类别 */
    @Schema(description = "医保类别编码", example = "YB001")
    private String ybType;

    /** 财务类别 */
    @Schema(description = "财务类别编码（字典码：fin_type_code）", example = "CW001")
    @Dict(dictCode = "fin_type_code")
    private String typeCode;

    @Schema(description = "财务类别编码对应的文本值", example = "西药")
    private String typeCode_dictText;

    /** 单次最小用药频次 */
    @Schema(description = "单次最小用药频次编码", example = "PC001")
    private String minRateCode;

    /** 单次最大用药频次 */
    @Schema(description = "单次最大用药频次编码", example = "PC002")
    private String maxRateCode;

    /** 药品状态 */
    @Schema(description = "药品状态枚举 1-启用 2-停用 3-待审核", example = "1", allowableValues = {"1", "2", "3"})
    private Integer statusEnum;

    @Schema(description = "药品状态对应的文本值", example = "启用")
    private String statusEnum_enumText;

    /** 拆分属性 */
    @Schema(description = "拆分属性枚举 1-可拆分 2-不可拆分", example = "1", allowableValues = {"1", "2"})
    private Integer partAttributeEnum;

    /** 贯标国家编码 */
    @Schema(description = "国家药品编码（贯标）", example = "860000123456789")
    private String nationalDrugCode;

    /** 是否抗生素 */
    @Schema(description = "是否为抗生素 1-是 0-否", example = "1", allowableValues = {"0", "1"})
    private Integer antibioticFlag;

    /** 是否自制 */
    @Schema(description = "是否为自制药品 1-是 0-否", example = "0", allowableValues = {"0", "1"})
    private Integer selfFlag;

    /** DDD值 */
    @Schema(description = "限定日剂量（DDD）编码", example = "DDD001")
    private String dddCode;

    /** DDD单位 */
    @Schema(description = "限定日剂量单位编码", example = "DW001")
    private String dddUnitCode;

    /** 用量限定 */
    @Schema(description = "单次最大用量限定", example = "2.0")
    private BigDecimal usageLimit;

    /** 抗生素分类 */
    @Schema(description = "抗生素分类编码（字典码：antibiotic_type_code）", example = "KS001")
    @Dict(dictCode = "antibiotic_type_code")
    private String antibioticCode;

    @Schema(description = "抗生素分类编码对应的文本值", example = "青霉素类")
    private String antibioticCode_dictText;

    /** 权限限制 */
    @Schema(description = "权限限制枚举 1-普通权限 2-专科权限 3-主任权限", example = "1", allowableValues = {"1", "2", "3"})
    private Integer restrictedEnum;

    /** 基药标识 */
    @Schema(description = "是否为基本药物 1-是 0-否", example = "1", allowableValues = {"0", "1"})
    private Integer basicFlag;

    /** 住院临时医嘱拆分属性 */
    @Schema(description = "住院临时医嘱拆分属性 1-可拆分 2-不可拆分", example = "1", allowableValues = {"1", "2"})
    private Integer thoPartAttributeEnum;

    /** 最小库存警戒数量(常规单位) */
    @Schema(description = "最小库存警戒数量", example = "10")
    private BigDecimal itemMinQuantity;

    /** 最大库存警戒数量(常规单位) */
    @Schema(description = "最大库存警戒数量", example = "100")
    private BigDecimal itemMaxQuantity;

    /** 剂量单位换算比 */
    @Schema(description = "剂量单位换算比例", example = "10")
    private BigDecimal unitConversionRatio;

    /** 医保等级 */
    @Schema(description = "医保等级 1-甲类 2-乙类 3-丙类", example = "2", allowableValues = {"1", "2", "3"})
    private Integer chrgitmLv;

    /** 处方标志 */
    @Schema(description = "处方标志 1-处方药 2-非处方药", example = "1", allowableValues = {"1", "2"})
    private Integer rxFlag;

    /**
     * 用药说明
     */
    @Schema(description = "用药说明/注意事项", example = "饭后服用，每次1粒，每日3次")
    private String dosageInstruction;

}