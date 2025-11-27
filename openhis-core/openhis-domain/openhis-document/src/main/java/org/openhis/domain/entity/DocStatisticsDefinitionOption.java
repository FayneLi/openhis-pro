package org.openhis.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.whale.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@TableName("doc_statistics_definition_option")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
/**
 * 统计定义选项 已作废
 */
public class DocStatisticsDefinitionOption extends BaseEntity {
    private Long id;
    /*
     属性编码
    */
    private Long docStatisticsDefinitionId;
    /*
    值，当属性类型为Checkbox\Radio\Select
    */
    private String option;

    /*
    显示顺序
    */
    private Integer displayOrder;

}
