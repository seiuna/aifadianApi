package cn.seiua.afdapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AfdUser {
    /**
     * 用户唯一ID
     */
    @JsonProperty("user_id")
    public String userId;
    /**
     * 昵称，非唯一，可重复
     */
    public String name;
    /**
     * 头像
     */
    public String avatar;
    /**
     * 不知道什么东西 user_private_id
     */
    @JsonProperty("user_private_id")
    public String userPrivateId;
}
