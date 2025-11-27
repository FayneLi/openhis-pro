package com.whale.admin.web.util;

import com.whale.common.core.domain.model.LoginUser;
import com.whale.common.enums.TenantOptionDict;
import com.whale.common.utils.SecurityUtils;
import com.whale.common.utils.StringUtils;

/**
 * 租户配置工具类
 *
 * @author system
 */
public class TenantOptionUtil {

    /**
     * 获取租户配置项内容
     *
     * @param optionDict 租户配置项字典
     * @return 租户配置项内容
     */
    public static String getOptionContent(TenantOptionDict optionDict) {
        LoginUser loginUser;
        try {
            loginUser = SecurityUtils.getLoginUser();
        } catch (Exception e) {
            return null;
        }
        if (loginUser == null) {
            return null;
        }
        if (loginUser.getOptionMap() == null || loginUser.getOptionMap().isEmpty()) {
            return null;
        }
        // return loginUser.getOptionMap().get(optionDict.getCode());

        // TODO:郭睿2025/10/17 李永兴提出的sys_option切换TenantOption临时防止报错方案，最晚2025年11月底删除
        String newValue = loginUser.getOptionMap().get(optionDict.getCode());
        String oldValue = loginUser.getOptionJson().getString(optionDict.getCode());
        return StringUtils.isEmpty(newValue) ? oldValue : newValue;
    }

}
