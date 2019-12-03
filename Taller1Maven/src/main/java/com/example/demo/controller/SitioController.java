package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.delegate.SitioDelegate;
import com.example.demo.modelo.Tmio1Bus;
import com.example.demo.modelo.Tmio1Sitio;
import com.example.demo.service.Tmio1SitioService;
import com.example.demo.validation.Update;
import com.example.demo.validation.ValideEdit;
@Controller
public class SitioController {

	Tmio1Sitio sitio;
	SitioDelegate delegado;
	@Autowired
	public SitioController(SitioDelegate servi) {
		delegado = servi;
	}

	@GetMapping("/sitios/")
	public String indexSitios(Model model) {
		model.addAttribute("tmio1Sitio", delegado.getSitios());
		return "sitios/indexSitios";
	}

	@GetMapping("/sitios/add")
	public String addSitio(Model model) {
		model.addAttribute("tmio1Sitio", new Tmio1Sitio());
		return "sitios/addSitios";
	}

	@PostMapping("/sitios/add")
	public String saveSitio(@Valid @ModelAttribute Tmio1Sitio sitio, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action, Model modelo) {
		if (!action.equals("Cancel"))
			if (bindingResult.hasErrors()) {
				return "sitios/addSitios";
			} else {
				delegado.addSitio(sitio);
			}
		return "redirect:/sitios/";
	}

	@GetMapping("/sitios/eliminate/{id}")
	public String delSitio(@PathVariable("id") long id) {
		try {
			Tmio1Sitio sitio = delegado.getSitio(id);
			delegado.delSitio(sitio);
			return "redirect:/sitios/";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/sitios/";
		}

	}

	@GetMapping("/sitios/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Tmio1Sitio sitio = delegado.getSitio(id);
		model.addAttribute("tmio1Sitio", sitio);
		return "/sitios/editSitios";
	}
	@PostMapping("/sitios/edit/{id}")
	public String editarSitio(@PathVariable("id") long id,
			@RequestParam(value = "action", required = true)String action,@Validated(ValideEdit.class) Tmio1Sitio sitio, BindingResult result,Model model ) {
			Tmio1Sitio old=delegado.getSitio(id);
			sitio.setId(old.getId());
			delegado.addSitio(sitio);
		return "redirect:/sitios/";
	}
	//	@PostMapping("/sitios/eliminate/{id}")
//	public String deleteSitio(@RequestParam(value = "action", required = true) String action, @Valid Tmio1Sitio sitio,
//	BindingResult bindingResult, Model model) {
//		if (!action.equals("Cancel"))
//			if (bindingResult.hasErrors()) {
//				return "sitios/addSitios";
//			} else {
//				servicio.eliminar(sitio.getId());
//			}
//		return "redirect:/sitios/";
//	}
}
