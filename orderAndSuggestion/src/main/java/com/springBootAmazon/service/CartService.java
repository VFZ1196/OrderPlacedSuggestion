package com.springBootAmazon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springBootAmazon.model.Cart;
import com.springBootAmazon.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;

	public ResponseEntity<Cart> updateCart(@PathVariable int cartId, @PathVariable Integer id) throws Exception {

		Cart cart = cartRepository.findById(cartId).get();

		if (id.equals(cart.getOrderId())) {

			if (cart.isPlaced() == false) {

				cart.setPlaced(true);

				System.out.println("Order id " + cart.getOrderId() + " Placed ");
			}
		}

		Cart update = cartRepository.save(cart);

		return ResponseEntity.ok(update);
	}
	
	@GetMapping("/cart/{specificCategory}")
	public ResponseEntity<Cart> getBySpecificCategory(@PathVariable String specificCategory) {

		Cart cart = cartRepository.findBySpecificCategory(specificCategory).get();

		return ResponseEntity.ok().body(cart);
	}
}
