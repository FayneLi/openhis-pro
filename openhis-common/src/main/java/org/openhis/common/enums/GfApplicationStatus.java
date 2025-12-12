package org.openhis.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.whale.common.enums.EnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 公费申请状态
 * 
 * @author Thanking
 * @date 2025-10-21
 */
@Getter
@AllArgsConstructor
public enum GfApplicationStatus implements EnumInterface {
    /**
     * 处理中
     */
    PROCESSING(0, "0", "处理中"),
    /**
     * 通过
     */
    APPROVED(1, "1", "通过"),
    /**
     * 驳回
     */
    REJECTED(2, "2", "驳回"),
    /**
     * 取消
     */
    CANCELLED(3, "3", "取消");

    @EnumValue
    private final Integer value;
    private final String code;
    private final String info;

    public static GfApplicationStatus getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (GfApplicationStatus val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}
