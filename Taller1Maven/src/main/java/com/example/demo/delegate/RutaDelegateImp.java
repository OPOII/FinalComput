package com.example.demo.delegate;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.modelo.Tmio1Ruta;

@Component
public class RutaDelegateImp implements RutaDelegate {
	RestTemplate template;
	final String SERVER = "http://localhost:8082/";

	public RutaDelegateImp() {
		template = new RestTemplate();
	}

	@Override
	public Iterable<Tmio1Ruta> getRutas() {
		Tmio1Ruta[] ruta = template.getForObject(SERVER + "/api/rutas/", Tmio1Ruta[].class);
		List<Tmio1Ruta> at;
		try {
			at = Arrays.asList(ruta);
			return at;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Tmio1Ruta addRuta(Tmio1Ruta newbus) {
		Tmio1Ruta ruta = template.postForEntity(SERVER + "/api/rutas/", newbus, Tmio1Ruta.class).getBody();
		return ruta;
	}

	@Override
	public void delRuta(Tmio1Ruta bus) {
		template.delete(SERVER + "/api/rutas/" + bus.getId());
	}

	@Override
	public Tmio1Ruta getRuta(Integer i) {
		Tmio1Ruta ruta = template.getForObject(SERVER + "/api/rutas/" + i, Tmio1Ruta.class);
		return ruta;
	}

}
