package com.springBootAmazon.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springBootAmazon.model.Wallet;
import com.springBootAmazon.repository.WalletRepository;
import com.springBootAmazon.service.WalletService;

@RestController
public class WalletController {

	@Autowired
	private WalletService walletService;

	@Autowired
	private WalletRepository walletRepository;

	// Add amount into wallet
	@PostMapping("/wallet")
	public Wallet addAmount(@RequestBody Wallet wallet) {
		return walletRepository.save(wallet);
	}
	
	@PostMapping("/getProduct")
	public String getProduct(@RequestBody Map<String, Object> product) {
		System.out.println(product);
		return null;
	}
	
	
	
	// Get wallet Amount
	@GetMapping("/wallet/{id}")
	public Wallet getById(@PathVariable int id) {
		return walletRepository.findById(id).get();
	}

	@PutMapping("/wallet/{cartId}/{walletId}")
	public ResponseEntity<Wallet> checkWallet(@PathVariable int cartId,@PathVariable int walletId) throws Exception {
		return walletService.checkWallet(cartId, walletId);
	}

}
