package com.example.bookrecommender.domain;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Objects;

public abstract class AbstractEntity {

    @Transient
    abstract public Serializable getPrimaryKey();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractEntity abstractEntity = (AbstractEntity) o;
        return getPrimaryKey().equals(abstractEntity.getPrimaryKey());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrimaryKey());
    }

}
