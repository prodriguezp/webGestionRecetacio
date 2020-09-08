package com.recetario.webGestion.controller;

import java.util.Arrays;
import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.recetario.webGestion.entitySecurity.Authority;
import com.recetario.webGestion.entitySecurity.User;
import com.recetario.webGestion.repository.AutorityRepository;
import com.recetario.webGestion.repository.UserRepository;
import com.recetario.webGestion.util.Passgenerator;

@Controller
public class IndexController {
	@Autowired
	@Qualifier("userRepositorio")
	UserRepository repositorioUser;
	
	@Autowired
	@Qualifier("autoRepositorio")
	AutorityRepository repositorioAutority;
	
	@GetMapping(value = {"/login","","/"})
	public String login() {
		return "login";
	}
	
	@GetMapping("menu")
	public String menu(HttpServletRequest request) {
		if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin/menu";
        }
        return "redirect:/user/menu";
	}
	
	@GetMapping("/nuevoUser")
	public String guardarUser() {
		User user = new User();
		user.getId();
		user.setUsername("test");
		user.setPassword(Passgenerator.codificar("123456789"));
		user.setEnabled(true);
		user.setAuthority(new HashSet<>(Arrays.asList(repositorioAutority.getOne((long) 2))));
		
		repositorioUser.save(user);
		return "/";
	}
}
