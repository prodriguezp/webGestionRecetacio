package com.recetario.webGestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recetario.webGestion.entitySecurity.Authority;

@Repository("autoRepositorio")
public interface AutorityRepository extends JpaRepository<Authority, Long> {

}
