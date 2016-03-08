package com.eku001.demo.repository;

import com.eku001.demo.domain.Shelf;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * Created by Peter.Xu on 2016/3/7.
 */

@Validated
@Component
public interface ShelfRepo extends JpaRepository<Shelf, UUID> {
    Shelf findByName(@NotBlank String name);

    Page<Shelf> findByShopName(@NotBlank String name, @NotNull Pageable page);
}
