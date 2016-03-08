package com.eku001.demo.service.impl;

import com.eku001.demo.domain.Shop;
import com.eku001.demo.exception.EntityNotFound;
import com.eku001.demo.repository.ShopRepo;
import com.eku001.demo.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

/**
 * Created by Peter.Xu on 2016/3/7.
 */
@Service
@Transactional
public class ShopServiceImpl implements ShopService {
    @Autowired
    protected ShopRepo shopRepo;

    @Override
    public Shop create(String name) {
        return shopRepo.save(new Shop(name));
    }

    @Override
    public Shop delete(String name) {
        Shop shop = shopRepo.findByNameAndDeletedFalse(name);
        if (shop == null) {
            throw new EntityNotFound();
        }

        shop.setDeleted(true);
        return shop;
    }

    @Override
    public Shop updateName(String name, String newName) {
        Shop shop = shopRepo.findByNameAndDeletedFalse(name);
        if (shop == null) {
            throw new EntityNotFound();
        }

        shop.setName(newName);
        return shop;
    }

    @Override
    public Shop updateIntro(String name, String intro) {
        Shop shop = shopRepo.findByNameAndDeletedFalse(name);
        if (shop == null) {
            throw new EntityNotFound();
        }

        shop.setIntro(intro);
        return shop;
    }

    @Override
    public Page<Shop> findAll(Pageable page) {
        return shopRepo.findAll(page);
    }

    @Override
    public Shop findByName(String name) {
        Shop shop = shopRepo.findByNameAndDeletedFalse(name);
        if (shop == null) {
            throw new EntityNotFound();
        }

        return shop;
    }

    @Override
    public Shop findById(final String id) {
        final Shop shop = shopRepo.findOne(UUID.fromString(id));
        if (shop == null) {
            throw new EntityNotFound();
        }

        return shop;
    }
}
