package org.openhis.domain.aggregate;

import com.baomidou.mybatisplus.annotation.TableName;
import org.openhis.domain.entity.SupplyDelivery;
import org.openhis.domain.entity.SupplyRequest;

import java.util.ArrayList;

/**
 * 采购入库单
 * @author zhongyi
 * @date 2025/2/20
 */
@TableName("agg_buy_in_supply_from")
public class BuyInSupplyFrom {
    private Long id;
    private Long supplyRequestId;
    private Long supplyDeliveryId;
    private String busNo;
    private String itemName;
    private String itemTable;

    public BuyInSupplyFrom() {
    }

    public BuyInSupplyFrom create()
    {
        return  new BuyInSupplyFrom();
    }

    public void approve()
    {

    }
}
