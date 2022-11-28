package com.example.demo.entities;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;


@Entity
@Data
public class Seleccion  implements Serializable {
	
    @Id
    private int id;

    private String nombre;
    private int continente_id;
    
    protected Seleccion() {
    	
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getContinente_id() {
		return continente_id;
	}

	public void setContinente_id(int continente_id) {
		this.continente_id = continente_id;
	}
    
    

}
