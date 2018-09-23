package com.ozcloud.restaurant.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@Getter
@Setter
public class BaseResponse {

    Boolean status;

    Integer code;

    String message;

    Object payload;

    public static BaseResponse getOkResponse(Object o){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus(true);
        baseResponse.setCode(HttpStatus.OK.value());
        baseResponse.setMessage("Success");
        baseResponse.setPayload(o);
        return baseResponse;
    }

    public static BaseResponse getOkResponse(Object o, String message){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus(true);
        baseResponse.setCode(HttpStatus.OK.value());
        baseResponse.setMessage(message);
        baseResponse.setPayload(o);
        return baseResponse;
    }
}
