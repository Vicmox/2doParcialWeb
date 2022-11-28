package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Continente {
	
	@Id
	private int id;
	private String nombre;
}
