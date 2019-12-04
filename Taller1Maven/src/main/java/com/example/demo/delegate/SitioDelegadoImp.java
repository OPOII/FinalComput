package com.example.demo.delegate;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.modelo.Tmio1Sitio;

@Component
public class SitioDelegadoImp extends GenericTemplate implements SitioDelegate {
	public SitioDelegadoImp() {
		super();
	}

	@Override
	public Iterable<Tmio1Sitio> getSitios() {
		Tmio1Sitio[] sitio = restTemplate.getForObject(SERVER + "sitios", Tmio1Sitio[].class);
		List<Tmio1Sitio> at;
		try {
			at = Arrays.asList(sitio);
			return at;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Tmio1Sitio addSitio(Tmio1Sitio sitio) {
		Tmio1Sitio ruta = restTemplate.postForEntity(SERVER + "sitios", sitio, Tmio1Sitio.class).getBody();
		return ruta;
	}

	@Override
	public void delSitio(Tmio1Sitio sitio) {
		restTemplate.delete(SERVER + "sitios/" + sitio.getId());

	}

	@Override
	public Tmio1Sitio getSitio(long id) {
		Tmio1Sitio ruta = restTemplate.getForObject(SERVER + "sitios/" + id, Tmio1Sitio.class);
		return ruta;
	}

}
