package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "seleccion")
public class Seleccion implements Serializable {

    @Id
    @SequenceGenerator(name = "seleccion_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seleccion_id_seq")
    private int id;
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "continente_id")
    private Continente continente;
    private String grupo;
}
