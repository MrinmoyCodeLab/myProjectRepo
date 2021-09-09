package com.fresco.codelab.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.fresco.codelab.service.RegisterService;

@Controller
public class AuthController {

  @Autowired
  RegisterService service;
	
	@GetMapping("/register")
	public String register() {
		return  "registrationpage.jsp";
	}

	@GetMapping("/login")
	public String loginPage() {
		return "loginpage.jsp" ;
	}

	@PostMapping("/register")
	public String register(String fullname, String username, String password) {
		service.registerUser(fullname, username, password);
		return "loginpage.jsp";
	}

}
