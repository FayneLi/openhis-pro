package org.openhis.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whale.common.core.domain.BaseEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 文书定义：例如：门诊病历、体温单、患者护理记录单、患者跌倒压疮评估等
 *
 * @author wanghaiming
 * @date 2025-08-14
 */
@Data
@TableName("doc_definition")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class DocDefinition extends BaseEntity {

    /**
     * ID
     */
    @TableId(type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 文书名称
     */
    private String name;
    /**
     * 文书的版本号
     */
    private String version;
    /**
     * 文书类型 一级菜单 ，从枚举中获取 DocTypeEnum
     */
    private Integer primaryMenuEnum;
    /**
     * 文书类型 二级菜单，自定义
     */
    private String subMenu;
    /**
     * 文书编码 busNo，在新建时由系统自动生成
     */

    private String busNo;
    /**
     * vue路由地址
     */
    private String vueRouter;
    /**
     * 医院ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long hospitalId;
    /**
     * 是否有效 0-有效 1-无效
     */
    private Integer isValid;

    /**
     * 显示顺序
     */
    private Integer displayOrder;
    /**
     * 使用范围 0-暂不使用 1-全院使用 2-指定科室使用
     */
    private Integer useRangeEnum;
    /**
     * 医生权限 DocPermissionEnum
     * 文书权限  0-不限制 1-查看 2- 编辑
     */
    private Integer doctorPermissionEnum;
    /**
     * 护士权限 DocPermissionEnum
     * 文书权限 0-不限制 1-查看 2- 编辑
     */
    private Integer nursingPermissionEnum;
    /**
     * 医技权限 DocPermissionEnum
     * 文书权限  0-不限制 1-查看 2- 编辑
     */
    private Integer medicalPermissionEnum;
    /**
     * 药剂师权限 DocPermissionEnum
     * 文书权限  0-不限制 1-查看 2- 编辑
     */
    private Integer pharmacistPermissionEnum;

}
