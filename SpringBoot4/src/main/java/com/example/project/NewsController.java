package com.example.project;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NewsController {


	@Autowired
	public NewsService newsService ;

  @RequestMapping(value = "/api/news/topstories")
	public News  getNews() throws Exception{
		News news =  newsService.getTopStories();
		return news;
	}

}
