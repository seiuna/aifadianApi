package cn.seiua.afdapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class AfdOrder {

        /**
         * 订单号
         */
        @JsonProperty("out_trade_no")
        private String outTradeNo;
        /**
         * 下单用户ID
         */
        @JsonProperty("user_id")
        private String userId;
        /**
         * 方案ID，如自选，则为空
         */
        @JsonProperty("plan_id")
        private String planId;
        /**
         * 赞助月份
         */
        private int month;
        /**
         * 真实付款金额，如有兑换码，则为0.00
         */
        @JsonProperty("total_amount")
        private String totalAmount;
        /**
         * 显示金额，如有折扣则为折扣前金额
         */
        @JsonProperty("show_amount")
        private String showAmount;
        /**
         *  2 为交易成功。目前仅会推送此类型
         */
        private int status;
        /**
         * 订单留言
         */
        private String remark;
        /**
         * 兑换码ID
         */
        @JsonProperty("redeem_id")
        private String redeemId;
        /**
         * 0表示常规方案 1表示售卖方案
         */
        @JsonProperty("product_type")
        private int productType;
        /**
         * 折扣
         */
        private String discount;
        /**
         * 如果为售卖类型，以数组形式表示具体型号
         */
        @JsonProperty("sku_detail")
        private List<String> skuDetail;
        /**
         *
         */
        @JsonProperty("create_time")
        private long createTime;
        /**
         *
         */
        @JsonProperty("plan_title")
        private String planTitle;
        /**
         *
         */
        @JsonProperty("user_private_id")
        private String userPrivateId;
        /**
         * 收件人
         */
        @JsonProperty("address_person")
        private String addressPerson;
        /**
         * 收件人电话
         */
        @JsonProperty("address_phone")
        private String addressPhone;
        /**
         * 收件人地址
         */
        @JsonProperty("address_address")
        private String addressAddress;


    }
