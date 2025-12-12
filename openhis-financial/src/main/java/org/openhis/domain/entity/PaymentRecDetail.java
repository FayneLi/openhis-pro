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
 * 付款管理Entity实体
 *
 * @author system
 * @date 2025-02-20
 */
@Data
@TableName("fin_payment_rec_detail")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class PaymentRecDetail extends BaseEntity {

    /** ID */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /** 先前支付明细id */
    private Long predecessorId;

    /** 付款id */
    private Long reconciliationId;

    /** 付款类型 */
    private Integer targetEnum;//暂时没用

    /** 账户 */
    private Long accountId;

    /** 账户类型 */
    private String accountCode;

    /** 支付类型 */
    private Integer payEnum;

    /** 支付类型等级 */
    private Integer payLevelEnum;

    /** 金额 */
    private BigDecimal amount;

    /** 找零 */
    private BigDecimal returnAmount;

    /** 交款 */
    private BigDecimal chargeAmount;

    /** 支付平台返回交易号 医保批次号*/
    private String payTransNo;

    /** 支付平台返回交易信息 医保结算ID*/
    private String payTransText;

    /** 支付平台返回交易时间 */
    private Date payTransDate;

    /** 支付平台账前余额 */
    private BigDecimal beforeBalance;

    /** 支付平台账后余额 */
    private BigDecimal afterBalance;

    /** 单笔交易结果 */
    private Integer resultEnum;

}