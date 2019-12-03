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

import com.example.demo.delegate.BusDelegate;
import com.example.demo.delegate.ConductoreDelegate;
import com.example.demo.delegate.RutaDelegate;
import com.example.demo.delegate.ServiceDelegate;
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

	Tmio1RutaService serv;
	ServiceDelegate delegado;
	ConductoreDelegate conductor;
	BusDelegate bus;
	RutaDelegate ruta;
	
	@Autowired
	public ServicioController(ServiceDelegate service,ConductoreDelegate conductor,
			BusDelegate bus, RutaDelegate ruta) {
		delegado = service;
		this.conductor=conductor;
		this.bus=bus;
		this.ruta=ruta;
//		servic=se;
	}

	@GetMapping("/servicios/")
	public String indexServicio(Model modelo) {
		modelo.addAttribute("tmio1Servicio", delegado.getServicios());
		return "servicios/indexServicios";
	}

	@GetMapping("/servicios/add")
	public String addServicios(Model model) {
		model.addAttribute("tmio1ServicioPK", new Tmio1ServicioPK());
		model.addAttribute("tmio1Conductore", conductor.getConductores());
		model.addAttribute("tmio1Bus",bus.getBuses());
		model.addAttribute("tmio1Ruta",ruta.getRutas());
		return "servicios/servicioPk";
	}

	@PostMapping("/servicios/add")
	public String saveSercicios(@Valid @ModelAttribute Tmio1ServicioPK servicioPK, BindingResult bindingResult,
			@RequestParam(value = "action", required = true) String action, Model modelo) throws Exception {
		if (!action.equals("Cancel")) {
			if (bindingResult.hasErrors()) {
				modelo.addAttribute("conductores", conductor.getConductores());
				modelo.addAttribute("buses", bus.getBuses());
				modelo.addAttribute("rutas", ruta.getRutas());
				return "servicios/add-servicio";
			} else {
				Tmio1Servicio ser = new Tmio1Servicio();
				ser.setId(servicioPK);
				ser.setTmio1Conductore(conductor.getConductore(servicioPK.getCedulaConductor()));
				ser.setTmio1Bus(bus.getBus(servicioPK.getIdBus()));
				ser.setTmio1Ruta(ruta.getRuta(servicioPK.getIdRuta()));
				ser.setHash(ser.getId().hashCode());
				delegado.addServicio(ser);
			}
		}
		
		return "redirect:/servicios/";
	}

	@GetMapping("/servicios/editar/{hash}")
	public String devolver(@PathVariable("hash") Integer id, Model modelo) {
		Iterable<Tmio1Servicio> servicios=delegado.getServicios();
		Tmio1Servicio servicio=null;
		for(Tmio1Servicio ser : servicios) {
			if(ser.getHash().compareTo(id) == 0) {
				delegado.delServicio(ser);
				servicio = ser;
				break;
			}
		}
		
		if (servicio == null)
			throw new IllegalArgumentException("Invalid service Id:" + id);
		modelo.addAttribute("tmio1Bus", bus.getBuses());
		modelo.addAttribute("tmio1Conductore", conductor.getConductores());
		modelo.addAttribute("tmio1Ruta", ruta.getRutas());
		modelo.addAttribute("tmio1Servicio", servicio);
		return "servicios/editServicios";
	}
	

	@GetMapping("/consultar/")
	public String a(Model model) {
		model.addAttribute("servicioApp", new ServicioApp());
		return "servicios/searchServicios";
	}

}
