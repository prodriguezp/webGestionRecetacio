package com.recetario.webGestion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.recetario.webGestion.model.RecetaBusqueda;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/menu")
	public ModelAndView listadoRecetas() {
		ModelAndView mav = new ModelAndView("test");
		

		return mav;
	}
}
