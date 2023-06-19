package cn.seiua.afdapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class AfdSponser {

        /**
         * []数组类型，具体节点为多个赞助方案。
         */
        @JsonProperty("sponsor_plans")
        public List<AfdPlan> sponsorPlans;
        /**
         * 当前赞助方案，如果节点仅有 name:""，不包含其它内容时，表示无方案
         */
        @JsonProperty("current_plan")
        public AfdPlan currentPlan;
        /**
         * 累计赞助金额，此处为折扣前金额。如有兑换码，则此处为虚拟金额，回比实际提现的多
         */
        @JsonProperty("all_sum_amount")
        public String allSumAmount;
        /**
         * int 秒级时间戳，表示成为赞助者的时间，即首次赞助时间
         */
        @JsonProperty("first_pay_time")
        public long firstPayTime;
        /**
         * int 秒级时间戳，最近一次赞助时间
         */
        @JsonProperty("last_pay_time")
        public long lastPayTime;
        /**
         * 节点表示用户属性
         */
        public AfdUser user;


    }
