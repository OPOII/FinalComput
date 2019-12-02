package com.example.demo.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.ThymeleafValidationApplication;
import com.example.demo.dao.ITBusesDao;
import com.example.demo.dao.RutasDao;
import com.example.demo.dao.ServiciosDao;
import com.example.demo.dao.BusesDao;
import com.example.demo.dao.ConductoreDao;
import com.example.demo.modelo.Tmio1Bus;
import com.example.demo.modelo.Tmio1Conductore;
import com.example.demo.modelo.Tmio1Ruta;
import com.example.demo.modelo.Tmio1Servicio;
import com.example.demo.modelo.Tmio1ServicioPK;

@SpringBootTest(classes = ThymeleafValidationApplication.class)
@RunWith(SpringRunner.class)
@Rollback(false)
public class TestConductoresDao {
	@Autowired
	private ConductoreDao conductorDao;
	@Autowired
	private BusesDao busDao;
	@Autowired
	private ServiciosDao servicioDao;
	@Autowired
	private RutasDao rutaDao;
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void SaveConductor() {
		assertNotNull(conductorDao);
		Tmio1Conductore conductor = new Tmio1Conductore();
		conductor.setCedula("6565461616");
		conductor.setApellidos("Chacon");
		conductor.setNombre("Andrea");
		conductor.setFechaContratacion(LocalDate.of(2010, 10, 2));
		conductor.setFechaNacimiento(LocalDate.of(1998, 9, 15));
		conductorDao.save(conductor);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void SearchByNombre() {
//		SaveConductor();
		assertNotNull(conductorDao);
		assertEquals("Andrea", conductorDao.findByNombre("Andrea").get(0).getNombre());
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void SearchByApellido() {
//		SaveConductor();
		assertNotNull(conductorDao);
		assertEquals("Andrea", conductorDao.findByApellidos("Chacon").get(0).getNombre());
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void SearchByCedula() {
//		SaveConductor();
		assertNotNull(conductorDao);
		assertEquals("6565461616", conductorDao.findByCedula("6565461616").get(0).getCedula());
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void punto2a() {
		assertNotNull(conductorDao);
		Tmio1ServicioPK pk = new Tmio1ServicioPK();
		Tmio1Servicio servicio = new Tmio1Servicio();
		Tmio1Conductore conductor = new Tmio1Conductore();
		conductor.setCedula("133414141");
		conductor.setNombre("Angela");
		conductor.setApellidos("Marruecos");
		conductorDao.save(conductor);
		Tmio1Ruta ruta = new Tmio1Ruta();
		Tmio1Bus bus = new Tmio1Bus();
		ruta.setActiva("Activa");
		ruta.setDescripcion("Ruta que pasa por todo el centro");
		ruta.setDiaFin(new BigDecimal(6));
		ruta.setDiaInicio(new BigDecimal(2));
		
		ruta.setHoraInicio(new BigDecimal(8));
		ruta.setHoraFin(new BigDecimal(21));
		ruta.setNumero("E41");
		rutaDao.save(ruta);
		bus.setPlaca("VCX 449");
		BigDecimal capacidad=new BigDecimal("20");
		bus.setCapacidad(capacidad);
		bus.setMarca("MERCEDES");
		BigDecimal modelo=new BigDecimal("1990");
		bus.setModelo(modelo);
		bus.setTipo("T");
		busDao.save(bus);
		
		pk.setIdRuta(1);
		pk.setIdBus(1);
		pk.setCedulaConductor("133414141");
		pk.setFechaInicio(LocalDate.of(2018, 10, 1));
		pk.setFechaFin(LocalDate.of(2018, 10, 4));
		servicio.setId(pk);
		servicio.setTmio1Conductore(conductor);
		servicioDao.save(servicio);
		
		pk=new Tmio1ServicioPK();
		pk.setIdBus(1);
		pk.setIdRuta(1);
		pk.setCedulaConductor("133414141");
		pk.setFechaInicio(LocalDate.of(2018, 10, 2));
		pk.setFechaFin(LocalDate.of(2018, 10, 6));
		servicio=new Tmio1Servicio();
		servicio.setId(pk);
		servicio.setTmio1Conductore(conductor);
		servicioDao.save(servicio);
		
		pk=new Tmio1ServicioPK();
		pk.setIdBus(1);
		pk.setIdRuta(1);
		pk.setCedulaConductor("133414141");
		pk.setFechaInicio(LocalDate.of(2018, 10, 2));
		pk.setFechaFin(LocalDate.of(2018, 10, 8));
		servicio=new Tmio1Servicio();
		servicio.setId(pk);
		servicio.setTmio1Conductore(conductor);
		servicioDao.save(servicio);
		
		LocalDate s = LocalDate.of(2018, 10, 3);
		Iterable<Object[]> resultado = conductorDao.findByFecha(s);
		String c = "";
		int n = 0;
		for (Object[] objects : resultado) {
			c = (String) objects[0];
			n = ((Number) objects[1]).intValue();
		}
		System.out.println(n + " NUmerosssss");
		Tmio1Conductore co=conductorDao.findByCedula(c).get(0);
		assertNotNull(c);
		assertEquals("133414141",co.getCedula());
		assertTrue(3==n);
		
	}
}