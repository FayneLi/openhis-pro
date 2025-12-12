package org.openhis.domain.aggregate;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * 第三方支付回调实体（下方备注信息以中银支付为模板）
 */
@Data
@TableName("agg_fin_three_part_pay")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class ThreePartPay {

    @TableId(type = IdType.ASSIGN_ID)
    private BigDecimal id;

    /**
     * 响应码：（枚举RespCode）00 表示成功，其它表示失败
     */
    private String respCode;

    /**
     * 响应码解释信息（需要Base64解密）
     */
    private String respMsg;

    /**
     * 交易类型：（枚举TranType）
     */
    private String tranType;

    /**
     * 交易金额
     */
    private String txnAmt;

    /**
     * 支付方式：
     */
    private String payType;

    /**
     * 终端流水号：终端号系统跟踪号，同请求报文原值返回，客户端收到应答报文需要验证traceNo字段值，需与请求报文值一致，如果不一致则丢包交易失败
     */
    private String traceNo;

    /**
     * 交易时间：（yyyyMMddHHmmss）
     */
    private String txnTime;

    /**
     * 支付订单号：银行返回系统订单号，需要保存该支付交易订单号
     */
    private String tradeNo;

    /**
     * 第三方支付订单号
     */
    private String transNo;

    /**
     * 商户号
     */
    private String mid;

    /**
     * 商户名称
     */
    private String merName;

    /**
     * 终端号
     */
    private String tid;

    /**
     * 商户系统订单号：同请求一致
     */
    private String merTradeNo;

    /**
     * 商户系统退款授权单号：同请求一致
     */
    private String vfTradeNo;

    /**
     * 优惠金额
     */
    private String discountAmt;

    /**
     * 有效时间：二维码本身的有效时间，是相对时间，单位为秒，以接收方收到报文时间为起始点计时。不同类型的订单以及不同的订单状况会对应不同的默认有效时间和最大有效时间（可以为空）
     */
    private String qrValidTime;

    /**
     * 二维码信息：主扫支付二维码，以二维码形式显示，手机APP扫二维码码消费
     */
    private String scanCode;

    /**
     * 原交易类型：1、订单查询类交易填写原交易类型（被扫交易必填）2、非订单查询填写交易类型与tranType一致（可以为空）
     */
    private String orgTranType;

    /**
     * 原交易名称：订单查询类交易填写原交易名称，非订单查询填写交易名称（被扫交易必填）
     */
    private String orgTxnName;

    /**
     * 订单数据：当tranType为F时，payType 值为ZFBA或WEIX时支付宝返回的tradeNo 或者微信返回的prepayId
     */
    private String payData;

    /**
     * POS机号
     */
    private String posNo;

    /**
     * 付款主键ID
     */
    private Long paymentId;

    /**
     * 前台UI序号
     */
    private Long index;

    /**
     * 时间戳（中银建议）
     */
    private Long time;
}
