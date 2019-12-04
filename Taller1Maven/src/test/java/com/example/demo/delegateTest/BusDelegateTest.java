package com.example.demo.delegateTest;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mockitoSession;
import static org.testng.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import org.testng.annotations.BeforeMethod;

import com.example.demo.delegate.BusDelegateImp;
import com.example.demo.modelo.Tmio1Bus;



@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class BusDelegateTest {
	
	@Mock
	private RestTemplate restTemplate;
	

	@InjectMocks
	@Autowired
	private BusDelegateImp busDelegate;
	
	final String URI_SERVER = "http://localhost:8082/api/";
	
	@BeforeMethod
	public void beforeMethod() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void MostrarBusTest() {
		Tmio1Bus bus1 = new Tmio1Bus();
		Tmio1Bus bus2 = new Tmio1Bus();
		
		bus1.setCapacidad(new BigDecimal(15));
		bus1.setMarca("chevrolet");
		bus1.setPlaca("ADX412");
		bus1.setModelo(new BigDecimal(2008));
		bus1.setId(123);
		
		bus2.setCapacidad(new BigDecimal(50));
		bus2.setMarca("chevrolet");
		bus2.setPlaca("ADX413");
		bus2.setModelo(new BigDecimal(2015));
		bus2.setId(456);
		//Yo le doy comportamiento a los metodos del RestTemplate
		Tmio1Bus[] buses = {bus1, bus2};
		
	Mockito
    .when(restTemplate.getForObject(
    		URI_SERVER + "buses",Tmio1Bus[].class))
    .thenReturn(buses);

	Iterable<Tmio1Bus> employee = busDelegate.getBuses();
    
	assertEquals(bus1.getId(), employee.iterator().next().getId());

	}
	
	@Test
	public void AgregarBusTest() {
		
		Tmio1Bus bus1 = new Tmio1Bus();		
		bus1.setCapacidad(new BigDecimal(60));
		bus1.setMarca("chevrolet");
		bus1.setPlaca("ADX412");
		bus1.setModelo(new BigDecimal(2018));
		bus1.setId(123);	

		Mockito.when(restTemplate.postForEntity(URI_SERVER + "buses", bus1, Tmio1Bus.class)).thenReturn(new ResponseEntity<Tmio1Bus>(bus1, HttpStatus.OK));
	Mockito.when( restTemplate.getForObject(URI_SERVER + "buses/" + bus1.getId(), Tmio1Bus.class)).thenReturn(bus1);

	Tmio1Bus employee = busDelegate.getBus(bus1.getId());
    
	assertEquals(bus1.getId(), employee.getId());

	}
	
	
}