package com.eku001.demo.service.impl;

import com.eku001.demo.domain.Shelf;
import com.eku001.demo.domain.Shop;
import com.eku001.demo.repository.ShelfRepo;
import com.eku001.demo.repository.ShopRepo;
import com.eku001.demo.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Peter.Xu on 2016/3/7.
 */
@Service
@Transactional
public class ShelfServiceImpl implements ShelfService {

    @Autowired
    protected ShelfRepo shelfRepo;

    @Autowired
    protected ShopRepo shopRepo;

    @Override
    public Shelf create(String shopName, String name) {
        final Shop shop = shopRepo.findByNameAndDeletedFalse(shopName);
        final Shelf shelf = new Shelf(shop, name);
        shelfRepo.save(shelf);
        return shelf;
    }

    @Override
    public Shelf delete(String name) {
        final Shelf shelf = shelfRepo.findByName(name);
        shelf.setDeleted(true);
        return shelf;
    }

    @Override
    public Shelf updateName(String name, String newName) {
        final Shelf shelf = shelfRepo.findByName(name);
        shelf.setName(newName.trim());
        return shelf;
    }

    @Override
    public Shelf updateIntro(String name, String intro) {
        final Shelf shelf = shelfRepo.findByName(name);
        shelf.setIntro(intro.trim());
        return shelf;
    }

    @Override
    public Page<Shelf> findAll(Pageable page) {
        return shelfRepo.findAll(page);
    }

    @Override
    public Shelf findByName(String name) {
        final Shelf shelf = shelfRepo.findByName(name);
        return shelf;
    }
}
