package com.example.demo.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;

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
import com.example.demo.dao.BusesDao;
import com.example.demo.dao.ConductoreDao;
import com.example.demo.modelo.Tmio1Bus;
import com.example.demo.modelo.Tmio1Conductore;
import com.example.demo.modelo.Tmio1Ruta;
@SpringBootTest(classes=ThymeleafValidationApplication.class)
@RunWith(SpringRunner.class)
@Rollback(false)
public class TestRutasDao {
	@Autowired
	private RutasDao rutasDao;

	@Test
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void SaveRuta() {
		Tmio1Ruta ruta=new Tmio1Ruta();
		ruta.setActiva("Activa");
		ruta.setDescripcion("Ruta que pasa por todo el centro");
		ruta.setDiaFin(new BigDecimal(6));
		ruta.setDiaInicio(new BigDecimal(2));
		
		ruta.setHoraInicio(new BigDecimal(8));
		ruta.setHoraFin(new BigDecimal(21));
		ruta.setNumero("E41");
		rutasDao.save(ruta);
	}
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void Delete() {
//		SaveRuta();
		assertNotNull(rutasDao);
		Tmio1Ruta ruta=rutasDao.findById(1);
		rutasDao.delete(ruta);
		assertNull(rutasDao.findById(1));
	}
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void SearchById() {
//		SaveRuta();
		assertNotNull(rutasDao);
		assertNotNull(rutasDao.findById(1));
	}
	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void SearchByHora() {
//		SaveRuta();
		assertNotNull(rutasDao);
		assertEquals(rutasDao.findByHoras(new BigDecimal(9), new BigDecimal(20)).get(0).getNumero(),"E41");
	}
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void searchByDia() {
//		SaveRuta();
		assertNotNull(rutasDao);
		assertEquals(rutasDao.findByFecha(new BigDecimal(3), new BigDecimal(5)).get(0).getNumero(),"E41");
	}
		
	
}