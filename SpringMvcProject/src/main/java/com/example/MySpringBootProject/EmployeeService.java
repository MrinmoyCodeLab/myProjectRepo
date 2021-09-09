package com.example.MySpringBootProject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {


	public List<Employee> getEmployees() {
        //put your code here.
        Employee emp1 = new Employee("Sandhya", 20, 0);
        Employee emp2 = new Employee("Kemp", 24, 2);
        Employee emp3 = new Employee("Anil", 22, 3);
        Employee emp4 = new Employee("Kumar", 30, 6);
        Employee emp5 = new Employee("Tim", 32, 7);

        List<Employee> emplist = new ArrayList<>();
        emplist.add(emp1);
        emplist.add(emp2);
        emplist.add(emp3);
        emplist.add(emp4);
        emplist.add(emp5);
        Collections.sort(emplist);
        return emplist;
    }




}