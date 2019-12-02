package com.example.demo.restcontroller;

import com.example.demo.modelo.Tmio1Servicio;
import com.example.demo.modelo.Tmio1ServicioPK;

public interface ServiceController {

	public Iterable<Tmio1Servicio> getServicios();
	
	public Tmio1Servicio addServicio(Tmio1Servicio servicio);
	
	public Tmio1Servicio delServicio(Tmio1Servicio id);
	
	public Tmio1Servicio getServicio(Tmio1ServicioPK id);
}
