package com.example.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class HospitalService {
	
	/*@Autowired
	private HospitalRepository hospitalRepository;*/

	public List<Hospital> hospitalList =  new ArrayList<>();
			
			
	public List<Hospital> getAllHospitals(){
		return hospitalList;
	}
	
	public Hospital getHospital(int id){
		return hospitalList.stream().filter(c->c.getId()==(id)).findFirst().get();
	}
	
	public void addHospital(Hospital hospital){	
		boolean isUpdate = false ; 
		if(hospital!= null) {
			if(hospitalList!= null && hospitalList.size() >0 ) {
				for(Hospital hospitals : hospitalList ) {
					if(hospital.getId() == hospitals.getId()) {
						hospitals.setId(hospital.getId());
						hospitals.setCity(hospital.getCity());
						hospitals.setName(hospital.getName());
						hospitals.setRating(hospital.getRating());
						isUpdate = true;
						break;
					}
				}
			}
			if(!isUpdate) {
				hospitalList.add(hospital);
			}
		}
	}
	
	public void updateHospital(Hospital hospital){
		
	}
	
	public void deleteHospital(Hospital hospital) {		
		if(hospital!= null) {
			if(hospitalList!= null && hospitalList.size() >0 ) {
				hospitalList.remove(hospital);
			}
		}
	}
}
