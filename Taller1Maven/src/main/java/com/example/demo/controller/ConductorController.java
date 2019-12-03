package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.delegate.ConductoreDelegate;
import com.example.demo.model.BusApp;
import com.example.demo.model.ConductoreApp;
import com.example.demo.modelo.Tmio1Bus;
import com.example.demo.modelo.Tmio1Conductore;
import com.example.demo.service.Tmio1ConductoreService;

@Controller
public class ConductorController {

//	Tmio1ConductoreService servicio;
	Tmio1Conductore universal;
	ConductoreDelegate delegado;
	@Autowired
	public ConductorController(ConductoreDelegate service) {
		delegado = service;
	}

	@GetMapping("/conductores/")
	public String indexConductores(Model model) {
		model.addAttribute("tmio1Conductore", delegado.getConductores());
		return "conductores/indexConductores";
	}

	@GetMapping("/conductores/add")
	public String addBus(Model model) {
		model.addAttribute("tmio1Conductore", new Tmio1Conductore());
		return "conductores/addConductores";
	}

	@PostMapping("/conductores/add")
	public String saveConductor(@Valid @ModelAttribute Tmio1Conductore conductore, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action, Model modelo) throws Exception {
		if(!action.equals("Cancel"))
			if(bindingResult.hasErrors()) {
				return "conductores/addConductores";
			}else {
				delegado.addConductor(conductore);
			}
		return "redirect:/conductores/";
	}
//	@GetMapping("/search/")
//	public String lobbySearchConductor(Model model) {
//		model.addAttribute("tmio1Conductore", servicio.findAll());
//		return "searchIndex";
//	}

	@GetMapping("/search/buscarConductor")
	public String searchBuses(Model model) {
		model.addAttribute("conductoreApp", new ConductoreApp());
		return "conductores/searchConductores"; //devuelve el html
	}
//
	@PostMapping("/search/buscarConductor")
	public String obtenerInfo(@RequestParam(value = "action", required = true) String action, @Valid ConductoreApp conductor,
			BindingResult bindingResult, Model model) throws Exception {
		if (!action.equals("Cancel"))
			if (bindingResult.hasErrors()) {
				return "conductores/searchConductores";
			} else {
				Tmio1Conductore bur = delegado.getConductore(conductor.getCedula());
				if (bur != null) {
					universal=bur;
					System.out.println("Si hay conductor");
				}
			}
			return "conductores/searchConductores";
	}
	@GetMapping("/conductores/search/mostrarResultados")
	public String mostrar(Model model) {
		model.addAttribute("tmio1Conductore",universal);
		return "conductores/showResults";
	}


}
