package com.example.demo.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
public class ConductoreApp {
	@Id
	@NotBlank
	private String cedula;
//	@NonNull
//	@NotBlank
//	private String apellidos;
//	@DateTimeFormat(pattern="yyyy-MM-dd")
//	private Date fechaContratacion;
//	@DateTimeFormat(pattern="yyyy-MM-dd")
//	private Date fechaNacimiento;
//	@NonNull
//	@NotBlank
//	private String nombre;
}
