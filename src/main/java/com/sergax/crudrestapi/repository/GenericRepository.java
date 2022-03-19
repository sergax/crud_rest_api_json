package com.sergax.crudrestapi.repository;

import java.util.List;

public interface GenericRepository<ID, T> {

    List<T> getAll();

    T getById(ID id);

    void create(T t);

    void update(T t);

    boolean delete(ID id);
}
