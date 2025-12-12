package org.openhis.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whale.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 概念转换表，做对照，电子发票用到了这张表
 *
 * @author system
 * @date 2025-04-25
 */
@Data
@TableName("support_conceptMap")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class ConceptMap extends BaseEntity {

    /** ID */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /** 字典编码 */
    private Long dictCode;

    /** 项目代码 */
    private String code;

    /** 类型 */
    private Integer typeEnum;

}