package org.openhis.domain.entity
        ;

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
 * 频次配置表，用于频次、周期和相关信息
 * @TableName adm_frequency
 */
@Data
@TableName(value ="adm_frequency")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class Frequency extends BaseEntity {
    /**
     * 唯一标识符
     */
    @TableId(type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 频次代码，唯一标识与字典表对应
     */
    private String rateCode;

    /**
     * 频次名称
     */
    private String name;

    /**
     * 每天执行的次数
     */
    private Integer dayCount;

    /**
     * 每次执行之间的间隔（天数）
     */
    private Integer dayInterval;

    /**
     * 每天的具体执行时间点，逗号分隔
     */
    private String dayTimes;

    /**
     * 是否周期性每周执行，0 为否，1 为是
     */
    private Integer weekCycleFlag;

    /**
     * 每周执行的间隔，单位为周
     */
    private Integer weekInterval;

    /**
     * 每周执行的次数
     */
    private Integer weekTimes;

    /**
     * 是否为连续执行，0 为否，1 为是
     */
    private Integer continueFlag;

    /**
     * 执行总次数，记录任务累计执行次数
     */
    private Integer totalExecutionCount;

    /**
     * 任务执行周期长度
     */
    private Integer executionPeriod;

    /**
     * 任务执行周期的单位，如 day、week、month
     */
    private String executionPeriodUnit;

    /**
     * 第三方代码，外部系统使用
     */
    private String thirdCode;

    /**
     * 备注信息
     */
    private String memo;

    /**
     * 并发戳，用于版本控制和并发冲突检测
     */
    private Integer concurrencyStamp;

}