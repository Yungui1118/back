package com.ruoyi.kj.utils;

/**
 * @author zheng yang
 * @date 2022/2/21 0:27
 */
public class KjConstants {

    //sequence返回字符串的最小长度
    public static final Long SEQ_TO_STRING_MIN_LENGTH = 10000L;
    //sequence长度小于基准长度时前追加基础值
    public static final String SEQ_TO_STRING_LESS_INSERT = "0";
    //单据编号
    public static final String ORDER_NUMBER_SEQ = "order_number_seq";
    // 销售订单编号 "0"
    public static final String SALE_NUMBER_SEQ = "sale_number_seq";
    // 采购订单编号 "1"
    public static final String PURCHASE_NUMBER_SEQ = "purchase_number_seq";
    // 称重订单编号 "2"
    public static final String WEIGHT_NUMBER_SEQ = "weight_number_seq";
}
