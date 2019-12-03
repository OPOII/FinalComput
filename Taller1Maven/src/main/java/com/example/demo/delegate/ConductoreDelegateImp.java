package com.example.demo.delegate;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.modelo.Tmio1Conductore;

@Component
public class ConductoreDelegateImp extends GenericTemplate implements ConductoreDelegate {

	public ConductoreDelegateImp() {
		super();
	}
//cambiar todo por /api/nombredelcoso/
	@Override
	public Iterable<Tmio1Conductore> getConductores() {
		Tmio1Conductore[] conductores = restTemplate.getForObject(SERVER + "conductores", Tmio1Conductore[].class);
		List<Tmio1Conductore> at;
		try {
			at = Arrays.asList(conductores);
			return at;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Tmio1Conductore addConductor(Tmio1Conductore newconductor) {
		Tmio1Conductore conductor = restTemplate.postForEntity(SERVER + "conductores", newconductor, Tmio1Conductore.class)
				.getBody();
		return conductor;
	}

	@Override
	public void delConductore(Tmio1Conductore conductor) {
		restTemplate.delete(SERVER + "conductores/" + conductor.getCedula());
	}

	@Override
	public Tmio1Conductore getConductore(String cedula) {
		Tmio1Conductore conductor = restTemplate.getForObject(SERVER + "conductores/" + cedula, Tmio1Conductore.class);
		return conductor;
	}

}
