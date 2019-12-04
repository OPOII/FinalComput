package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.delegate.RutaDelegate;
import com.example.demo.delegate.SitioDelegate;
import com.example.demo.modelo.Tmio1Sitio;
import com.example.demo.modelo.Tmio1SitiosRuta;

@Controller
public class SitioRutaController {

	SitioDelegate sitioDelegado;
	RutaDelegate rutaDelegado;
	SitioDelegate delegado;

	@Autowired
	public SitioRutaController(SitioDelegate dele, RutaDelegate ruta, SitioDelegate del) {
		sitioDelegado = dele;
		rutaDelegado = ruta;
		delegado = del;
	}

	@GetMapping("/sitiosrutas")
	public String indexSitiosRutas(Model modelo) {
		modelo.addAttribute("sitiosrutas", delegado.getSitios());
		return "sitiosrutas/indexSitios";
	}

	@GetMapping("/sitiosrutas/add")
	public String addSitiosRutas(Model model) {
		model.addAttribute("sitioruta", new Tmio1SitiosRuta());
		model.addAttribute("sitios", sitioDelegado.getSitios());
		model.addAttribute("rutas", rutaDelegado.getRutas());
		return "sitios/addSitiosRutas";
	}

	@PostMapping("/sitiosrutas/add")
	public String saveSitiosRuta(@Valid @ModelAttribute Tmio1SitiosRuta sitio, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action, Model modelo) {
		if (!action.equals("Cancel")) {
			modelo.addAttribute("sitioruta", new Tmio1SitiosRuta());
			modelo.addAttribute("sitios", sitioDelegado.getSitios());
			modelo.addAttribute("rutas", rutaDelegado.getRutas());
			if (bindingResult.hasErrors()) {
				return "sitiosrutas/add-sitioruta";
			} else {
				// rutaService.addRuta(tmio1Ruta);
			}

		}
		return "redirect:/sitios/";
	}
	@GetMapping("/sitiosrutas/eliminate/{hash}")
	public String delSitio(@PathVariable("hash")Integer id) {
		return null;
	}
}
