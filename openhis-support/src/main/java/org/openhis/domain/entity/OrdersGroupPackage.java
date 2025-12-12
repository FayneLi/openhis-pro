package org.openhis.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whale.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@TableName("support_orders_group_package")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class OrdersGroupPackage extends BaseEntity {

    /** ID */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 组套包类型
     */
    private Integer packageTypeEnum;

    /**
     * 科室id
     */
    private Long organizationId;

    /**
     * 参与者id
     */
    private Long practitionerId;

}
