package com.springBootAmazon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springBootAmazon.model.Cart;
import com.springBootAmazon.model.Wallet;
import com.springBootAmazon.repository.CartRepository;
import com.springBootAmazon.repository.WalletRepository;

@Service
public class WalletService {

	@Autowired
	private WalletRepository walletRepository;
	
	@Autowired
	private CartRepository cartRepository;

	// Check wallet balance and compare with order price
	public ResponseEntity<Wallet> checkWallet(int cartId,int walletId) throws Exception {

		Wallet wallet = walletRepository.findById(walletId).get();
		Cart cart = cartRepository.findById(cartId).get();
		
		if (cart.getPrice() > wallet.getWalletAmount()) {

			System.out.println("Insufficient balance");

		} else {

			wallet.setWalletAmount(wallet.getWalletAmount() - cart.getPrice());

			System.out.println("Order id " + cart.getOrderId() +" Placed Successfully");

			Wallet update = walletRepository.save(wallet);

			return ResponseEntity.ok(update);
		}
		
		return null;
	}

}
