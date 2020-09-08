package com.recetario.webGestion.repository;


import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.recetario.webGestion.entitySecurity.User;

@Repository("userRepositorio")
public interface UserRepository extends CrudRepository<User, Long>  {
    public Optional<User> findByUsername(String username);
}