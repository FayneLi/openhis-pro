package org.openhis.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whale.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 组套Entity实体
 *
 * @author yangmo
 * @date 2025-04-10
 */
@Data
@TableName("support_order_group")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class OrderGroup extends BaseEntity {

    /** ID */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /** 名称 */
    private String name;

    /** 类型 */
    private Integer typeEnum;

    /** 使用范围 */
    private String rangeCode;

    /** 参与者ID */
    private Long practitionerId;

    /** 机构ID */
    private Long orgId;

    /** 组套信息 */
    private String groupJson;

    /** 版本号 */
    private String versionNo;

}
