
package com.example.demo.controller;

import com.example.demo.entities.Continente;
import com.example.demo.repository.ContinenteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/continentes")

public class ContinenteController {
    	
    @Autowired
    ContinenteRepository continenteRepository;

    @GetMapping
    public List<Continente> getContinenteAll() {

        return continenteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Continente getContinentebyId(@PathVariable Integer id) {

        Optional<Continente> continente = continenteRepository.findById(id);

        if (continente.isPresent()) {
            return continente.get();
        }

        return null;

    }
}
