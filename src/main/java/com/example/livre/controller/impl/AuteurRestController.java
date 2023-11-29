package com.example.livre.controller.impl;

import com.example.livre.controller.CrudInterfaceController;
import com.example.livre.model.Auteur;
import com.example.livre.service.CrudInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auteur")
public class AuteurRestController implements CrudInterfaceController<Auteur> {

    @Autowired
    private CrudInterfaceService auteurService;

    @Override
    @GetMapping
    public Optional<List<Auteur>> returnAll() {
        return auteurService.returnAll();
    }

    @Override
    @GetMapping("/{id}")
    public Optional<Auteur> returnOneById(@PathVariable Long id){
        return auteurService.returnOneById(id);
    }

    @Override
    @PutMapping
    public Optional<Auteur> createOne(@RequestBody Auteur auteurToCreate) {
        return auteurService.createOne(auteurToCreate);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteOneById(@PathVariable Long id) {
        auteurService.deleteOneById(id);
    }
}
