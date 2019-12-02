package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.BusApp;
import com.example.demo.model.RutaApp;
import com.example.demo.modelo.Tmio1Bus;
import com.example.demo.modelo.Tmio1Conductore;
import com.example.demo.modelo.Tmio1Ruta;
import com.example.demo.service.Tmio1RutaService;

@Controller
public class RutasController {

	Tmio1RutaService servicio;
	Tmio1Ruta universal;
	@Autowired
	public RutasController(Tmio1RutaService service) {
		servicio = service;
	}

	@GetMapping("/rutas/")
	public String indexRutas(Model modelo) {
		modelo.addAttribute("tmio1Ruta", servicio.findAll());
		return "/rutas/indexRutas";
	}

	@GetMapping("/rutas/add")
	public String addRutas(Model modelo) {
		modelo.addAttribute("tmio1Ruta", new Tmio1Ruta());
		return "rutas/addRutas";
	}

	@PostMapping("/rutas/add")
	public String saveRutas(@RequestParam(value = "action", required = true) String action, @Valid Tmio1Ruta ruta,
			BindingResult bindingResult, Model model) throws Exception {
		if (!action.equals("Cancel"))
			if (bindingResult.hasErrors()) {
				return "rutas/addRutas";
			} else {
				servicio.agregar(ruta);
			}
		return "redirect:/rutas/";
	}

	@GetMapping("/search/buscarRuta")
	public String searchBuses(Model model) {
		model.addAttribute("rutaApp", new RutaApp());
		return "rutas/searchRutas";
	}

	@PostMapping("/search/buscarRuta")
	public String obtenerInfo(@RequestParam(value = "action", required = true) String action, @Valid RutaApp bus,
			BindingResult bindingResult, Model model) throws Exception {
		if (!action.equals("Cancel"))
			if (bindingResult.hasErrors()) {
				return "rutas/searchRutas";
			} else {
				Tmio1Ruta bur = servicio.buscar(bus.getId());
				if (bur != null) {
					universal = bur;
					System.out.println("Si hay Ruta");
				}
			}
		return "rutas/searchRutas";
	}

	@GetMapping("/rutas/search/mostrarResultados")
	public String mostrar(Model model) {
		model.addAttribute("tmio1Ruta", universal);
		return "rutas/showResults";
	}

}
