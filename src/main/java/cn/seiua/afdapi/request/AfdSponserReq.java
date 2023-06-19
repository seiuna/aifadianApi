package cn.seiua.afdapi.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class AfdSponserReq{
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer page;

}
