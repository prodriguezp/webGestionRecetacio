package com.recetario.webGestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.recetario.webGestion.model.Ingrediente;
import com.recetario.webGestion.model.Receta;
import com.recetario.webGestion.repository.IIngredientesRepository;
import com.recetario.webGestion.repository.IRecetaRepository;

@Controller()
public class MainController {
	@Autowired
	@Qualifier("recetaRepository")
	IRecetaRepository recetaRepo;
	@Autowired
	@Qualifier("ingredienteRepository")
	IIngredientesRepository ingredientesRepo;

	@GetMapping(value = { "/", "" })
	public ModelAndView listadoRecetas() {
		ModelAndView mav = new ModelAndView("index");

		mav.addObject("listaRecetas", recetaRepo.findAll());

		return mav;
	}

	@GetMapping("/formularioReceta")
	public ModelAndView formularioReceta(@RequestParam(name = "id", required = false) Long id) {
		ModelAndView mav = new ModelAndView("formulario_receta");
		Receta receta = new Receta();

		if (id != null) {
			receta = recetaRepo.findById(id).orElse(null);
		}

		mav.addObject("receta", receta);
		return mav;
	}

	@PostMapping("/guardarReceta")
	public ModelAndView guardarReceta(@ModelAttribute("receta") Receta receta) {
		ModelAndView mav = new ModelAndView("formulario_ingredientes");

		recetaRepo.save(receta);

		Ingrediente i = new Ingrediente();
		i.setReceta(receta);
		mav.addObject("receta", receta);
		mav.addObject("ingrediente", i);

		return mav;
	}

	@PostMapping("/guardarIngrediente")
	public ModelAndView guardarIngrediente(@ModelAttribute("ingrediente") Ingrediente ingrediente,
			@RequestParam(name = "id", required = true) long id) {
		ModelAndView mav = new ModelAndView("formulario_ingredientes");
		
		//Guardamos receta con el nuevo ingrediente
		Receta r = recetaRepo.findById(id).orElse(null);
		ingrediente.setReceta(r);
		r.listaIngredientes.add(ingrediente);
		recetaRepo.save(r);
		
		
		//Nuevo Ingrediente para el formulario
		Ingrediente i = new Ingrediente();
		i.setReceta(r);
		mav.addObject("receta", r);
		mav.addObject("ingrediente", i);
		return mav;
	}

	@GetMapping("/borrarIngrediente")
	public ModelAndView borrarIngrediente(@RequestParam(name = "id", required = true) long id) {
		
		//Borrar Ingrediente
		Ingrediente i = ingredientesRepo.findById(id).orElse(null);
		ingredientesRepo.delete(i);

		
		//Ingrediente nuevo, para el formulario
		Ingrediente nuevo = new Ingrediente();
		nuevo.setReceta(i.getReceta());
		ModelAndView mav = new ModelAndView("formulario_ingredientes");
		mav.addObject("ingrediente", nuevo);
		mav.addObject("receta", nuevo.getReceta());
		return mav;
	}

}
