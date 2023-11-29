package com.example.livre.service.impl;

import com.example.livre.controller.CrudInterfaceController;
import com.example.livre.model.Genre;
import com.example.livre.repository.GenreRepository;
import com.example.livre.service.CrudInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService implements CrudInterfaceService<Genre> {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public Optional<List<Genre>> returnAll() {
        List<Genre> response = genreRepository.findAll();
        return response.isEmpty() ? Optional.empty() : Optional.of(response);
    }

    @Override
    public Optional<Genre> returnOneById(Long id) {
        return genreRepository.findById(id);
    }

    @Override
    public Optional<Genre> createOne(Genre genreToCreate) {
        Genre genreCreated = genreRepository.save(genreToCreate);
        return Optional.of(genreCreated);
    }

    @Override
    public void deleteOneById(Long id) {
        genreRepository.deleteById(id);
    }
}
