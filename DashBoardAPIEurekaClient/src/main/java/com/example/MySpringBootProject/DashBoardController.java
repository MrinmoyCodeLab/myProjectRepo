package com.example.MySpringBootProject;

import javax.xml.ws.RespectBinding;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/DashBoardService")
public class DashBoardController {

	@RequestMapping("/GetDashBoard/{userName}")
	public String  getDashBoardDetails(@PathVariable("userName") String userName ){
		return "Hello ------->> Welcome to DashBoardService" + userName;
		
	}
	
	public ResponseEntity<JSONObject> getBoardDetails(@PathVariable("userName") String userName ){
		
		JSONObject json =new JSONObject();
		json.put("UserName", userName);
		
		return new ResponseEntity<JSONObject>(json, HttpStatus.OK) ;
	}
}
