package org.openhis.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.whale.common.enums.EnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 公费申请处理角色
 * 
 * @author Thanking
 * @date 2025-10-21
 */
@Getter
@AllArgsConstructor
public enum GfApprovalRole implements EnumInterface {
    /**
     * 测算盈亏人
     */
    INITIAL_APPROVER(1, "1", "测算盈亏人"),
    /**
     * 财务报批人
     */
    FINANCE_APPROVER(2, "2", "财务报批人"),
    /**
     * 会议结果录入人
     */
    FINAL_RECORDER(3, "3", "会议结果录入人");

    @EnumValue
    private final Integer value;
    private final String code;
    private final String info;

    public static GfApprovalRole getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (GfApprovalRole val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}
