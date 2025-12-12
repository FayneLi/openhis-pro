package org.openhis.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whale.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 就诊位置管理Entity实体
 *
 * @author system
 * @date 2025-02-20
 */
@Data
@TableName("adm_encounter_location")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class EncounterLocation extends BaseEntity {

    /** ID */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /** 就诊id */
    private Long encounterId;

    /** 位置ID */
    private Long locationId;

    /** 状态枚举 */
    private Integer statusEnum;

    /** 物理形式枚举 */
    private Integer formEnum;

    /** 开始时间 */
    private Date startTime;

    /** 结束时间 */
    private Date endTime;

}
