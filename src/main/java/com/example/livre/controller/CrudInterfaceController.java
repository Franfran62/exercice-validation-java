package com.example.livre.controller;

import java.util.List;
import java.util.Optional;

public interface CrudInterfaceController<T> {

    Optional<List<T>> returnAll();

    Optional<T> returnOneById(Long id);

    Optional<T> createOne(T entityToCreate);

    void deleteOneById(Long id);

}
