package org.openhis.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whale.common.core.domain.BaseEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 服务项目管理Entity实体
 *
 * @author system
 * @date 2025-02-20
 */
@Data
@TableName("adm_healthcare_service")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class HealthcareService extends BaseEntity {

    /** ID */
    @TableId(type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 编码
     */
    private String busNo;

    /** 活动标记 */
    private Integer activeFlag;

    /** 提供部门ID */
    private Long offeredOrgId;

    /** 服务分类 */
    private String categoryCode;

    /** 服务类型 */
    private String typeCode;

    /** 服务专业 */
    private String specialtyCode;

    /** 地点 */
    private Long locationId;

    /** 服务名称 */
    private String name;

    /** 说明 */
    private String comment;

    /** 额外细节 */
    private String extraDetails;

    /** 联系方式 */
    private String contact;

    /** 预约要求 */
    private Integer appointmentRequiredFlag;

    /** 医保编码 */
    private String ybNo;

}