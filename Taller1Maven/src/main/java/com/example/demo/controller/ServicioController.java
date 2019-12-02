package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.ServicioApp;
import com.example.demo.modelo.Tmio1Bus;
import com.example.demo.modelo.Tmio1Servicio;
import com.example.demo.modelo.Tmio1ServicioPK;
import com.example.demo.service.Tmio1RutaService;
//import com.example.demo.service.Tmio1ServicioPKService;
//import com.example.demo.service.Tmio1ServicioPKService;
import com.example.demo.service.Tmio1ServicioService;
@Controller
public class ServicioController {
	
	Tmio1ServicioService servicio;
	Tmio1RutaService serv;
//	@Autowired
//	Tmio1ServicioPKService servic;
	@Autowired
	public ServicioController(Tmio1ServicioService service, Tmio1RutaService se) {
		servicio=service;
		serv=se;
//		servic=se;
	}
	
	@GetMapping("/servicios/")
	public String indexServicio(Model modelo) {
		modelo.addAttribute("tmio1Servicio", servicio.findAll());
		return "servicios/indexServicios";
	}
	@GetMapping("/servicios/add")
	public String addServicios(Model model) {
		model.addAttribute("tmio1ServicioPK",new Tmio1ServicioPK());
		return "servicios/servicioPk";
	}
	@PostMapping("/servicios/add")
	public String saveSercicios(@RequestParam(value = "action", required = true) String action, @Valid Tmio1ServicioPK serv,
	BindingResult bindingResult, Model model) throws Exception {
		if(!action.equals("Cancel"))
			if(bindingResult.hasErrors()) {
				return "servicios/addServicios";
			}else {
				Tmio1ServicioPK pk=serv;
				Tmio1Servicio aqui=new Tmio1Servicio();
//				aqui.set
				System.out.println("Agrego");
			}
		
		return "redirect:/servicios/";
	}
	@GetMapping("/editar/")
	public String devolver() {
		return "servicios/editServicios";
	}
	@GetMapping("/consultar/")
	public String a(Model model) {
		model.addAttribute("servicioApp", new ServicioApp());
		return "servicios/searchServicios";
	}
	
}
