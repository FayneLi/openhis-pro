/*
 * Copyright ©2023 CJB-CNIT Team. All rights reserved
 */
package org.openhis.common.enums;

import com.whale.common.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 付款结果
 *
 * @author SunJQ
 * @date 2025-04-20
 */
@Getter
@AllArgsConstructor
public enum PaymentOutcome {

    /**
     * 排队
     */
    QUEUED("0", 0,"排队"),
    /**
     * 完整
     */
    COMPLETED("1", 1, "完整"),
    //2025/10/21 长大数据发现此处value和code没对应上，ERROR的value是2，code是3，PARTIAL是3和4.经确认这个枚举目前都是getCode，所以现在将value与code同步
    /**
     * 错误
     */
    ERROR("3", 3,"错误"),
    /**
     * 部分
     */
    PARTIAL("4", 4, "部分");

    private String value;
    private Integer code;
    private String description;

    public static PaymentOutcome getByValue(String value) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        for (PaymentOutcome val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}
