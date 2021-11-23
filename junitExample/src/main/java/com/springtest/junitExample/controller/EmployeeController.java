package com.springtest.junitExample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springtest.junitExample.model.AppResponse;
import com.springtest.junitExample.model.AppResponse.Status;
import com.springtest.junitExample.model.EmployeeDTO;
import com.springtest.junitExample.service.EmployeeService;
import com.springtest.junitExample.service.EmployeeServiceImpl;
import com.springtest.junitExample.util.AppException;
import com.springtest.junitExample.util.AppUtil;


@RestController
@RequestMapping("/api")
public class EmployeeController {

	private final EmployeeService  employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@PostMapping("/save-emp-details")
	public AppResponse<String> saveEmployeeDetails(@RequestBody EmployeeDTO employeeDTO ){
		
		AppResponse<String> appResponse = new  AppResponse<String>();
		String msg = "Data saved succesfully..";
		try {
			sanitizeData(employeeDTO);
			employeeService.saveEmployeeDetails(employeeDTO);
			appResponse.setMessage(msg);
			appResponse.setStatus(Status.success);
		} catch (AppException e) {
			appResponse.setMessage("Upable to save Data " + e.getMessage());
			appResponse.setStatus(Status.success);
		}
		return appResponse;
	}
	
	@PostMapping("/fetch-emp-details/{employeeId}")
	public AppResponse<EmployeeDTO> FetchEmployeeDetails(@PathVariable String employeeId ){
		
		AppResponse<EmployeeDTO> appResponse = new  AppResponse<EmployeeDTO>();
		EmployeeDTO employeeDTO = new EmployeeDTO();
		String msg = "Data saved succesfully..";
		try {
			employeeDTO.setEmpId(AppUtil.sanitizeInput(employeeId));
			employeeDTO = employeeService.fetchEmployeeDetails(employeeDTO);
			appResponse.setMessage(msg);
			appResponse.setStatus(Status.success);
			appResponse.setData(employeeDTO);
		} catch (AppException e) {
			appResponse.setMessage("Upable to save Data " + e.getMessage());
			appResponse.setStatus(Status.success);
		}
		return appResponse;
	}
	
	public void sanitizeData(EmployeeDTO employeeDTO) {		
		employeeDTO.setEmpId(AppUtil.sanitizeInput(employeeDTO.getEmpId()));
		employeeDTO.setFirstName(AppUtil.sanitizeInput(employeeDTO.getFirstName()));
		employeeDTO.setLastName(AppUtil.sanitizeInput(employeeDTO.getLastName()));
		employeeDTO.setPhoneno(AppUtil.sanitizeInput(employeeDTO.getPhoneno()));
		employeeDTO.setSalary(AppUtil.sanitizeInput(employeeDTO.getSalary()));
		employeeDTO.setDateOfBirth(AppUtil.sanitizeInput(employeeDTO.getDateOfBirth()));
	}
	
	
	@ExceptionHandler(value= {Exception.class})
	public ResponseEntity<Exception> handlerException(Exception exception) {
		
		String code ="";
		String message ="";
		if(exception instanceof AppException) {
			AppException appException = (AppException) exception;			
			message = appException.getMessage();
		}	
		
		return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
