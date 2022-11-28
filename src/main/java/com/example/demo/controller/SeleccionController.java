package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entities.Seleccion;
import com.example.demo.repository.SeleccionRepository;


@RestController
@RequestMapping("/selecciones")

public class SeleccionController {
	
	
    @Autowired
    SeleccionRepository seleccionRepository;

    @GetMapping
    public List<Seleccion> getSeleccionAll() {

        return seleccionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Seleccion getSeleccionbyId(@PathVariable Integer id) {

        Optional<Seleccion> seleccion = seleccionRepository.findById(id);

        if (seleccion.isPresent()) {
            return seleccion.get();
        }

        return null;

    }

    @PostMapping
    public Seleccion postSeleccion(@RequestBody Seleccion seleccion) {

    	seleccionRepository.save(seleccion);

        return seleccion;

    }

    @PutMapping("/{id}")
    public Seleccion putSeleccionbyId(@PathVariable Integer id, @RequestBody Seleccion seleccion) {

        Optional<Seleccion> seleccionCurrent = seleccionRepository.findById(id);

        if (seleccionCurrent.isPresent()) {

        	Seleccion seleccionReturn = seleccionCurrent.get();

      
        	seleccionReturn.setNombre(seleccion.getNombre());

            seleccionRepository.save(seleccionReturn);

            return seleccionReturn;
        }

        return null;

    }


}
