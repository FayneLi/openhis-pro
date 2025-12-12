package org.openhis.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.whale.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@TableName("doc_statistics_definition")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class DocStatisticsDefinition extends BaseEntity {
    private Long id;
    /*
     属性名称
    */
    private String name;

    /*
     属性类型 Input 、 Date 、 Checkbox 、Radio 、 Select 、 Textarea
    */
    private Integer typeEnum;
    /*
     属性代码
    */
    private String code;

    /*
     是否必填  1必填 0 不必填
    */
    private Integer required;

    /*
    是否统计    0：不统计  1：统计
     */
    private Integer isStatistics;
    private Integer displayOrder;
    /*
      单位
     */
    private String unit;
    /** 字典名称 */
    private String dictName;

    /** 字典类型 */
    private String dictType;

}
