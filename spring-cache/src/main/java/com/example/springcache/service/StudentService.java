package com.example.springcache.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.springcache.domain.Student;

@Service
public class StudentService {
	@Cacheable("student")
	public Student getStudentByID(String id) {
		try {
			Thread.sleep(1000*5);
			System.out.println("Entering cacheblock for ID:  " + id);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Student(id,"Sajal" ,"V");
		
	}
}
