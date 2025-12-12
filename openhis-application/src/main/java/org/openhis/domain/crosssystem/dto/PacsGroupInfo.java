package org.openhis.domain.crosssystem.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * PACS申请单封装类
 *
 * @author system
 */
@Data
@Accessors(chain = true)
public class PacsGroupInfo {

    /**
     * 必填 【检查项目编码】
     */
    private String groupCode;

    /**
     * 必填 【检查项目名称】
     */
    private String groupName;
}
