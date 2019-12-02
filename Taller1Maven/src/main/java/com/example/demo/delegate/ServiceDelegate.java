package com.example.demo.delegate;

import com.example.demo.modelo.Tmio1Servicio;
import com.example.demo.modelo.Tmio1ServicioPK;

public interface ServiceDelegate {

public Iterable<Tmio1Servicio> getServicios();
	
	public Tmio1Servicio addServicio(Tmio1Servicio newbus);
	
	public void delServicio(Tmio1Servicio bus);
	
	public Tmio1Servicio getServicio(Tmio1ServicioPK i);
}
