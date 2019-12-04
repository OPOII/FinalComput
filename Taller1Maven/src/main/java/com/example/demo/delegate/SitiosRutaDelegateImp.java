package com.example.demo.delegate;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.modelo.Tmio1SitiosRuta;
import com.example.demo.modelo.Tmio1SitiosRutaPK;

@Component
public class SitiosRutaDelegateImp extends GenericTemplate implements SitioRutaDelegate {
	public SitiosRutaDelegateImp() {
		
	}

	@Override
	public Iterable<Tmio1SitiosRuta> getRutas() {
		Tmio1SitiosRuta[] rutas=restTemplate.getForObject(SERVER+"sitiosrutas", Tmio1SitiosRuta[].class);
		List<Tmio1SitiosRuta>at;
		try {
			at=Arrays.asList(rutas);
			return at;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Tmio1SitiosRuta addRuta(Tmio1SitiosRuta newSitios) {
		Tmio1SitiosRuta ruta=restTemplate.postForEntity(SERVER+"sitiosrutas", newSitios, Tmio1SitiosRuta.class).getBody();
		return ruta;
	}

	@Override
	public void delRuta(Tmio1SitiosRuta sitio) {
		restTemplate.delete(SERVER+"rutas/"+sitio.getHash());
		
	}

	@Override
	public Tmio1SitiosRuta getSitiosRuta(Tmio1SitiosRutaPK id) {
		Tmio1SitiosRuta rut=restTemplate.getForObject(SERVER+"rutassitios/"+id, Tmio1SitiosRuta.class);
		return null;
	}
	
}
