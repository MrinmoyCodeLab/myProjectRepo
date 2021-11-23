package com.springtest.junitExample.service;

import com.springtest.junitExample.model.EmployeeDTO;
import com.springtest.junitExample.model.EmployeeVO;
import com.springtest.junitExample.util.AppException;

public interface EmployeeService {

	boolean saveEmployeeDetails(EmployeeDTO employeeDTO) throws AppException;
	
	EmployeeDTO getEmployeeDetails(String empid) ;
	
	boolean updateEmployeeDetails(EmployeeVO employeeVO) throws AppException;
	
	EmployeeDTO removeEmployeeDetails(String empid) ;
	
	EmployeeDTO fetchEmployeeDetails(EmployeeDTO employeeDTO) throws AppException;
	
	
}
