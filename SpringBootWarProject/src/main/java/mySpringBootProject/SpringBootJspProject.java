package mySpringBootProject;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/Demo")
public class SpringBootJspProject {

	@RequestMapping(value="/name" , method=RequestMethod.GET)
	public ModelAndView sendDataToJsp(@PathVariable String name) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("Name", name);
		mv.setViewName("MyFirstJsp.jsp");
		return mv;
		
	}
}
