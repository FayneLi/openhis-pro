package org.openhis.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whale.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@TableName("support_orders_group_package_detail")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class OrdersGroupPackageDetail extends BaseEntity {

    /**
     * ID
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 组合套餐id
     */
    private Long groupPackageId;

    /**
     * 医嘱定义id
     */
    private Long orderDefinitionId;

    /**
     * 医嘱定义表名
     */
    private String orderDefinitionTable;

    /**
     * 数量
     */
    private BigDecimal quantity;

    /**
     * 单位
     */
    private String unitCode;

    /**
     * 单次剂量
     */
    private BigDecimal dose;

    /**
     * 用药频次
     */
    private String rateCode;

    /**
     * 用药天数
     */
    private Integer dispensePerDuration;

    /**
     * 给药途径
     */
    private String methodCode;

    /**
     * 小单位单次剂量
     */
    private BigDecimal doseQuantity;

    /**
     * 组号
     */
    private Long groupId;
}
