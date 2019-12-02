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
		return delegado.getServicios();
	}

	@Override
	public Tmio1Servicio addServicio(Tmio1Servicio servicio) {
		return delegado.addServicio(servicio);
	}

	@Override
	public Tmio1Servicio delServicio(Tmio1ServicioPK id) {
		Tmio1Servicio service=delegado.getServicio(id);
		return null;
	}

	@Override
	public Tmio1Servicio getServicio(Tmio1ServicioPK id) {
		// TODO Auto-generated method stub
		return null;
	}

}
