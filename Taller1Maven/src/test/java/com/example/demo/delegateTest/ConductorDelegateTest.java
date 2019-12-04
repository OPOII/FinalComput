package com.example.demo.delegateTest;

import static org.testng.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Date;

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

import com.example.demo.delegate.ConductoreDelegateImp;
import com.example.demo.modelo.Tmio1Conductore;



@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ConductorDelegateTest {

	@Mock
	private RestTemplate restTemplate;
	

	@InjectMocks
	@Autowired
	private ConductoreDelegateImp busDelegate;
	
	final String URI_SERVER = "http://localhost:8082/api/";
	
	@BeforeMethod
	public void beforeMethod() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void MostrarBusTest() {
		Tmio1Conductore bus1 = new Tmio1Conductore();
		Tmio1Conductore bus2 = new Tmio1Conductore();
		
		bus1.setCedula("12223");
		bus1.setNombre("Camilo");
		bus1.setApellidos("Jimenez");
		bus1.setFechaNacimiento(LocalDate.of(2010, 10, 2));
		bus1.setFechaContratacion(LocalDate.of(2015, 10, 2));

		bus1.setCedula("22233");
		bus1.setNombre("Bryan");
		bus1.setApellidos("Grueso");
		bus1.setFechaNacimiento(LocalDate.of(2010, 10, 2));
		bus1.setFechaContratacion(LocalDate.of(2016, 10, 2));
		//Yo le doy comportamiento a los metodos del RestTemplate
		Tmio1Conductore[] buses = {bus1, bus2};
		
	Mockito
    .when(restTemplate.getForObject(
    		URI_SERVER + "conductores",Tmio1Conductore[].class))
    .thenReturn(buses);

	Iterable<Tmio1Conductore> employee = busDelegate.getConductores();
    
	assertEquals(bus1.getCedula(), employee.iterator().next().getCedula());

	}
	
	@Test
	public void AgregarBusTest() {
		
		Tmio1Conductore bus1 = new Tmio1Conductore();
	
		
		bus1.setCedula("21221");
		bus1.setNombre("Bryan");
		bus1.setApellidos("Grueso");
		bus1.setFechaNacimiento(LocalDate.of(2012, 10, 2));
		bus1.setFechaContratacion(LocalDate.of(2010, 10, 2));

		Mockito.when(restTemplate.postForEntity(URI_SERVER + "conductores", bus1, Tmio1Conductore.class)).thenReturn(new ResponseEntity<Tmio1Conductore>(bus1, HttpStatus.OK));
	Mockito.when( restTemplate.getForObject(URI_SERVER + "conductores/" + bus1.getCedula(), Tmio1Conductore.class)).thenReturn(bus1);

	Tmio1Conductore employee = busDelegate.getConductore(bus1.getCedula());
    
	assertEquals(bus1.getCedula(), employee.getCedula());

	}
	
}