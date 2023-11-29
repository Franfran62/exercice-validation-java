package com.example.livre.service.impl;

import com.example.livre.model.Auteur;
import com.example.livre.repository.AuteurRepository;
import com.example.livre.service.CrudInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuteurService implements CrudInterfaceService<Auteur> {

    @Autowired
    private AuteurRepository auteurRepository;

    @Override
    public Optional<List<Auteur>> returnAll() {
        List<Auteur> response = auteurRepository.findAll();
        return response.isEmpty() ? Optional.empty() : Optional.of(response);
    }

    @Override
    public Optional<Auteur> returnOneById(Long id) {
        return auteurRepository.findById(id);
    }

    @Override
    public Optional<Auteur> createOne(Auteur auteurToCreate) {
        Auteur auteurCreated = auteurRepository.save(auteurToCreate);
        return Optional.of(auteurCreated);
    }

    @Override
    public void deleteOneById(Long id) {
        auteurRepository.deleteById(id);
    }
}
