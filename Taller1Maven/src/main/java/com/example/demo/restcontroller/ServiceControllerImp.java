package com.example.demo.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.delegate.ServiceDelegate;
import com.example.demo.modelo.Tmio1Servicio;
import com.example.demo.modelo.Tmio1ServicioPK;

@RestController
public class ServiceControllerImp implements ServiceController {
	@Autowired
	private ServiceDelegate delegado;
	@Override
	public Iterable<Tmio1Servicio> getServicios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tmio1Servicio addServicio(Tmio1Servicio servicio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tmio1Servicio delServicio(Tmio1Servicio id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tmio1Servicio getServicio(Tmio1ServicioPK id) {
		// TODO Auto-generated method stub
		return null;
	}

}
