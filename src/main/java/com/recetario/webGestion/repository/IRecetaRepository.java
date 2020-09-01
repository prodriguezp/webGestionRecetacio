package com.recetario.webGestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recetario.webGestion.model.Receta;
@Repository("recetaRepository")
public interface IRecetaRepository extends JpaRepository<Receta, Long>{
	

}
