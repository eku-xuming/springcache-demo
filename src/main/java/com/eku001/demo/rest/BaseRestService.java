package com.eku001.demo.rest;

import com.eku001.demo.exception.EntityNotFound;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * Created by Peter.Xu on 2016/3/8.
 */

@ControllerAdvice
public abstract class BaseRestService {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> parameter(final ConstraintViolationException exception) {
        exception.printStackTrace();
        return new HashMap<String, Object>() {{
            put("message", "error");

            final Set<ConstraintViolation<?>> cvs = exception.getConstraintViolations();
            final LinkedList<String> errors = new LinkedList<String>();
            for (ConstraintViolation cv : cvs) {
                errors.add(cv.getMessage());
            }

            put("details", errors);
        }};
    }

    @ExceptionHandler(EntityNotFound.class)
    public ResponseEntity notFound(final EntityNotFound t) {
        t.printStackTrace();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HashMap<String, Object>() {{
            put("message", "notFound");
        }});
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity illegalArgument(final IllegalArgumentException t) {
        t.printStackTrace();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HashMap<String, Object>() {{
            put("message", "请求参数错误");
        }});
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity exception(final Throwable t) {
        t.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new HashMap<String, Object>() {{
            put("message", "error");
            put("s", t.getStackTrace());
        }});
    }


}
