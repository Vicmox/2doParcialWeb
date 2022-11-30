package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Seleccion;
import java.util.List;

public interface SeleccionRepository extends JpaRepository<Seleccion, Integer> {

    public List<Seleccion> findByGrupo(String grupo);
}
