package com.example.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;


import com.example.project.Inventory;

@Service
public class consumerService {

	@Autowired
	RestTemplate restTemplate ;

	public List<Inventory> getInvList() {
		final String uri = "http://ping-server/";		
		List<Inventory> intList =  restTemplate.getForObject(uri, List.class);		
		return intList;
		
	}
	
	public Inventory getIndInvList(int product_id) { 	
		
		final String uri = "http://ping-server/{product_Id}";
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("product_Id", "1");
		Inventory inv =   restTemplate.getForObject(uri , Inventory.class, params);
		return inv;
		
	}

	 public void createInvList(Inventory inventory) {
		 final String uri = "http://ping-server/creat";
		 restTemplate.postForObject( uri, inventory, Inventory.class);
	 }
	 
	 public void deleteInvList(@PathVariable int product_Id) {	
		 final String uri = "http://ping-server/delete/{product_Id}";
		 Map<String, String> params = new HashMap<String, String>();
		 params.put("product_Id", "2");
		 restTemplate.delete( uri , params );
	 }

	

	
	

}
