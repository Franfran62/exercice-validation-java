package com.example.livre.service.impl;

import com.example.livre.model.Livre;
import com.example.livre.repository.LivreRepository;
import com.example.livre.service.CrudInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivreService implements CrudInterfaceService<Livre> {


    @Autowired
    private LivreRepository livreRepository;

    @Override
    public Optional<List<Livre>> returnAll() {
        List<Livre> response = livreRepository.findAll();
        return response.isEmpty() ? Optional.empty() : Optional.of(response);
    }

    @Override
    public Optional<Livre> returnOneById(Long id) {
        return livreRepository.findById(id);
    }

    @Override
    public Optional<Livre> createOne(Livre livreToCreate) {
        Livre livreCreated = livreRepository.save(livreToCreate);
        return Optional.of(livreCreated);
    }

    @Override
    public void deleteOneById(Long id) {
        livreRepository.deleteById(id);
    }
}
