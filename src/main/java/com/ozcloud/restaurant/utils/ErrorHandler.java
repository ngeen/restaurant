package com.ozcloud.restaurant.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    public ErrorHandler() {
        super();
    }

    /**
     * Handling not found for all entity.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse> handleNotFoundException(Exception ex) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus(false);
        baseResponse.setCode(HttpStatus.NOT_FOUND.value());
        baseResponse.setMessage(ex.getClass().getSimpleName() + " : " + ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(baseResponse);
    }

}
