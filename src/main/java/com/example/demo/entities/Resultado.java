/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

@Data
@Entity
@Table(name = "resultado")
@CrossOrigin
public class Resultado implements Serializable{

    @Id
    @SequenceGenerator(name = "resultado_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resultado_id_seq")
    private int id;
    @Column(name="partido_id")
    private int partido_id;
    @Column(name="seleccion_id")
    private int seleccion_id;
    private int goles;
    private int amarillas;
    private int rojas;
}
