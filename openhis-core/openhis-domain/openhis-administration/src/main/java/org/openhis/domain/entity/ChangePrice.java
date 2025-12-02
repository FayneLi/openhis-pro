package org.openhis.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whale.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 修改价格记录Entity实体
 *
 * @author system
 */
@Data
@TableName("adm_change_price")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class ChangePrice extends BaseEntity {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /** 仓库位置 */
    private Long locationId;

    /** 业务表名药品、耗材、诊疗、挂号 */
    private String itemTable;

    /** 药品ID、耗材ID、诊疗ID、挂号ID */
    private Long itemId;

    /** 批次号 */
    private String lotNumber;


    /** 原进货价 */
    private BigDecimal originBuyingPrice;

    /** 原售货格 */
    private BigDecimal originRetailPrice;

    /** 改价申请人id */
    private Long applicantId;

    /** 审批人ID */
    private Long approverId;

    /** 改价申请时间 */
    private Date applicantTime;

    /** 审批时间 */
    private Date approvalTime;

    /** 当前品库存量 */
    private BigDecimal itemQuantity;


    /** 物品计量单位 */
    private String unitCode;

    /**进货价盈负差*/
    private BigDecimal differenceBuyingPrice;

    /** 零售价盈负差*/
    private BigDecimal differenceRetailPrice;

    /** 改价原因 */
    private String description;

    /** 新进货价 */
    private BigDecimal newBuyingPrice;

    /** 新零售价 */
    private BigDecimal newRetailPrice;


    /** 审批状态 */
    private Integer statusEnum;

    /** 条件理由 */
    private String reason;
}