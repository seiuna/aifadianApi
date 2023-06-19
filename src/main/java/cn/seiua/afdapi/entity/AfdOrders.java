package cn.seiua.afdapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class AfdOrders {
    @JsonProperty("list")
    private List<AfdOrder> list;
    /**
     * 赞助者总数
     */
    @JsonProperty("total_count")
    private int totalCount;
    /**
     * 页数，默认每页x条，请求时，传 page ，curr_page < total_page则可继续请求
     */
    @JsonProperty("total_page")
    private int totalPage;

    @JsonProperty("request")
    private Object request;
}
