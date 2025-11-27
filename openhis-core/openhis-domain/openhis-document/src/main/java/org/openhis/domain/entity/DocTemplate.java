package org.openhis.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.whale.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 文档模板实体类
 **/

@Data
@TableName("doc_template")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class DocTemplate extends BaseEntity {
    private Long id;
    /**
     * 模板名称
     */
    private String name;
    /**
     * 排序
     */
    private Integer displayOrder;
    /**
     * 模板内容
     */
    private String contextJson;

    /**
     * 文书定义ID
     */
    private Long definitionId;

    /**
     * 使用范围 0-暂不使用 1-全院使用 2-指定科室使用 3-个人使用
     */
    private Integer useRange;
    /**
     * 当useRange=1时，指定机构ID
     */
    private Long organizationId;
    /**
     * 当useRange=2时，指定用户ID
     */
    private Long userId;

}
