package com.eku001.demo.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by Peter.Xu on 2016/3/7.
 */
@Entity
@Table(name="d_shelf")
public class Shelf {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;
    private String intro;
    @ManyToOne
    private Shop shop;
    @Column(unique = true)
    private String name;
    private boolean deleted = false;

    public Shelf() {
        super();
    }

    public Shelf(final String name) {
        this.name = name;
    }

    public Shelf(final Shop shop, final String name) {
        this.shop = shop;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
