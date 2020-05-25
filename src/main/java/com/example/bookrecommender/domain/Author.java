package com.example.bookrecommender.domain;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

//@Entity
//@Table(name="author")
public class Author extends AbstractEntity {

//    @Id
//    @Column(name = "author_id", unique = true)
    private Long id;

//    @Column(name = "name")
    private String name;


    public Author() {
        // empty constructor for JPA
    }

    public Author(Long id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .toString();
    }
}
