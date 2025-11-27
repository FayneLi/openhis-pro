package org.openhis.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.whale.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 身体部位管理Entity实体
 *
 * @author liuhr
 * @date 2025-07-22
 */
@Data
@TableName("adm_body_structure")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class BodyStructure extends BaseEntity {

    /** ID */
    @TableId(type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /** 编码 */
    private String busNo;

    /** 部位名称 */
    private String name;

    /** 状态枚举 */
    private Integer statusEnum;

    /** 拼音码 */
    private String pyStr;

    /** 五笔码 */
    private String wbStr;

}
