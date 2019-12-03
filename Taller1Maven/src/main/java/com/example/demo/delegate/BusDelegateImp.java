package com.example.demo.delegate;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.modelo.Tmio1Bus;

@Component
public class BusDelegateImp implements BusDelegate {
	RestTemplate template;
	final String SERVER = "http://localhost:8082/api/";
	//A traves del template me conecto al controlador 
	public BusDelegateImp() {
		template = new RestTemplate();
	}

	@Override
	public Iterable<Tmio1Bus> getBuses() {
		Tmio1Bus[] bus = template.getForObject(SERVER +"buses", Tmio1Bus[].class);
		List<Tmio1Bus> at;
		try {
			at = Arrays.asList(bus);
			return at;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Tmio1Bus addBus(Tmio1Bus newbus) {
		Tmio1Bus bus = template.postForEntity(SERVER + "buses", newbus, Tmio1Bus.class).getBody();
		return bus;
	}

	@Override
	public void delBus(Tmio1Bus bus) {
		template.delete(SERVER + "buses/" + bus.getId());

	}

	@Override
	public Tmio1Bus getBus(Integer i) {
		Tmio1Bus bus = template.getForObject(SERVER + "buses/" + i, Tmio1Bus.class);
		return bus;
	}

}
