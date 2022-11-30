/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.entities.Resultado;
import com.example.demo.entities.Seleccion;
import com.example.demo.repository.ResultadoRepository;
import com.example.demo.repository.SeleccionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resultados")

public class ResultadoController {

    @Autowired
    ResultadoRepository resultadoRepository;

    @GetMapping
    public List<Resultado> getResultadoAll() {

        return resultadoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Resultado getResultadobyId(@PathVariable Integer id) {

        Optional<Resultado> resultado = resultadoRepository.findById(id);

        if (resultado.isPresent()) {
            return resultado.get();
        }

        return null;

    }

    @PostMapping
    public Resultado postResultado(@RequestBody Resultado resultado) {

        resultadoRepository.save(resultado);

        return resultado;

    }

    @PutMapping("/{id}")
    public Resultado putResultadobyId(@PathVariable Integer id, @RequestBody Resultado resultado) {

        Optional<Resultado> resultadoCurrent = resultadoRepository.findById(id);

        if (resultadoCurrent.isPresent()) {

            Resultado resultadoReturn = resultadoCurrent.get();



            resultadoRepository.save(resultadoReturn);

            return resultadoReturn;
        }

        return null;

    }

}
