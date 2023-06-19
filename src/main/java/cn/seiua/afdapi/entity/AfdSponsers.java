package cn.seiua.afdapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;


@Data
public class AfdSponsers {
    @JsonProperty("list")
    private List<AfdSponser> list;

    @JsonProperty("total_count")
    private int totalCount;

    @JsonProperty("total_page")
    private int totalPage;

    @JsonProperty("request")
    private Object request;


}
