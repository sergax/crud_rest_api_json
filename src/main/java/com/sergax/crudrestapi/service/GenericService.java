package com.sergax.crudrestapi.service;

import java.util.List;

public interface GenericService<ID, T> {

    List<T> getAll();

    T getById(ID id);

    void create(T t);

    void update(T t);

    boolean delete(ID id);
}
