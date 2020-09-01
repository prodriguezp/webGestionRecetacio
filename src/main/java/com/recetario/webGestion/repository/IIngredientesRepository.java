package com.recetario.webGestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recetario.webGestion.model.Ingrediente;
@Repository("ingredienteRepository")
public interface IIngredientesRepository extends JpaRepository<Ingrediente, Long>{

}
