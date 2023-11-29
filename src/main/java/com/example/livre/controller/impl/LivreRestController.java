package com.example.livre.controller.impl;

import com.example.livre.controller.CrudInterfaceController;
import com.example.livre.model.Livre;
import com.example.livre.service.impl.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livre")
public class LivreRestController implements CrudInterfaceController<Livre> {

    @Autowired
    private LivreService livreService;

    @Override
    @GetMapping
    public Optional<List<Livre>> returnAll() {
        return livreService.returnAll();
    }

    @Override
    @GetMapping("/{id}")
    public Optional<Livre> returnOneById(@PathVariable Long id){
        return livreService.returnOneById(id);
    }

    @Override
    @PutMapping
    public Optional<Livre> createOne(@RequestBody Livre livreToCreate) {
        return livreService.createOne(livreToCreate);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteOneById(@PathVariable Long id) {
        livreService.deleteOneById(id);
    }

}
