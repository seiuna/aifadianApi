package cn.seiua.afdapi.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Builder
@Data
public class AfdRequestReq {


    private String user_id;
    @JsonIgnore
    private Object param;
    private String params;
    private String sign;
    private long ts;
    @JsonIgnore
    private transient String token;
    private static ObjectMapper mapper = new ObjectMapper();

    public AfdRequestReq setup() {
        try {
            ts = System.currentTimeMillis() / 1000;
            System.out.println(ts);
            String v = mapper.writeValueAsString(param);
            params = v;
            v = token + "params" + params + "ts" + ts + "user_id" + user_id;
            MessageDigest md = MessageDigest.getInstance("MD5");
            String s = new BigInteger(1, md.digest(v.getBytes(StandardCharsets.UTF_8))).toString(16);
            sign = s;
        } catch (NoSuchAlgorithmException | JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public String toJsonString() {
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}



