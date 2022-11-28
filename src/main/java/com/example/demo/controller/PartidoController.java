package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Partido;
import com.example.demo.repository.PartidoRepository;

@RestController
@RequestMapping("/partidos")

public class PartidoController {
	
    @Autowired
    PartidoRepository partidoRepository;

    @GetMapping
    public List<Partido> getPartidoAll() {

        return partidoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Partido getSeleccionbyId(@PathVariable Integer id) {

        Optional<Partido> partido = partidoRepository.findById(id);

        if (partido.isPresent()) {
            return partido.get();
        }

        return null;

    }

    @PostMapping
    public Partido postPartido(@RequestBody Partido partido) {

    	partidoRepository.save(partido);

        return partido;

    }
    
}
