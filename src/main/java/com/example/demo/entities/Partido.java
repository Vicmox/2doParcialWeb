package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "partido")
public class Partido implements Serializable{

        @Id
	private int id;
	private Date fecha;
	private int estadio_id;

	
}
