package com.eku001.demo.service.impl;

import com.eku001.demo.DemoStarter;
import com.eku001.demo.domain.Book;
import com.eku001.demo.domain.Shelf;
import com.eku001.demo.domain.Shop;
import com.eku001.demo.service.BookService;
import com.eku001.demo.service.ShelfService;
import com.eku001.demo.service.ShopService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Random;

/**
 * Created by Peter.Xu on 2016/3/7.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DemoStarter.class)
public class BookServiceImplTest {
    private static final Random R = new Random(System.currentTimeMillis());
    @Resource(name = "bookServiceImpl")
    private BookService bookService;
    @Resource(name = "bookServiceCacheImpl")
    private BookService bookCacheService;
    @Autowired
    private ShelfService shelfService;
    @Autowired
    private ShopService shopService;

    @Autowired
    private CacheManager cacheManager;


    @Test
    @Transactional
    public void testFindByName() {
        final Shop shop = shopService.create(String.format("shop%s", R.nextInt(100000)));
        final Shelf shelf = shelfService.create(shop.getName(), String.format("shelf%s", R.nextInt(100000)));
        Book book = bookService.create(shelf.getName(), String.format("book%s", R.nextInt(100000)));

        long start, end;
        book = bookCacheService.findByName(book.getName());
        Assert.assertNotNull(book);


        /////////////////////////////

        start = System.currentTimeMillis();
        bookService.findByName(book.getName());
        end = System.currentTimeMillis();

        System.out.println(String.format("未缓存使用了%s毫秒", end - start));

        /////////////////////////
        final Cache cache = cacheManager.getCache("d-book");
        final Book bk = (Book) cache.get(book.getName()).get();
        Assert.assertEquals(bk.getId(), book.getId());//已被缓存
        ///////////////////////

        //准备缓存
        bookCacheService.findByName(book.getName());

        start = System.currentTimeMillis();
        bookCacheService.findByName(book.getName());
        end = System.currentTimeMillis();

        System.out.println(String.format("缓存使用了%s毫秒", end - start));
        Assert.assertTrue((end - start) < 10);//小于10个毫秒
    }
}
