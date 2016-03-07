package com.eku001.demo.rest;

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
public class BookRestService {

    @RequestMapping(value = "", method = {RequestMethod.GET})
    public Map<String, Object> findAll() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("name", "test");
        return map;
    }

}
