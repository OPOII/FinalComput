package com.example.demo.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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
@SpringBootTest(classes=ThymeleafValidationApplication.class)
@RunWith(SpringRunner.class)
@Rollback(false)
public class TestBusesDao {
	@Autowired
	private BusesDao busesDao;
	@Autowired
	private RutasDao rutaDao;
	@Autowired
	private ServiciosDao servicioDao;
	@Autowired
	private ConductoreDao conductorDao;
	@Test
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void SaveBus() {
		assertNotNull(busesDao);
		Tmio1Bus bus=new Tmio1Bus();
		bus.setPlaca("VCX 449");
		BigDecimal capacidad=new BigDecimal("20");
		bus.setCapacidad(capacidad);
		bus.setMarca("MERCEDES");
		BigDecimal modelo=new BigDecimal("1990");
		bus.setModelo(modelo);
		bus.setTipo("T");
		busesDao.save(bus);
		assertNotNull(busesDao.findById(1));
	}
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void SearchById() {
		SaveBus();
		assertNotNull(busesDao);
		Tmio1Bus bus=busesDao.findById(1);
		assertNotNull(bus);
	}
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void SearchByPlaca() {
		SaveBus();
		assertNotNull(busesDao);
		assertEquals("VCX 449", busesDao.findByPlaca("VCX 449").get(0).getPlaca());
	}
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void DeleteBus() {
		SaveBus();
		assertNotNull(busesDao);
		Tmio1Bus bus1=busesDao.findById(1);
		busesDao.delete(bus1);
		assertNull(busesDao.findById(1));
	}
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void SearchByModelo() {
		SaveBus();
		assertNotNull(busesDao);
		assertEquals("1990",busesDao.findByModelo("1990").get(0).getModelo().intValue()+"");
	}
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void SearchByMarca() {
		SaveBus();
		assertNotNull(busesDao);
		assertEquals("MERCEDES",busesDao.findByMarca("MERCEDES").get(0).getMarca());
	}
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void listadoBuses() {
		assertNotNull(busesDao);
		Tmio1Bus bus=new Tmio1Bus();
		Tmio1Conductore conductor=new Tmio1Conductore();
		Tmio1Ruta ruta=new Tmio1Ruta();
		Tmio1Servicio serv=new Tmio1Servicio();
		Tmio1ServicioPK pk=new Tmio1ServicioPK();
		
		conductor.setCedula("1225172");
		conductor.setNombre("Diana");
		conductor.setApellidos("Patricia");
		conductorDao.save(conductor);
		
		ruta.setDescripcion("asf");
		ruta.setDiaInicio(new BigDecimal(2));
		ruta.setDiaFin(new BigDecimal(6));
		rutaDao.save(ruta);
		
		bus.setCapacidad(new BigDecimal(7));
		bus.setMarca("MERCEDES");
		bus.setModelo(new BigDecimal(1888));
		busesDao.save(bus);
		
		pk.setCedulaConductor("1225172");
		pk.setFechaInicio(LocalDate.of(2018, 10, 2));
		pk.setFechaFin(LocalDate.of(2018, 10, 9));
		pk.setIdBus(1);
		pk.setIdRuta(1);
		serv.setId(pk);
		serv.setTmio1Bus(bus);
		serv.setTmio1Conductore(conductor);
		serv.setTmio1Ruta(ruta);
		servicioDao.save(serv);
		
		pk=new Tmio1ServicioPK();
		pk.setIdBus(1);
		pk.setIdRuta(1);
		pk.setCedulaConductor("133414141");
		pk.setFechaInicio(LocalDate.of(2018, 10, 2));
		pk.setFechaFin(LocalDate.of(2018, 10, 8));
		serv=new Tmio1Servicio();
		serv.setId(pk);
		serv.setTmio1Conductore(conductor);
		serv.setTmio1Bus(bus);
		serv.setTmio1Ruta(ruta);
		servicioDao.save(serv);
		
		pk=new Tmio1ServicioPK();
		pk.setIdBus(1);
		pk.setIdRuta(1);
		pk.setCedulaConductor("133414141");
		pk.setFechaInicio(LocalDate.of(2018, 10, 2));
		pk.setFechaFin(LocalDate.of(2018, 10, 10));
		serv=new Tmio1Servicio();
		serv.setId(pk);
		serv.setTmio1Conductore(conductor);
		serv.setTmio1Bus(bus);
		serv.setTmio1Ruta(ruta);
		servicioDao.save(serv);
		
		List<Tmio1Bus> lista=busesDao.findByFecha(LocalDate.of(2018, 10, 5));
		System.out.println(lista.size());
	}
	
}