package com.example.flywaydb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.flywaydb.Inventory;

import com.example.flywaydb.repository.InventoryRepository;

@Service 
public class InventoryService { 
	
	@Autowired
	InventoryRepository invRepor;

	public List<Inventory> getInvList() {
		List<Inventory> intList = (List<Inventory>) invRepor.findAll();
		return intList;
		
	}
	
	public Inventory getIndInvList(int product_id) {
		Inventory inv =  invRepor.findById(product_id).get();
		return inv;
		
	}

	 public void createInvList(Inventory inventory) {
		 invRepor.save( inventory);
	 }
	 
	 public void deleteInvList(@PathVariable int product_Id) {	
		 invRepor.deleteById(product_Id);
	 }
}
