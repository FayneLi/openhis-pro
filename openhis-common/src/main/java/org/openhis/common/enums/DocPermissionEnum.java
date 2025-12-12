/*
 * Copyright ©2023 CJB-CNIT Team. All rights reserved
 */
package org.openhis.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.whale.common.enums.EnumInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 文书权限枚举类 一级菜单
 *
 * @author zxy
 * @date 2025-02-24
 */
@Getter
@AllArgsConstructor
public enum DocPermissionEnum implements EnumInterface {

    /**
     * 不限制
     */
    NO_LIMIT(0, "NO_LIMIT", "不限制"),

    /**
     * 编辑
     */
    EDIT(1, "EDIT", "编辑"),

    /**
     * 查看
     */
    VIEW(2, "VIEW", "查看");


    @EnumValue
    private final Integer value;
    private final String code;
    private final String info;

    public static DocPermissionEnum getByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (DocPermissionEnum val : values()) {
            if (val.getValue().equals(value)) {
                return val;
            }
        }
        return null;
    }
}