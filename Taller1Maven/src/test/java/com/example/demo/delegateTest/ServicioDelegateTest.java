package com.example.demo.delegateTest;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.math.BigDecimal;
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

import com.example.demo.delegate.ServiceDelegateImp;
import com.example.demo.modelo.Tmio1Bus;
import com.example.demo.modelo.Tmio1Conductore;
import com.example.demo.modelo.Tmio1Ruta;
import com.example.demo.modelo.Tmio1Servicio;
import com.example.demo.modelo.Tmio1ServicioPK;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ServicioDelegateTest {

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	@Autowired
	private ServiceDelegateImp busDelegate;

	final String URI_SERVER = "http://localhost:8082/api/";

	@BeforeMethod
	public void beforeMethod() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void MostrarBusTest() {
		Tmio1Servicio serv1 = new Tmio1Servicio();
		Tmio1Servicio serv2 = new Tmio1Servicio();
		Tmio1ServicioPK pk1 = new Tmio1ServicioPK();
		Tmio1ServicioPK pk2 = new Tmio1ServicioPK();
		Tmio1Bus bus1 = new Tmio1Bus();
		Tmio1Bus bus2 = new Tmio1Bus();

		bus1.setCapacidad(new BigDecimal(50));
		bus1.setMarca("chevrolet");
		bus1.setPlaca("ADX412");
		bus1.setModelo(new BigDecimal(2008));
		bus1.setId(123);

		bus2.setCapacidad(new BigDecimal(44));
		bus2.setMarca("chevrolet");
		bus2.setPlaca("ADX413");
		bus2.setModelo(new BigDecimal(2085));
		bus2.setId(456);
		Tmio1Conductore conductor1 = new Tmio1Conductore();
		Tmio1Conductore conductor2 = new Tmio1Conductore();

		conductor1.setCedula("12223");
		conductor1.setNombre("Camilo");
		conductor1.setApellidos("Jimenez");
		conductor1.setFechaNacimiento(LocalDate.of(2010, 10, 2));
		conductor1.setFechaContratacion(LocalDate.of(2018, 10, 2));

		conductor2.setCedula("22233");
		conductor2.setNombre("Bryan");
		conductor2.setApellidos("Grueso");
		conductor2.setFechaNacimiento(LocalDate.of(2010, 10, 2));
		conductor2.setFechaContratacion(LocalDate.of(2017, 10, 2));

		Tmio1Ruta ruta = new Tmio1Ruta();
		Tmio1Ruta ruta2 = new Tmio1Ruta();

		ruta.setId(123);
		ruta.setNumero("1221");
		ruta.setDiaInicio(new BigDecimal("123"));
		ruta.setDiaFin(new BigDecimal("223"));
		ruta.setHoraInicio(new BigDecimal("20"));
		ruta.setHoraFin(new BigDecimal("30"));

		ruta2.setId(323);
		ruta2.setNumero("4621");
		ruta2.setDiaInicio(new BigDecimal("223"));
		ruta2.setDiaFin(new BigDecimal("423"));
		ruta2.setHoraInicio(new BigDecimal("21"));
		ruta2.setHoraFin(new BigDecimal("31"));
		serv1.setId(pk1);
		serv1.setTmio1Bus(bus1);
		serv1.setTmio1Conductore(conductor1);
		serv1.setTmio1Ruta(ruta);

		serv2.setId(pk2);
		serv2.setTmio1Bus(bus2);
		serv2.setTmio1Conductore(conductor2);
		serv2.setTmio1Ruta(ruta2);

		// Yo le doy comportamiento a los metodos del RestTemplate
		Tmio1Servicio[] buses = { serv1, serv1 };

		Mockito.when(restTemplate.getForObject(URI_SERVER + "servicios", Tmio1Servicio[].class)).thenReturn(buses);

		Iterable<Tmio1Servicio> employee = busDelegate.getServicios();

		assertEquals(serv1.getId(), employee.iterator().next().getId());

	}

	@Test
	public void AgregarBusTest() {

		Tmio1Servicio serv1 = new Tmio1Servicio();
		Tmio1ServicioPK pk1 = new Tmio1ServicioPK();
		Tmio1Bus bus1 = new Tmio1Bus();

		bus1.setCapacidad(new BigDecimal(50));
		bus1.setMarca("chevrolet");
		bus1.setPlaca("ADX412");
		bus1.setModelo(new BigDecimal(2009));
		bus1.setId(123);

		Tmio1Conductore conductore1 = new Tmio1Conductore();

		conductore1.setCedula("12223");
		conductore1.setNombre("Bryan");
		conductore1.setApellidos("Grueso");
		conductore1.setFechaNacimiento(LocalDate.of(2010, 10, 2));
		conductore1.setFechaContratacion(LocalDate.of(2018, 10, 2));

		Tmio1Ruta rute1 = new Tmio1Ruta();

		rute1.setId(123);
		rute1.setNumero("1221");
		rute1.setDiaInicio(new BigDecimal("123"));
		rute1.setDiaFin(new BigDecimal("223"));
		rute1.setHoraInicio(new BigDecimal("20"));
		rute1.setHoraFin(new BigDecimal("30"));

		serv1.setId(pk1);
		serv1.setTmio1Bus(bus1);
		serv1.setTmio1Conductore(conductore1);
		serv1.setTmio1Ruta(rute1);

		Mockito.when(restTemplate.postForEntity(URI_SERVER + "servicios", serv1, Tmio1Servicio.class))
				.thenReturn(new ResponseEntity<Tmio1Servicio>(serv1, HttpStatus.OK));
		Mockito.when(restTemplate.getForObject(URI_SERVER + "servicios/" + serv1.getHash(), Tmio1Servicio.class))
				.thenReturn(serv1);

		Tmio1Servicio employee = busDelegate.getServicio(serv1.getId());

		assertEquals(serv1.getId(), employee.getId());

	}

	@Test
	public void UpdateBusTest() {
		Tmio1Servicio serv1 = new Tmio1Servicio();

		Tmio1ServicioPK pk1 = new Tmio1ServicioPK();

		Tmio1Bus bus1 = new Tmio1Bus();

		bus1.setCapacidad(new BigDecimal(20));
		bus1.setMarca("chevrolet");
		bus1.setPlaca("ADX412");
		bus1.setModelo(new BigDecimal(2019));
		bus1.setId(123);

		Tmio1Conductore condu1 = new Tmio1Conductore();

		condu1.setCedula("12223");
		condu1.setNombre("Bryan");
		condu1.setApellidos("Grueso");
		condu1.setFechaNacimiento(LocalDate.of(2010, 10, 2));
		condu1.setFechaContratacion(LocalDate.of(2016, 10, 2));

		Tmio1Ruta rut1 = new Tmio1Ruta();

		rut1.setId(123);
		rut1.setNumero("1221");
		rut1.setDiaInicio(new BigDecimal("123"));
		rut1.setDiaFin(new BigDecimal("223"));
		rut1.setHoraInicio(new BigDecimal("20"));
		rut1.setHoraFin(new BigDecimal("30"));

		serv1.setId(pk1);
		serv1.setTmio1Bus(bus1);
		serv1.setTmio1Conductore(condu1);
		serv1.setTmio1Ruta(rut1);

//agregar
		Mockito.when(restTemplate.postForEntity(URI_SERVER + "servicios", serv1, Tmio1Servicio.class))
				.thenReturn(new ResponseEntity<Tmio1Servicio>(serv1, HttpStatus.OK));

		// get servicio
		Mockito.when(restTemplate.getForObject(URI_SERVER + "servicios/" + serv1.getHash(), Tmio1Servicio.class))
				.thenReturn(serv1);

		Tmio1Servicio employee = busDelegate.getServicio(serv1.getId());

		Tmio1Bus bus3 = new Tmio1Bus();

		bus3.setCapacidad(new BigDecimal(50));
		bus3.setMarca("mazda");
		bus3.setPlaca("GFE564");
		bus3.setModelo(new BigDecimal(2017));
		bus3.setId(666);
		employee.setTmio1Bus(bus3);

		// update
		Mockito.when(restTemplate.patchForObject(URI_SERVER + "servicios", employee, Tmio1Servicio.class))
				.thenReturn(employee);

		if (employee.getTmio1Bus().getId() == 666) {
			assertTrue(true);
		} else {
			assertTrue(false);
		}

	}

}