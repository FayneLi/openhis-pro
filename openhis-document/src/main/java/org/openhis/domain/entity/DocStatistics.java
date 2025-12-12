package org.openhis.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.whale.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@TableName("doc_statistics")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class DocStatistics extends BaseEntity {
    private Long id;
    /**
     * 记录ID
     */
    private Long recordId;
    /**
     * 统计项定义ID
     */
    private Long statisticDefinitionId;
    private Long encounterId;
    private Long patientId;
    /**
     * 统计项编码
     */
    private String statisticDefinitionCode;
    /**
     * 记录科室ID
     */
    private Long organizationId;
    /**
     * 统计值
     */
    private String value;
    /**
     * 记录时间 yyyy-MM-dd HH:mm:ss
     */
    private Date recordTime;
    /**
     * 记录来源
     */
    private String source;


}
