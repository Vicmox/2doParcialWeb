package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Partido implements Serializable{

	private int id;
	private Date fecha;
	private int estadio_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getEstadio_id() {
		return estadio_id;
	}
	public void setEstadio_id(int estadio_id) {
		this.estadio_id = estadio_id;
	}
	
	
}
