package com.example.demo.controller;

import com.example.demo.entities.Estadio;
import com.example.demo.repository.EstadioRepository;
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

@RestController
@RequestMapping("/estadios")

public class EstadioController {

    @Autowired
    EstadioRepository estadioRepository;

    @GetMapping
    public List<Estadio> getEstadioAll() {

        return estadioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Estadio getEstadiobyId(@PathVariable Integer id) {

        Optional<Estadio> estadio = estadioRepository.findById(id);

        if (estadio.isPresent()) {
            return estadio.get();
        }

        return null;

    }

    @PostMapping
    public Estadio postEstadio(@RequestBody Estadio estadio) {

        estadioRepository.save(estadio);

        return estadio;

    }

    @PutMapping("/{id}")
    public Estadio putSeleccionbyId(@PathVariable Integer id, @RequestBody Estadio estadio) {

        Optional<Estadio> estadioCurrent = estadioRepository.findById(id);

        if (estadioCurrent.isPresent()) {

            Estadio estadioReturn = estadioCurrent.get();

            estadioReturn.setNombre(estadio.getNombre());
            estadioReturn.setCapacidad(estadio.getCapacidad());

            estadioRepository.save(estadioReturn);

            return estadioReturn;
        }

        return null;

    }

    @DeleteMapping("/{id}")
    public Estadio deleteEstadiobyId(@PathVariable Integer id) {

        Optional<Estadio> estadio = estadioRepository.findById(id);

        if (estadio.isPresent()) {

            Estadio estadioReturn = estadio.get();

            estadioRepository.deleteById(id);

            return estadioReturn;
        }

        return null;

    }
}
