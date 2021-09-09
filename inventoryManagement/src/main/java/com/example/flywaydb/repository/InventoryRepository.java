package com.example.flywaydb.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.flywaydb.Inventory;


public interface InventoryRepository extends CrudRepository<Inventory, Integer>{
	

}
