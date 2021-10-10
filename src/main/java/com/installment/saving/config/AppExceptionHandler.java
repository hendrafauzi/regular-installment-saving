package com.installment.saving.config;

import com.installment.saving.exception.GeneralException;
import com.installment.saving.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(value = { GeneralException.class })
    public ResponseEntity<Object> generalError(GeneralException ge) {
        return new ResponseEntity<>(new Response(HttpStatus.INTERNAL_SERVER_ERROR.toString(),ge.toString()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
