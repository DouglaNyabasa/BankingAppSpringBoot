package com.example.bankingApp.generics.service;

import java.util.List;

public interface GenericService<T> {

    Integer save(T dto);

    List<T> findAll();

    T findById(Integer id);

    void delete(Integer id);

}
