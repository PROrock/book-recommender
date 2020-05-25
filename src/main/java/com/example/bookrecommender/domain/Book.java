package com.example.bookrecommender.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

//@Entity
//@Table(name="book")
public class Book extends AbstractEntity {

//    @Id
//    @Column(name = "author_id", unique = true)
    private Long id;

//    @Column(name = "name")
    private String name;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "author_id")
    private Author author;


    public Book() {
        // empty constructor for JPA
    }

    public Book(Long id, String name, Author author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    @Override
    public Serializable getPrimaryKey() {
        return getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("author", author)
                .toString();
    }
}
