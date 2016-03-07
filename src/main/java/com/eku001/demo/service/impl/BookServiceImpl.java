package com.eku001.demo.service.impl;

import com.eku001.demo.domain.Book;
import com.eku001.demo.domain.Shelf;
import com.eku001.demo.repository.BookRepo;
import com.eku001.demo.repository.ShelfRepo;
import com.eku001.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;

/**
 * Created by Peter.Xu on 2016/3/7.
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    protected BookRepo bookRepo;
    @Autowired
    protected ShelfRepo shelfRepo;

    @Override
    public Book create(String shelfName, String name) {
        Shelf shelf = shelfRepo.findByName(shelfName);
        final Book book = new Book(name, shelf);
        return bookRepo.save(book);
    }

    @Override
    public Book findByName(String name) {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return bookRepo.findByName(name);
    }

    @Override
    public Book delete(String name) {
        final Book book = bookRepo.findByName(name);
        book.setDeleted(true);
        return book;
    }

    @Override
    public Book updateName(String name, String newName) {
        final Book book = bookRepo.findByName(name);
        book.setName(newName.trim());
        return book;
    }

    @Override
    public Book updateIntro(String name, String intro) {
        final Book book = bookRepo.findByName(name);
        book.setIntro(intro.trim());
        return book;
    }

    @Override
    public Page<Book> findAll(Pageable page) {
        return bookRepo.findAll(page);
    }

}
