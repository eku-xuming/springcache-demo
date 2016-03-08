package com.eku001.demo.rest;

import com.eku001.demo.domain.Shop;
import com.eku001.demo.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Peter.Xu on 2016/3/8.
 */
@RestController
@RequestMapping(value = "/shops")
public class ShopRestService extends BaseRestService {
    @Autowired
    protected ShopService shopService;

    @RequestMapping(value = "", method = {RequestMethod.GET})
    public Page<Shop> findAll(final @RequestParam(defaultValue = "0", required = false) Integer page, final @RequestParam(defaultValue = "30", required = false) Integer size) {
        return shopService.findAll(new PageRequest((page < 0) ? 0 : page, (size < 10 || size >= 100) ? 30 : size));
    }

    @RequestMapping(value = "", method = {RequestMethod.POST})
    public Shop create(@RequestBody Shop shop) {
        return shopService.create(shop.getName());
    }

    @RequestMapping(value = "", method = {RequestMethod.GET}, params = {"name="})
    public Shop findByName(@RequestParam(name = "name") String name) {
        return shopService.findByName(name);
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public Shop findById(@PathVariable String id) {
        return shopService.findById(id);
    }
}
