package com.example.flywaydb;

import org.junit.Test;
import org.mockito.Mockito;

import com.example.flywaydb.repository.InventoryRepository;
import com.example.flywaydb.service.InventoryService;

public class InventoryServiceTest {

private InventoryService inventoryService;
private InventoryRepository inventoryRepositoryMock;
	
	
	
	public void setUp() {
		inventoryRepositoryMock=Mockito.mock(InventoryRepository.class);
		inventoryService = new InventoryService();
	}
	@Test
    public void createClientSuccessfuly() throws Exception {
		
	}

	
	
}
