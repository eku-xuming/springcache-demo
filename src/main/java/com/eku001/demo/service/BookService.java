package com.eku001.demo.service;

import com.eku001.demo.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by Peter.Xu on 2016/3/7.
 */
@Validated
public interface BookService {
    Book create(@NotNull(message = "名称不能为空") @Pattern(regexp = "\\w{3,}") String shelfName, @NotNull(message = "名称不能为空") @Pattern(regexp = "\\w{3,}") String name);

    Book findByName(@NotNull(message = "名称不能为空") @Pattern(regexp = "\\w{3,}") String name);

    Book delete(@NotNull(message = "名称不能为空") @Pattern(regexp = "\\w{3,}") String name);

    Book updateName(@NotNull(message = "名称不能为空") @Pattern(regexp = "\\w{3,}") String name, @NotNull(message = "名称不能为空") @Pattern(regexp = "\\w{3,}") String newName);

    Book updateIntro(@NotNull @Pattern(regexp = "\\w{3,}") String name, @NotNull(message = "简介不能为空") @Pattern(regexp = "\\w{3,}") String intro);

    Page<Book> findAll(@NotNull(message = "分页信息错误") Pageable page);
}
