package com.example.MySpringBootProject;


import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

  @Autowired
  public EmployeeService empser;

    //Put your code here
  //@RequestMapping(value="/GetEmp", method=RequestMethod.GET,consumes = "application/json")
  
    @RequestMapping("/")
	public List<Employee> getEmpList(){
    List<Employee> emplist = empser.getEmployees();
		return emplist;
	}

}
