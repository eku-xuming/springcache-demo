package com.eku001.demo.service;

import com.eku001.demo.domain.Shelf;
import com.eku001.demo.domain.Shop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

/**
 * Created by Peter.Xu on 2016/3/7.
 */
@Validated
public interface ShopService {
    Shop create(String name);
    Shop delete(String name);
    Shop updateName(String name,String newName);
    Shop updateIntro(String name,String intro);
    Page<Shop> findAll(Pageable page);
    Shop findByName(String name);
}
