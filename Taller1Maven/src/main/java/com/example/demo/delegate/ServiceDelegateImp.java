package com.example.demo.delegate;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.modelo.Tmio1Servicio;
import com.example.demo.modelo.Tmio1ServicioPK;

@Component
public class ServiceDelegateImp extends GenericTemplate implements ServiceDelegate {

	public ServiceDelegateImp() {
		super();
	}

	@Override
	public Iterable<Tmio1Servicio> getServicios() {
		Tmio1Servicio[] servicio=restTemplate.getForObject(SERVER+"/api/servicios/", Tmio1Servicio[].class);
		List<Tmio1Servicio> at;
		try {
			at=Arrays.asList(servicio);
			return at;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Tmio1Servicio addServicio(Tmio1Servicio newbus) {
		Tmio1Servicio serv=restTemplate.postForEntity(SERVER+"/api/servicios/", newbus, Tmio1Servicio.class).getBody();
		return serv;
	}

	@Override
	public void delServicio(Tmio1Servicio bus) {
		restTemplate.delete(SERVER + "/api/servicios/"+bus.getId());
		
	}

	@Override
	public Tmio1Servicio getServicio(Tmio1ServicioPK i) {
		Tmio1Servicio car = restTemplate.getForObject(SERVER + "/api/servicios/" + i, Tmio1Servicio.class);
		return car;
	}
}
