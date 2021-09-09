package com.example.flywaydb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.flywaydb.Inventory;
import com.example.flywaydb.service.InventoryService;

@RestController 
public class inventoryController {
	
	@Autowired
	InventoryService invService;
	
	@GetMapping("/")
    public List<Inventory> getInvList() {		
		List<Inventory> invList = invService.getInvList();
        return invList;
    }
	
	
	@GetMapping("/{product_Id}")
    public Inventory getIndividualInvList(@PathVariable int product_Id) {
		Inventory intDetails = invService.getIndInvList(product_Id);
        return intDetails;
    }
	
	
	
	@PostMapping("/creat")
    public void createInvList(Inventory inventory) {
		invService.createInvList(inventory);
		
    }
	
	
	@PutMapping("/update")
    public void updateInvList(List<Inventory> inlist) {		
		
    }
	
	@DeleteMapping("/delete/{product_Id}")
    public void deleteInvList(@PathVariable int product_Id) {	
		invService.deleteInvList(product_Id);		
    }
}
