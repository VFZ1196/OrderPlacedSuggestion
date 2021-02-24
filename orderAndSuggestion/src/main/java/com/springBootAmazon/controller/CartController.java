package com.springBootAmazon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springBootAmazon.model.Cart;
import com.springBootAmazon.repository.CartRepository;
import com.springBootAmazon.service.CartService;

@RestController
public class CartController {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/cart")
	public Cart add(@RequestBody Cart cart) {
		return cartRepository.save(cart);
	}
	
	@GetMapping("/cart")
	public List<Cart> getAll() {
		return cartRepository.findAll();
	}
	
	@GetMapping("/cart/{id}")
	public Cart getById(@PathVariable int id) {
		return cartRepository.findById(id).get();
	}
	
	@PutMapping("/cart/{cartId}/{id}")
	public ResponseEntity<Cart> updateCart(@PathVariable int cartId, @PathVariable int id) throws Exception {
		return cartService.updateCart(cartId, id);
	}
}
