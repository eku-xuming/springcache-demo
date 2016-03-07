package com.eku001.demo.service.impl;

import com.eku001.demo.domain.Book;
import com.eku001.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Peter.Xu on 2016/3/7.
 */
@Service
@Transactional
public class BookServiceCacheImpl extends BookServiceImpl implements BookService {

    @Autowired
    protected CacheManager cacheManager;

    @Override
    @CachePut(value = "d-book", key = "#name")
    public Book create(final String shelfName, final String name) {
        return super.create(shelfName, name);
    }

    @Override
    @Cacheable(value = "d-book", key = "#name")
    public Book findByName(final String name) {
        return super.findByName(name);
    }

    @Override
    @CacheEvict(value = "d-book", key = "#name")
    public Book delete(final String name) {
        return super.delete(name);
    }

    @Override
    @CachePut(value = "d-book", key = "#name")
    public Book updateName(final String name, final String newName) {
        return super.updateName(name, newName);
    }

    @Override
    @CachePut(value = "d-book", key = "#newName")
    public Book updateIntro(final String name, final String intro) {
        return super.updateIntro(name, intro);
    }

    @Override
    public Page<Book> findAll(final Pageable page) {
        final Page<Book> books = super.findAll(page);
        final Cache cache = cacheManager.getCache("d-book");

        for (Book book : books) {
            cache.put(book.getName(), book);
        }
        return books;
    }
}
