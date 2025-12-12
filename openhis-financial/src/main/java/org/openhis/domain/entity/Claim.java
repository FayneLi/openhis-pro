package org.openhis.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whale.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.openhis.common.enums.ClaimUse;

import java.util.Date;

/**
 * 索赔管理Entity实体
 *
 * @author system
 * @date 2025-02-20
 */
@Data
@TableName("fin_claim")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class Claim extends BaseEntity {

    /** ID */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /** 交易号 */
    private String traceNumber;

    /** 状态 */
    private Integer statusEnum;

    /** 类别 */
    private String typeCode;

    /** （详细）索赔类别 */
    private String subtypeCode;

    /** 用途 */
    private ClaimUse useEnum;

    /** 索赔指向 */
    private Integer insurerEnum;

    /** condition_dis */
    private String conditionDis;

    /** procedure_id */
    private String procedureIds;

    /** item_ids */
    private String itemIds;

    /** 索赔涵盖时间 */
    private Date billablePeriodStart;

    /** 索赔涵盖时间 */
    private Date billablePeriodEnd;


}
