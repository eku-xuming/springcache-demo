package com.eku001.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

/**
 * Created by Peter.Xu on 2016/3/8.
 */

@ControllerAdvice
public abstract class BaseRestService {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity exception(final Throwable t) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new HashMap<String, Object>() {{
            put("message", "error");
            put("s", t.getStackTrace());
        }});
    }
}
