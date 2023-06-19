package cn.seiua.afdapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class AfdPlan {
    @JsonProperty("can_ali_agreement")
    public int canAliAgreement;
    @JsonProperty("plan_id")
    public String planId;
    public int rank;
    @JsonProperty("user_id")
    public String userId;
    public int status;
    public String name;
    public String pic;
    public String desc;
    public String price;
    @JsonProperty("update_time")
    public long updateTime;
    public AfdTiming timing;
    @JsonProperty("pay_month")
    public int payMonth;
    @JsonProperty("show_price")
    public String showPrice;
    @JsonProperty("show_price_after_adjust")
    public String showPriceAfterAdjust;
    @JsonProperty("has_coupon")
    public int hasCoupon;
    public List<Object> coupon;
    @JsonProperty("favorable_price")
    public int favorablePrice;
    public int independent;
    public int permanent;
    @JsonProperty("can_buy_hide")
    public int canBuyHide;
    @JsonProperty("need_address")
    public int needAddress;
    @JsonProperty("product_type")
    public int productType;
    @JsonProperty("sale_limit_count")
    public int saleLimitCount;
    @JsonProperty("need_invite_code")
    public boolean needInviteCode;
    @JsonProperty("bundle_stock")
    public int bundleStock;
    @JsonProperty("bundle_sku_select_count")
    public int bundleSkuSelectCount;
    public AfdConfig config;
    @JsonProperty("has_plan_config")
    public int hasPlanConfig;
    @JsonProperty("expire_time")
    public long expireTime;
    @JsonProperty("sku_processed")
    public List<Object> skuProcessed;
    @JsonProperty("rankType")
    public int rankType;

}
