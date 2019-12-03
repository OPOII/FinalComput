package com.example.demo.controller;

import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.delegate.BusDelegate;
import com.example.demo.model.BusApp;
import com.example.demo.model.UserApp;
import com.example.demo.modelo.Tmio1Bus;
import com.example.demo.service.Tmio1BusService;
import com.example.demo.validation.Step2;

import com.example.demo.validation.Update;

//@RequestMapping("/buses")
@Controller
public class BusController {

//	Tmio1BusService servicio;
	Tmio1Bus universal;
	//Delegado hace un llamado al rest template, y el rest template llama al rest controller
	@Autowired
	private BusDelegate delegado;
	//Corregir todo esto, ya que aqui se usa el delegado
	
	@Autowired
	public BusController(BusDelegate servi) {
		delegado = servi;
	}
	
	@GetMapping("/buses/")
	public String indexBuses(Model model) {
		model.addAttribute("tmio1Bus", delegado.getBuses());
		return "buses/indexBuses";
	}
	@GetMapping("/buses/add")
	public String addBus(Model model) {
		model.addAttribute("tmio1Bus", new Tmio1Bus());
		return "buses/addBuses";
	}
	@PostMapping("/buses/add")
	public String saveBus(@Valid @ModelAttribute Tmio1Bus bus, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action, Model modelo) {
		if (!action.equals("Cancel"))
			if (bindingResult.hasErrors()) {
				return "buses/addBuses";
			} else {
				delegado.addBus(bus);
				System.out.println(bus.getMarca());
			}
		return "redirect:/buses/";
	}

	@GetMapping("/search/")
	public String lobbySearch(Model model) {
		model.addAttribute("tmio1Bus", delegado.getBuses());
		return "searchIndex";
	}

	@GetMapping("/search/buscarBus")
	public String searchBuses(Model model) {
		model.addAttribute("busApp", new BusApp());
		return "buses/searchBus";
	}

	@PostMapping("/search/buscarBus")
	public String obtenerInfo(@RequestParam(value = "action", required = true) String action, @Valid BusApp bus,
			BindingResult bindingResult, Model model) throws Exception {
		if (!action.equals("Cancel"))
			if (bindingResult.hasErrors()) {
				return "buses/searchBus";
			} else {
				Tmio1Bus bur = delegado.getBus(bus.getId());
				if (bur != null) {
					universal=bur;
					System.out.println("Si hay bus");
				}
			}
			return "buses/searchBus";
	}
	@GetMapping("/buses/search/mostrarResultados")
	public String mostrar(Model model) {
		model.addAttribute("tmio1Bus",universal);
		return "buses/showResults";
	}

//	@GetMapping("/buses/edit/{id}")
//	public String showUpdateForm(@PathVariable("id") Integer id, Model model) throws Exception {
//		Tmio1Bus bus = servicio.buscar(id);
//		if (bus == null)
//			throw new IllegalArgumentException("Invalid user id: " + id);
//		model.addAttribute("tmio1Bus", bus);
//		return "buses/editBuses";
//	}
//
//	@PostMapping("/buses/edit/{id}")
//	public String updateBus(@PathVariable("id") Integer id,
//			@RequestParam(value = "action", required = true) String action, @Validated(Update.class) Tmio1Bus bus,
//			BindingResult bindingResult, Model model) throws Exception {
//		if (action != null && !action.equals("Cancel")) {
//			if (bindingResult.hasErrors()) {
//				System.out.println("tiene errores");
//				return "buses/editBuses";
//			}else {
//				System.out.println("Entro");
//				servicio.modificar(bus);
//			}
//		} 
//
//		return "redirect:/buses/";
//	}
}
