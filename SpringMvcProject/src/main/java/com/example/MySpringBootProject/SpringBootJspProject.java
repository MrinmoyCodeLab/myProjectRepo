/*package com.example.MySpringBootProject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController

public class SpringBootJspProject {

	
	@RequestMapping("/Demo")
	public String getJsp() {		
		return "pages.jsp";
		
	}
	
	@RequestMapping("/Demo1")
	public ModelAndView getDemoJsp() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("Name", "Mrinmoy");
		mv.setViewName("pages2");
		return mv;
		
	}
	
	
}
*/