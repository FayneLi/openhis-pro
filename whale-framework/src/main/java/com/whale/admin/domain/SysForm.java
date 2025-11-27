package com.whale.admin.domain;

import com.whale.common.annotation.Excel;
import com.whale.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 流程表单对象 sys_task_form
 *
 * @author system
 * @date 2021-03-30
 */
public class SysForm extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 表单主键
     */
    private Long formId;

    /**
     * 表单名称
     */
    @Excel(name = "表单名称")
    private String formName;

    /**
     * 表单内容
     */
    @Excel(name = "表单内容")
    private String formContent;

    public Long getFormId() {
        return formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getFormContent() {
        return formContent;
    }

    public void setFormContent(String formContent) {
        this.formContent = formContent;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("formId", getFormId())
                .append("formName", getFormName()).append("formContent", getFormContent())
                .append("createTime", getCreateTime()).append("updateTime", getUpdateTime())
                .append("createBy", getCreateBy()).append("updateBy", getUpdateBy()).append("remark", getRemark())
                .toString();
    }
}
