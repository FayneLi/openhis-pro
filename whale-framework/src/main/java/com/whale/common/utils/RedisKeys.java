/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.whale.common.utils;

/**
 * Redis所有Keys
 */
public class RedisKeys {


    /**
     * 商品缓存
     * @param itemId
     * @return
     */
    public static String getProductsKey(String itemId){
        return "products_change_price:item_" + itemId + "_key";
    }
}
