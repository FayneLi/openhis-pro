package org.openhis.domain.aggregate;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.math.BigDecimal;

/**
 * 支付单
 * @author zhongyi
 * @date 2025/2/20
 */
public class PaymentFrom {
    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private BigDecimal amount;
    //应收
    private BigDecimal ys;
    //实收
    private BigDecimal ss;

    private String itemName;
    private String encounterId;
    private String quantity;
    private String unitName;
    /**
     * 关联收费项Id
     */
    private String chargeItemIds;


}
