package com.recetario.webGestion.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
public class Ingrediente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_ingrediente")
	public long id;
	
	
	public String nombre;
	public int cantidad;
	public String medida;
	
	@ManyToOne()
    @JoinColumn(name = "fk_receta_ingrediente")
	public Receta receta;
	
	
	
	public Ingrediente() {
		// TODO Auto-generated constructor stub
	}


	public Ingrediente(long id, String nombre, int cantidad, String medida,Receta receta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.medida = medida;
		this.receta = receta;
		
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public String getMedida() {
		return medida;
	}


	public void setMedida(String medida) {
		this.medida = medida;
	}


	public Receta getReceta() {
		return receta;
	}


	public void setReceta(Receta receta) {
		this.receta = receta;
	}


	
	
	
	
	
}
