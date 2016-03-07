package com.eku001.demo.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by Peter.Xu on 2016/3/7.
 */
@Entity
@Table(name = "d_book")
public class Book {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;
    private String intro;
    @ManyToOne
    private Shelf shelf;
    @Column(unique = true)
    private String name;
    private boolean deleted = true;

    public Book() {
        super();
    }

    public Book(String name) {
        this.name = name;
    }


    public Book(String name, Shelf shelf) {
        this.name = name;
        this.shelf = shelf;
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

    public Shelf getShelf() {
        return shelf;
    }

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
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
