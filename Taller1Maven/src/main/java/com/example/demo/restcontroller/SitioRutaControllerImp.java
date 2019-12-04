package com.example.demo.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Tmio1SitiosRuta;
import com.example.demo.service.InterfazSitioRuta;
@RestController
public class SitioRutaControllerImp implements SitioRutaController {
	
	@Autowired
	private  InterfazSitioRuta service;
	@Override
	public Tmio1SitiosRuta getSitioRuta(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Tmio1SitiosRuta> getSitiosRutas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tmio1SitiosRuta addSitioRuta(Tmio1SitiosRuta sitioruta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tmio1SitiosRuta delSitioRuta(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
