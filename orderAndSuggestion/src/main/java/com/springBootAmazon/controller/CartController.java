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
	
	//Add product into cart
	@PostMapping("/cart")
	public Cart add(@RequestBody Cart cart) {
		return cartRepository.save(cart);
	}
	
	//Get All Product
	@GetMapping("/cart")
	public List<Cart> getAll() {
		return cartRepository.findAll();
	
	}
	
	//Get product by id
	@GetMapping("/cart/{id}")
	public Cart getById(@PathVariable int id) {
		return cartRepository.findById(id).get();
	}
	
	//Get product by category	
	@GetMapping("/cart1/{cartId}/{category}")
	public ResponseEntity<Cart> getByCategory(@PathVariable int cartId, @PathVariable String category) throws Exception {
		return cartService.getByCategory(cartId, category);
	}
	
	//Get product by sub category
	@GetMapping("/cart2/{cartId}/{subCategory}")
	public ResponseEntity<Cart> getBySubCategory(@PathVariable int cartId, @PathVariable String subCategory) throws Exception {
		return cartService.getBySubCategory(cartId, subCategory);
	}
	
	//Get product by specific category
	@GetMapping("/cart3/{cartId}/{specificCategory}")
	public ResponseEntity<Cart> getBySpecificCategory(@PathVariable int cartId,@PathVariable String specificCategory) throws Exception {
		return cartService.getBySpecificCategory(cartId, specificCategory);
	}
	
	//order and update product
	@PutMapping("/cart/{cartId}/{id}")
	public ResponseEntity<Cart> updateCart(@PathVariable int cartId, @PathVariable int id) throws Exception {
		return cartService.updateCart(cartId, id);
	}
	
}
