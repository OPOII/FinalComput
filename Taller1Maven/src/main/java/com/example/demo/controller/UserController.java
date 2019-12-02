package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.UserService;

@Controller
public class UserController {
	UserService servicio;
//	@Autowired
//	public UserController(UserService service) {
//		this.servicio=service;
//		;
//	}
	
	@GetMapping("/login")
	public String login() {
		return "loginfirst";
	}
}
