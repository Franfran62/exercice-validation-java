package com.example.livre.controller.impl;

import com.example.livre.controller.CrudInterfaceController;
import com.example.livre.model.Genre;
import com.example.livre.service.CrudInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/genre")
public class GenreRestController implements CrudInterfaceController<Genre> {


    @Autowired
    private CrudInterfaceService genreService;

    @Override
    @GetMapping
    public Optional<List<Genre>> returnAll() {
        return genreService.returnAll();
    }

    @Override
    @GetMapping("/{id}")
    public Optional<Genre> returnOneById(@PathVariable Long id){
        return genreService.returnOneById(id);
    }

    @Override
    @PutMapping
    public Optional<Genre> createOne(@RequestBody Genre genreToCreate) {
        return genreService.createOne(genreToCreate);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteOneById(@PathVariable Long id) {
        genreService.deleteOneById(id);
    }
}
