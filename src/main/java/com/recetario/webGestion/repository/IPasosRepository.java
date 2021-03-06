package com.recetario.webGestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recetario.webGestion.model.Ingrediente;
import com.recetario.webGestion.model.Pasos;
@Repository("pasosRepository")
public interface IPasosRepository extends JpaRepository<Pasos, Long>{

}
