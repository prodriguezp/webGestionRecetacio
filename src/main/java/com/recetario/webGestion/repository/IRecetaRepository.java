package com.recetario.webGestion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.recetario.webGestion.model.Receta;
@Repository("recetaRepository")
public interface IRecetaRepository extends JpaRepository<Receta, Long>{

	@Query("SELECT r FROM Receta r where r.nombre LIKE %:nombre%")
	List<Receta> findAllByNombre( @Param("nombre")String queryName);
	

}
