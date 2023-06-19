package cn.seiua.afdapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AfdConfig {
    public int id;
    @JsonProperty("plan_id")
    public String planId;
    @JsonProperty("remark_name")
    public String remarkName;
    @JsonProperty("remark_placeholder")
    public String remarkPlaceholder;
    @JsonProperty("remark_required")
    public int remarkRequired;
    @JsonProperty("create_time")
    public long createTime;
    @JsonProperty("update_time")
    public long updateTime;
    @JsonProperty("user_id")
    public String userId;
    public int status;
}
