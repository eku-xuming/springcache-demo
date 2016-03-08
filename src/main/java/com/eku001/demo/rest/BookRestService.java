package com.eku001.demo.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Peter.Xu on 2016/3/7.
 */
@RestController
@RequestMapping(value = "/books")
public class BookRestService extends BaseRestService {

    @RequestMapping(value = "", method = {RequestMethod.GET})
    public Map<String, Object> findAll() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("name", "server.compression.min-response-sizeserver.compression.min-response-sizeserver.compression.min-response-sizeserver.compression.min-response-sizeserver.compression.min-response-sizeserver.compression.min-response-sizeserver.compression.min-response-sizeserver.compression.min-response-sizeserver.compression.min-response-sizeserver.compression.min-response-sizeserver.compression.min-response-sizeserver.compression.min-response-sizeserver.compression.min-response-sizeserver.compression.min-response-sizeserver.compression.min-response-sizeserver.compression.min-response-sizeserver.compression.min-response-sizeserver.compression.min-response-sizeserver.compression.min-response-sizeserver.compression.min-response-sizeserver.compression.min-response-size");
        return map;
    }

    @RequestMapping(value = "/cache", method = {RequestMethod.GET})
    public ResponseEntity cacheFind() {
        if (System.currentTimeMillis() % 10 == 0) throw new RuntimeException("hi");

        return ResponseEntity.status(HttpStatus.OK).headers(new HttpHeaders() {{
            add(HttpHeaders.CACHE_CONTROL, "max-age=3600");
        }}).body(new HashMap<String, String>() {{
            put("test", "sizeserver.compression.min-response-sizeserver.compression.min-response-sizeserver.compression.min-response-sizeserver.compression.min-response-sizeserver.compression.min-response-sizeserver.compression.min-response-sizeserver.compression.min-response-sizeserver.compression.min-response-sizeserver.compression.min-response-size");
        }});
    }

}
