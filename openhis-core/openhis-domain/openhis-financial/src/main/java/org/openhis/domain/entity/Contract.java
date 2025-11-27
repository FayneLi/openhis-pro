package org.openhis.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.whale.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 合同管理Entity实体
 *
 * @author system
 * @date 2025-02-20
 */
@Data
@TableName("fin_contract")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class Contract extends BaseEntity {

    /** ID */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /** 合同名称 */
    private String contractName;

    /** 状态 */
    private Integer statusEnum;

    /** 合同的类别 */
    private Integer categoryEnum;

    /** 合同编码 */
    private String busNo;

    /** 机构 */
    private Long orgId;

    /** 是否医保 */
    private Integer ybFlag;

    /** 優先使用標志 */
    private Integer sort;

    /** 医保区划 */
    private String admVs;

    //2025-06-18 新加字段，医保相关配置信息从sys_option表迁移至本表
    /** 医保PrvKey */
    private String cliPrvKey;

    /** 医保PubKey */
    private String cliPubKey;

    /**  */
    private String serverPubKey;//暂时不知用处

    /** 医保终端授权范围 */
    private String scope;

    /** 医保终端授权类型 */
    private String grantType;

    /** 医保密码 */
    private String password;

    /** 医保账号 */
    private String username;

    /** 医保客户端密钥 */
    private String clientSecret;

    /** 医保客户端Id */
    private String clientId;

    /** fixmedinsCode */
    private String fixmedinsCode;

    /** fixmedinsName */
    private String fixmedinsName;
}