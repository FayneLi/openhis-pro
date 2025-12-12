package org.openhis.common.enums;

import com.whale.common.enums.EnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 执行状态（事件执行用）
 *
 * @author lyx
 * @date 2025-03-05
 */
@Getter
@AllArgsConstructor
public enum EventStatus implements EnumInterface {

    /**
     * 待执行
     */
    PREPARATION(1, "PREP", "待执行"),

    /**
     * 执行中
     */
    IN_PROGRESS(2, "IP", "执行中"),

    /**
     * 未完成
     */
    NOT_DONE(3, "ND", "未完成"),

    /**
     * 暂停
     */
    ON_HOLD(4, "OH", "暂停"),

    /**
     * 停止
     */
    STOPPED(5, "ST", "停止"),

    /**
     * 已执行
     */
    COMPLETED(6, "CMP", "已执行"),

    /**
     * 录入错误
     */
    ENTERED_IN_ERROR(7, "EIE", "录入错误"),

    /**
     * 未知
     */
    UNKNOWN(8, "UNK", "未知"),

    /**
     * 取消执行
     */
    CANCEL(9, "CCL", "取消执行");

    private Integer value;
    private String code;
    private String info;

    public static EventStatus getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (EventStatus val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}
