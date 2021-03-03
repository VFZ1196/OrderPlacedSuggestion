package com.springBootAmazon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springBootAmazon.model.Cart;
import com.springBootAmazon.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;

	// Placed Order and set value from false to true
	public ResponseEntity<Cart> updateCart(int cartId, Integer id) throws Exception {

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

	// Get cart item by category
	public ResponseEntity<Cart> getByCategory(int cartId, String category) {

		Cart cart = cartRepository.findById(cartId).get();

		if (category.equals(cart.getCategory())) {

			return ResponseEntity.ok(cart);

		}
		// return (ResponseEntity<Cart>) ResponseEntity.badRequest();
		return new ResponseEntity("Resource Not Found", HttpStatus.NOT_FOUND);
	}

	// Get cart item by sub category
	public ResponseEntity<Cart> getBySubCategory(int cartId, String subCategory) {

		Cart cart = cartRepository.findById(cartId).get();

		if (subCategory.equals(cart.getSubCategory())) {

			return ResponseEntity.ok(cart);
		}
		return null;
	}

	// Get cart item by specific category
	public ResponseEntity<Cart> getBySpecificCategory(int cartId, String specificCategory) {

		Cart cart = cartRepository.findById(cartId).get();

		if (specificCategory.equals(cart.getSpecificCategory())) {

			return ResponseEntity.ok(cart);
		}
		return null;
	}
}
