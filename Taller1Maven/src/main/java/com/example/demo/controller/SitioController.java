package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/sitios")
	public String indexSitios(Model model) {
		 model.addAttribute("tmio1Sitio",servicio.findAll());
		return "sitios/indexSitios";
	}
	@GetMapping("/sitios/add")
	public String addSitio(Model model) {
		model.addAttribute("tmio1Sitio",new Tmio1Sitio());
		return "sitios/addSitios";
	}
}
