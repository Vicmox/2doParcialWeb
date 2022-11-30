package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
public class Estadio implements Serializable {

    @Id
    @SequenceGenerator(name = "estadio_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estadio_id_seq")
    private int id;
    private String nombre;
    private int capacidad;
}
