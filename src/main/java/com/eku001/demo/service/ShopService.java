package com.eku001.demo.service;

import com.eku001.demo.domain.Shop;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * Created by Peter.Xu on 2016/3/7.
 */
@Validated
public interface ShopService {
    @NotNull(message = "对象不存在")
    Shop create(@NotBlank(message = "不能为空") String name);

    @NotNull(message = "对象不存在")
    Shop delete(@NotBlank(message = "不能为空") String name);

    @NotNull(message = "对象不存在")
    Shop updateName(@NotBlank(message = "不能为空") String name, @NotBlank(message = "不能为空") String newName);

    @NotNull(message = "对象不存在")
    Shop updateIntro(@NotBlank(message = "不能为空") String name, @NotBlank(message = "不能为空") String intro);

    @NotNull(message = "对象不存在")
    Page<Shop> findAll(@NotNull(message = "不能为空") Pageable page);

    @NotNull(message = "对象不存在")
    Shop findByName(@NotBlank(message = "不能为空") String name);

    @NotNull(message = "对象不存在")
    Shop findById(@NotBlank(message = "不能为空") String id);
}
