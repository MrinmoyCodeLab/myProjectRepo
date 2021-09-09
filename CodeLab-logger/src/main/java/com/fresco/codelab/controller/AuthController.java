package com.fresco.codelab.controller;

import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.fresco.codelab.CodeLabLoggerApplication;
import com.fresco.codelab.jms.MergeRequest;
import com.fresco.codelab.service.RegisterService;

@Controller
public class AuthController {
	
	private static final Logger debugLog = Logger.getLogger("debugLogger");
	private static final Logger resultLog = Logger.getLogger("reportsLogger");
	
	@Autowired
	RegisterService service;
	
	@Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/queue/sendMR")
//    @SendToUser("/queue/receiveMR")
	public void processMessageFromClient(@Payload MergeRequest mr) throws Exception {
    	service.saveMergeRequest(mr);
    	simpMessagingTemplate.convertAndSendToUser(mr.getReqTo(), "/queue/receiveMR", mr);
	}
	
	@GetMapping("/register")
	public String register(Principal principal) {
		
		debugLog.info("GET::http://localhost/register::clientIpAddr/127.0.0.1");
		resultLog.debug("GET::http://localhost/register::clientIpAddr/127.0.0.1");
		
		return principal == null ? "registrationpage" : "redirect:/dashboard/";
	}

	@GetMapping({"/login", "/"})
	public String loginPage(Principal principal) {
		debugLog.info("GET::http://localhost/login::clientIpAddr/127.0.0.1");
		resultLog.debug("GET::http://localhost/login::clientIpAddr/127.0.0.1");
		
		return principal == null ? "loginpage" : "redirect:/dashboard/";
	}

	@PostMapping("/register")
	public String register(String fullname, String username, String password) {
		String str =  "POST::http://localhost/register::Body::{ fullname:" +fullname+", username:"+username+", password:"+password+ ",  }clientIpAddr/127.0.0.1" ; 
		
		debugLog.info(str);
		resultLog.debug(str);
	
		service.registerUser(fullname, username, password);
		return "loginpage";
	}

}







