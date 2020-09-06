package com.recetario.webGestion.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Receta {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_receta")
	public long id;

	public String descripcion;
	public String nombre;
	public String urlImg;
	public int tiempoPreparacion;
	public int raciones;

	@OneToMany(mappedBy = "receta", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Ingrediente> listaIngredientes = new ArrayList<Ingrediente>();

	public Receta() {
		// TODO Auto-generated constructor stub
	}

	public Receta(long id, String descripcion, String nombre, String urlImg, int tiempoPreparacion, int raciones,
			List<Ingrediente> listaIngredientes) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.urlImg = urlImg;
		this.tiempoPreparacion = tiempoPreparacion;
		this.raciones = raciones;
		this.listaIngredientes = listaIngredientes;
	}

	public List<Ingrediente> getListaIngredientes() {
		return listaIngredientes;
	}

	public void setListaIngredientes(List<Ingrediente> listaIngredientes) {
		this.listaIngredientes = listaIngredientes;
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

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	public int getTiempoPreparacion() {
		return tiempoPreparacion;
	}

	public void setTiempoPreparacion(int tiempoPreparacion) {
		this.tiempoPreparacion = tiempoPreparacion;
	}

	public int getRaciones() {
		return raciones;
	}

	public void setRaciones(int raciones) {
		this.raciones = raciones;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
}
