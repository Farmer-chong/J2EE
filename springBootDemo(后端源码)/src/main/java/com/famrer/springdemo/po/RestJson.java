package com.famrer.springdemo.po;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestJson {
    private int code;
    private String message;
    private Object data;

    public static RestJson make() {
        return new RestJson(200, "ok", null);
    }

    public static RestJson make(int code) {
        return new RestJson(code, "ok", null);
    }

    public static RestJson make(String msg) {
        return new RestJson(200, msg, null);
    }

    public static RestJson make(Object data) {
        return new RestJson(200, "ok", data);
    }

    public static RestJson make(int code, String msg) {
        return new RestJson(code, msg, null);
    }

    public static RestJson error(int code, String msg) {
        return new RestJson(code, msg, null);
    }
    public static RestJson error(int code) {
        return new RestJson(code, "error", null);
    }
    public static RestJson error(Object data){
        return new RestJson(500, "处理出错", data);
    }
    public static RestJson error(String msg) {
        return new RestJson(500, msg, null);
    }
    public static RestJson error(){
        return new RestJson(500, "处理出错", null);
    }


    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "{}";
        }
    }

}
