package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Continente implements Serializable{

    @Id
    @SequenceGenerator(name = "continente_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "continente_id_seq")
    private Integer id;
    @Column(name="partido_id")
    private Integer partido;
    @Column(name="seleccion_id")
    private Integer seleccionId;
    private Integer goles;
    private Integer amarillas;
    private Integer rojas;
}
