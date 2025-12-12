package org.openhis.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whale.common.annotation.Dict;
import com.whale.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.sql.Time;

/**
 * 机构位置关系管理Entity实体
 *
 * @author system
 * @date 2025-02-22
 */
@Data
@TableName("support_organization_location")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class OrganizationLocation extends BaseEntity {

    /** ID */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /** 机构编码 */
    @Dict(dictTable = "adm_organization", dictCode = "id", dictText = "name")
    private Long organizationId;

    /** 默认发药药房 */
    @Dict(dictTable = "adm_location", dictCode = "id", dictText = "name")
    private Long defLocationId;

    /** 发放类别 */
    @Dict(dictCode = "distribution_category_code")
    private String distributionCategoryCode;

    /**
     * 诊疗定义id
     */
    private Long activityDefinitionId;

    /**
     * 诊疗类型
     */
    private String activityCategoryCode;

    /** 开始时间 */
    private Time startTime;

    /** 结束时间 */
    private Time endTime;

    /** 显示顺序 */
    private Integer displayOrder;

}