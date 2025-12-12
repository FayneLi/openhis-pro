/*
 * Copyright ©2023 CJB-CNIT Team. All rights reserved
 */
package org.openhis.common.enums;

import com.whale.common.enums.EnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 单据状态
 *
 * @author zwh
 * @date 2025-03-05
 */
@Getter
@AllArgsConstructor
public enum SupplyStatus implements EnumInterface {

    /**
     * 待审核
     */
    PENDING_APPROVAL(1, "1", "待审核"),

    /**
     * 审核中
     */
    APPROVAL(2, "2", "审核中"),

    /**
     * 同意
     */
    AGREE(3, "3", "同意"),

    /**
     * 驳回
     */
    REJECT(4, "4", "驳回"),

    /**
     * 已撤回
     */
    WITHDRAW(9, "5", "已撤回"),

    /**
     * 待审请
     */
    PENDING_REVIEW(10, "6", "待审请"),

    /**
     * 已失效
     */
    EXPIRED_INVALIDATED(11, "7", "已失效"),

    /**
     * 已发送
     */
    SEND(12, "12", "已发送");

    private Integer value;
    private String code;
    private String info;

    public static SupplyStatus getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (SupplyStatus val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}
