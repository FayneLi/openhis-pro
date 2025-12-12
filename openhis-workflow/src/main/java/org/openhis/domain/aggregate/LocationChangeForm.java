package org.openhis.domain.aggregate;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.openhis.domain.entity.ServiceRequest;

/**
 * 位置变更表（转院，转科，转床记录）
 *
 * @author WangHuan
 * @date 2025-09-02
 */
@Data
@TableName("agg_lacation_change")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class LocationChangeForm extends ServiceRequest {

    /**
     * ID
     */
    @TableId(type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 名称
     */
    private String name;

    /** 就诊id */
    private Long encounterId;

    /**
     * 请求id
     */
    private Long requestId;

    /**
     * 请求表名
     */
    private String requestTableName;

    /**
     * 原科室
     */
    private Long originalOrganizationId;

    /**
     * 目标科室
     */
    private Long targetOrganizationId;

    /**
     * 原病区
     */
    private Long originalLocationId;

    /**
     * 目标病区
     */
    private Long targetLocationId;

    /**
     * 出院方式
     */
    private String outWayCode;

}
