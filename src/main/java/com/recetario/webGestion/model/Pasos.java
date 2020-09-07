package com.recetario.webGestion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pasos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	
	@Column(columnDefinition = "LONGTEXT")
	public String descripcion;
	
	@ManyToOne()
    @JoinColumn(name = "fk_receta_pasos")
	public Receta receta;
	
	public Pasos() {
		// TODO Auto-generated constructor stub
	}

	public Pasos(long id, String descripcion,Receta receta) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.receta = receta;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Receta getReceta() {
		return receta;
	}
	public void setReceta(Receta receta) {
		this.receta = receta;
	}
	
}
