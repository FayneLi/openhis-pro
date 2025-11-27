package org.openhis.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.whale.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 文档记录
 *
 * @author wanghaiming
 * @date 2025-08-14
 */
@Data
@TableName("doc_record")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class DocRecord extends BaseEntity {

    private Long id;
    /**
     * 文书定义ID
     */
    private Long definitionId;

    private String definitionBusNo;
    /**
     * 文档内容 存储为JSON格式
     */
    private String contentJson;

    /**
     * 记录状态 0草稿/暂存 1提交 2归档 3修改  DocStatusEnum 枚举类
     * 0草稿/暂存 1提交 2归档 3修改
     */
    private Integer statusEnum;
    /**
     * 记录科室ID
     */
    private Long organizationId;
    /**
     * encounterId 就诊记录ID
     */
    private Long encounterId;
    /**
     * patientId 病人ID
     */
    private Long patientId;
    private Date recordTime;
    /**
     * 是否编辑 0未编辑 1已编辑,当前正在编辑中
     */
    private Integer isEdit;

}
