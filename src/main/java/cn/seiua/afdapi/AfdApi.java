package cn.seiua.afdapi;

import cn.seiua.afdapi.entity.AfdOrders;
import cn.seiua.afdapi.entity.AfdOrder;
import cn.seiua.afdapi.entity.AfdSponsers;
import cn.seiua.afdapi.request.AfdOrderReq;
import cn.seiua.afdapi.request.AfdRequestReq;
import cn.seiua.afdapi.request.AfdSponserReq;
import cn.seiua.afdapi.response.ResponseData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import okhttp3.*;

import java.io.IOException;
import java.util.Optional;

@Data
public class AfdApi {
    private String userid;
    private String token;
    private final String ORDER="https://afdian.net/api/open/query-order";
    private final String SPONSER="https://afdian.net/api/open/query-sponsor";
    private OkHttpClient client;
    private static ObjectMapper mapper = new ObjectMapper();

   AfdApi(String userid, String token) {
        this.userid = userid;
        this.token = token;
        this.client=new OkHttpClient();
    }
    public static AfdApi build(String userid, String token){
        return new AfdApi(userid,token);
    }
    private Request generateRequest(String json,String url){
       RequestBody requestBody=RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));;
       return new Request.Builder().post(requestBody).url(url).build();
    }
    private String execute(String json,String url){
       Request request=generateRequest(json,url);
        Call call=client.newCall(request);
        try {
            Response response=call.execute();
            String data=response.body().string();
            return data;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Optional<AfdOrder> queryOrder(String tradeId){
        Optional<AfdOrder> optional=Optional.empty();
        String json= AfdRequestReq.builder().user_id(userid).token(token).param(AfdOrderReq.builder().page(1).out_trade_no(tradeId).build()).build().setup().toJsonString();
        String data=this.execute(json,ORDER);
        try {
            ResponseData responseData = mapper.readValue(data, ResponseData.class);
            if(responseData.getEc()==200){
                AfdOrders afdOrderDataEntity=mapper.convertValue(responseData.getData(), AfdOrders.class);
                if(afdOrderDataEntity.getList().size()==1){
                    return Optional.of(afdOrderDataEntity.getList().get(0));
                }
            }else {
                throw new RuntimeException("ec: "+responseData.getEc()+" em: "+responseData.getEm()+"  see-> "+"https://guide.afdian.net/creator/developer#qian-ming-jie-shao");
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return optional;
    }
    public Optional<AfdOrders> queryOrder(Integer page){
        Optional<AfdOrders> optional=Optional.empty();
        String json= AfdRequestReq.builder().user_id(userid).token(token).param(AfdOrderReq.builder().page(1).page(page).build()).build().setup().toJsonString();
        String data=this.execute(json,ORDER);
        try {
            ResponseData responseData = mapper.readValue(data, ResponseData.class);
            if(responseData.getEc()==200){
                AfdOrders afdOrderDataEntity=mapper.convertValue(responseData.getData(), AfdOrders.class);
                return Optional.of(afdOrderDataEntity);
            }else {
                throw new RuntimeException("ec: "+responseData.getEc()+" em: "+responseData.getEm()+"  see-> "+"https://guide.afdian.net/creator/developer#qian-ming-jie-shao");
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    public Optional<AfdSponsers> querySponsor(Integer page){
        Optional<AfdOrders> optional=Optional.empty();
        String json= AfdRequestReq.builder().user_id(userid).token(token).param(AfdSponserReq.builder().page(page).build()).build().setup().toJsonString();
        String data=this.execute(json,SPONSER);
        System.out.println(data+" datada");
        try {
            ResponseData responseData = mapper.readValue(data, ResponseData.class);
            if(responseData.getEc()==200){
                AfdSponsers afdSponsers=mapper.convertValue(responseData.getData(), AfdSponsers.class);
                System.out.println(afdSponsers);
                return Optional.of(afdSponsers);
            }else {
                throw new RuntimeException("ec: "+responseData.getEc()+" em: "+responseData.getEm()+"  see-> "+"https://guide.afdian.net/creator/developer#qian-ming-jie-shao");
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }




}
