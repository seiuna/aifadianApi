package cn.seiua.afdapi.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResponseData {
    @JsonProperty("ec")
    private int ec;

    @JsonProperty("em")
    private String em;

    @JsonProperty("data")
    private Object data;


    // Getters and setters
}