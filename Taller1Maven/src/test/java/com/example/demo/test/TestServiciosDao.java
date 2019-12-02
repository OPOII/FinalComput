package com.example.demo.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import com.example.demo.modelo.Tmio1Bus;
import com.example.demo.modelo.Tmio1Conductore;
import com.example.demo.modelo.Tmio1Ruta;
import com.example.demo.modelo.Tmio1Servicio;
import com.example.demo.modelo.Tmio1ServicioPK;

public class TestServiciosDao {

	@Before
	public void EscenarioPunto2() {
//		assertNotNull(conductorDao);
		Tmio1ServicioPK serviciopk = new Tmio1ServicioPK();
		Tmio1Servicio servicio = new Tmio1Servicio();
		Tmio1Conductore conductor = new Tmio1Conductore();
		Tmio1Ruta ruta = new Tmio1Ruta();
		Tmio1Bus bus = new Tmio1Bus();
		serviciopk.setIdBus(1);
		serviciopk.setCedulaConductor("5588788");
		serviciopk.setIdRuta(1);
		serviciopk.setFechaInicio(LocalDate.of(2018, 10, 2));
		serviciopk.setFechaFin(LocalDate.of(2018, 10, 4));

		ruta.setId(1);
		ruta.setActiva("Activa");
		ruta.setDescripcion("afafas");
		ruta.setDiaInicio(new BigDecimal(1));
		ruta.setDiaFin(new BigDecimal(5));
		ruta.setHoraInicio(new BigDecimal(7));
		ruta.setHoraFin(new BigDecimal(22));
		ruta.setNumero("E41");

		bus.setPlaca("VCX 449");
		BigDecimal capacidad = new BigDecimal("20");
		bus.setCapacidad(capacidad);
		bus.setMarca("MERCEDES");
		BigDecimal modelo = new BigDecimal("1990");
		bus.setModelo(modelo);
		bus.setTipo("T");

		conductor.setCedula("1107520333");
		conductor.setApellidos("Chacon");
		conductor.setNombre("Andrea");
		conductor.setFechaContratacion(LocalDate.of(2010, 10, 2));
		conductor.setFechaNacimiento(LocalDate.of(1998, 9, 15));

		servicio.setId(serviciopk);
		servicio.setTmio1Bus(bus);
		servicio.setTmio1Ruta(ruta);
		servicio.setTmio1Conductore(conductor);
		servicio.setFechaContratacion(conductor.getFechaContratacion());

	}

}
