package com.springBootAmazon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springBootAmazon.model.Items;
import com.springBootAmazon.repository.ItemsRepository;

@RestController
public class ItemsController {

	@Autowired
	private ItemsRepository itemsRepository;

	
	@PostMapping("/items")
	public Items add(@RequestBody Items item) {
		return itemsRepository.save(item);
	}

	@GetMapping("/items")
	public List<Items> getAll() {
		return itemsRepository.findAll();
	}
}
