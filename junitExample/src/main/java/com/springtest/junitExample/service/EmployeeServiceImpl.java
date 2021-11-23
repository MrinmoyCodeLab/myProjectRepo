package com.springtest.junitExample.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.springtest.junitExample.model.EmployeeDTO;
import com.springtest.junitExample.model.EmployeeVO;
import com.springtest.junitExample.repository.EmployeeRepository;
import com.springtest.junitExample.util.AppException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}


	public boolean saveEmployeeDetails(EmployeeDTO employeeDTO) throws AppException {
		
		employeeDTO = Optional.of(employeeDTO).orElseThrow(()-> new AppException("No data from request "));
		EmployeeVO employeeVO = new EmployeeVO();
		validateFirstName(employeeDTO);
		employeeVO.setFirstName(employeeDTO.getFirstName());
		validateLastName(employeeDTO);
		employeeVO.setLastName(employeeDTO.getLastName());
		validatePhoneNumber(employeeDTO);
		employeeVO.setPhoneno(employeeDTO.getPhoneno());
		validateSalary(employeeDTO);
		employeeVO.setSalary(employeeDTO.getSalary());	
		LocalDate dob = validateDOb(employeeDTO);
		employeeVO.setDateOfBirth(dob);
		employeeRepository.save(employeeVO);
		return true;
	}

	
	public EmployeeDTO getEmployeeDetails(String empid) {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean updateEmployeeDetails(EmployeeVO employeeVO) throws AppException {
		// TODO Auto-generated method stub
		return false;
	}

	
	public EmployeeDTO removeEmployeeDetails(String empid) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public EmployeeDTO fetchEmployeeDetails(EmployeeDTO employeeDTO) throws AppException {
	
		Integer empid =  validateEmpid(employeeDTO);
		Optional<EmployeeVO> empDto = employeeRepository.findById(empid);
		
		EmployeeVO employeeVO = empDto.isPresent() ? empDto.get() : new EmployeeVO();
		
		BeanUtils.copyProperties(employeeVO, employeeDTO);
		
		return employeeDTO;
	}
	
	
	private void validateFirstName(EmployeeDTO employeeDTO) throws AppException{
		if(!StringUtils.hasLength(employeeDTO.getFirstName())) {
			throw new AppException("Invalid First Name ");
		}
	}

	
	private void validateLastName(EmployeeDTO employeeDTO) throws AppException{
		if(!StringUtils.hasLength(employeeDTO.getLastName())) {
			throw new AppException("Invalid Last Name ");
		}
	}
	
	private final int validateSalary(EmployeeDTO employeeDTO) throws AppException{
		if(!StringUtils.hasLength(employeeDTO.getSalary())) {
			throw new AppException("Invalid salary ");
		}
		int salary = 0;
		try {
			salary = Integer.parseInt(employeeDTO.getSalary());
		}catch(Exception e) {
			throw new AppException("Invalid salary ");
		}
		return salary;		
	}
	
	private void validatePhoneNumber(EmployeeDTO employeeDTO) throws AppException{
		if(!StringUtils.hasLength(employeeDTO.getPhoneno())
				&& employeeDTO.getPhoneno().length()!=10) {
			throw new AppException("Invalid phone number ");
		}
	}
	
	
	private final Integer validateEmpid(EmployeeDTO employeeDTO) throws AppException {
		if(!StringUtils.hasLength(employeeDTO.getEmpId())) {
			throw new AppException("Invalid emp number ");
		}
		
		if(!employeeDTO.getEmpId().matches("^[0-9]+$")) {
			throw new AppException("Invalid emp id ");
		}
		
		return Integer.parseInt(employeeDTO.getEmpId());
	}
	
	private LocalDate validateDOb(EmployeeDTO employeeDTO) throws AppException {
		if(!StringUtils.hasLength(employeeDTO.getDateOfBirth())) {
			throw new AppException("Invalid DOB ");
		}		
		LocalDate dob = null ;
		try {
			dob  = LocalDate.parse(employeeDTO.getDateOfBirth());
		} catch (Exception e) {
			throw new AppException("Invalid DOB ");
		}
		
		return dob;
	}
	
}
