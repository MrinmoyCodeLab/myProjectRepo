package com.example.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsService {


	public News getTopStories() {

	List<News> topStories = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        String getUrl = "https://api.nytimes.com/svc/topstories/v2/science.json?api-key=<your-api-key>";
        News news=new News();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        try {
        	HttpEntity<String> entity = new HttpEntity<String>(headers);
            ResponseEntity<Map> newsList = restTemplate.exchange(getUrl, HttpMethod.GET, entity, Map.class);
            JSONObject jsonObject;

            if (newsList.getStatusCode() == HttpStatus.OK) {

                jsonObject = new JSONObject(newsList.getBody());
                JSONArray jsonArray = jsonObject.getJSONArray("results");
                Results[] results = new Results[jsonArray.length()];
                for(int i=0; i<jsonArray.length(); i++) {
                    news.setTitle(jsonArray.getJSONObject(i).get("title").toString());
                    news.setSection(jsonArray.getJSONObject(i).get("section").toString());
                    String title=jsonArray.getJSONObject(i).get("title").toString();
                    results[i]=new Results();
                    results[i].setTitle(title);
                    news.setResults(results);
                    topStories.add(news);
                }

            }
        }catch(Exception e ) {
        	
        	 Results[] results = new Results[5];
             news.setTitle("Test");
             news.setSection("Test");
             results[0]=new Results();
             results[0].setTitle("Test");
             news.setResults(results);
             topStories.add(news);
        	
        }

        
        return topStories.get(0);
	}
}
