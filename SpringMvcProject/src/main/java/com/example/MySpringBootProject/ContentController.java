package com.example.MySpringBootProject;


import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class ContentController {

@Autowired
public ContentService contentService;

	@RequestMapping("/")
	public List<Category> getContent(){
    List<Category> cateGoryList = contentService.getAllContent();
		return cateGoryList;
	}


}
