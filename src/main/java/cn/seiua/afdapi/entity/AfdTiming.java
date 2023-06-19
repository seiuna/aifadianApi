package cn.seiua.afdapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AfdTiming {
    @JsonProperty("timing_on")
    public int timingOn;
    @JsonProperty("timing_off")
    public int timingOff;
}
