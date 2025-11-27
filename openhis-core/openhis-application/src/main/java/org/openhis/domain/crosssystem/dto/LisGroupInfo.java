package org.openhis.domain.crosssystem.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * LIS申请单封装类
 *
 * @author system
 */
@Data
@Accessors(chain = true)
public class LisGroupInfo {

    /**
     * 必填 【检查项目编码】 多个用“+”连接
     */
    private String groupCode;
    /**
     * 必填 【检查项目名称】多个用“+”连接
     */
    private String groupName;
}
