package com.example.MySpringBootProject;


import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class ContentService {

    //put your code here.
	
	
	
	private List<Course> courseList1 = new ArrayList<>(Arrays.asList(
			new Course(2001,"AWS Essentials",100,180,1001),
			new Course(2002,"Eureka",105,185,1001),
			new Course(2003,"Juul",110,190,1001)
			));
	
	private List<Course> courseList2 = new ArrayList<>(Arrays.asList(
			new Course(3001,"AWS Essentials",200,280,1002),
			new Course(3002,"Eureka",205,285,1002),
			new Course(3003,"Juul",210,287,1002)
			));
	
	private List<Course> courseList3 = new ArrayList<>(Arrays.asList(
			new Course(4001,"AWS Essentials",307,380,1003),
			new Course(4002,"Eureka",305,386,1003),
			new Course(4003,"Juul",309,387,1003)
			));
	
		
	private List<Category> categories=new ArrayList<>(Arrays.asList(
			new Category(1001, "Cloud Computing", "network of remote servers hosted on the Internet to store",courseList1),
			new Category(1002,"Data Science","practice of deriving valuable insights from data",courseList2),
			new Category(1003,"DevOps","practices that emphasize on collaboration and communication",courseList3)));
	
	
	public List<Category> getAllContent() {		
		List<Category> catList = this.categories;
		return catList;
	
	}
	
	
	
}
