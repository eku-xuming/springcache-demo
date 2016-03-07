package com.eku001.demo.repository;

import com.eku001.demo.domain.Book;
import com.sun.istack.internal.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

/**
 * Created by Peter.Xu on 2016/3/7.
 */
@Validated
@Component
public interface BookRepo extends JpaRepository<Book, UUID> {
    @NotNull
    Book findByName(@NotBlank String name);

    @NotNull
    Page<Book> findByShelfName(@NotBlank String name, @NotBlank Pageable page);
}
