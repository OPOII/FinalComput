package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Tmio1Sitio;
import com.example.demo.service.Tmio1SitioService;
@Controller
public class SitioController {

	Tmio1Sitio sitio;
	Tmio1SitioService servicio;
	@Autowired
	public SitioController(Tmio1SitioService servi) {
		servicio=servi;
	}
	
	@GetMapping("/sitios/")
	public String indexSitios(Model model) {
		 model.addAttribute("tmio1Sitio",servicio.findAll());
		return "sitios/indexSitios";
	}
	@GetMapping("/sitios/add")
	public String addSitio(Model model) {
		model.addAttribute("tmio1Sitio",new Tmio1Sitio());
		return "sitios/addSitios";
	}
	
	@PostMapping("/sitios/add")
	public String saveBus(@RequestParam(value = "action", required = true) String action, @Valid Tmio1Sitio sitio,
	BindingResult bindingResult, Model model){
		if (!action.equals("Cancel"))
			if (bindingResult.hasErrors()) {
				return "sitios/addSitios";
			} else {
				servicio.agregar(sitio);
			}
		return "redirect:/sitios/";
	}
	@PostMapping("/sitios/eliminate")
	public String deleteSitio(@RequestParam(value = "action", required = true) String action, @Valid Long sitio,
	BindingResult bindingResult, Model model) {
		if (!action.equals("Cancel"))
			if (bindingResult.hasErrors()) {
				return "sitios/addSitios";
			} else {
				servicio.eliminar(sitio);
			}
		return "redirect:/sitios/";
	}
}
