package org.openhis.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.whale.common.enums.EnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 文档统计定义-属性类型枚举
 * 对应属性类型：Input（输入框）、Date（日期选择器）、Checkbox（复选框）、Radio（单选框）、Select（下拉选择）、Textarea（文本域）
 */
@Getter
@AllArgsConstructor
public enum DocStatisticsDefinitionTypeEnum implements EnumInterface {
    // 枚举项：value（数据库存储值）、code（业务编码）、info（前端/业务描述）
    INPUT(1, "INPUT", "输入框（单行文本）"),
    DATE(2, "DATE", "日期选择器"),
    CHECKBOX(3, "CHECKBOX", "复选框"),
    RADIO(4, "RADIO", "单选框"),
    SELECT(5, "SELECT", "下拉选择框"),
    TEXTAREA(6, "TEXTAREA", "文本域（多行文本）");

    // 数据库存储的枚举值（与表中type_enum字段对应）
    @EnumValue
    private final Integer value;
    // 业务编码（用于前后端交互、日志打印等，避免硬编码）
    private final String code;
    // 枚举描述（用于前端显示、接口返回说明等）
    private final String info;

    /**
     * 根据数据库存储值（value）获取枚举实例
     *
     * @param value 数据库中存储的type_enum值（如1、2、3...）
     * @return 对应的枚举实例，若未匹配则返回null
     */
    public static DocStatisticsDefinitionTypeEnum getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        // 遍历所有枚举项，匹配value
        for (DocStatisticsDefinitionTypeEnum typeEnum : values()) {
            if (typeEnum.getValue().equals(value)) {
                return typeEnum;
            }
        }
        // 无匹配项时返回null（避免抛出异常，便于业务层处理）
        return null;
    }

    /**
     * 扩展：根据业务编码（code）获取枚举实例（可选，按需使用）
     *
     * @param code 业务编码（如"INPUT"、"SELECT"）
     * @return 对应的枚举实例，若未匹配则返回null
     */
    public static DocStatisticsDefinitionTypeEnum getByCode(String code) {
        if (code == null || code.trim().isEmpty()) {
            return null;
        }
        for (DocStatisticsDefinitionTypeEnum typeEnum : values()) {
            if (typeEnum.getCode().equals(code.trim())) {
                return typeEnum;
            }
        }
        return null;
    }
}