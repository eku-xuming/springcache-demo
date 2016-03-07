package com.eku001.demo.service;

import com.eku001.demo.domain.Shelf;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

/**
 * Created by Peter.Xu on 2016/3/7.
 */
@Validated
public interface ShelfService {
    Shelf create(String shopName, String name);

    Shelf delete(String name);

    Shelf updateName(String name,String newName);

    Shelf updateIntro(String name, String intro);

    Page<Shelf> findAll(Pageable page);

    Shelf findByName(String name);
}
