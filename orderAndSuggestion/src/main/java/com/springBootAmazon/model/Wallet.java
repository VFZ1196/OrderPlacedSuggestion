package com.springBootAmazon.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="wallet")
public class Wallet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int walletId;
	private Float walletAmount;
	
	public Wallet() {
		
	}

	public Wallet(Float walletAmount) {
		super();
		this.walletAmount = walletAmount;
	}

	public int getWalletId() {
		return walletId;
	}

	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}

	public float getWalletAmount() {
		return walletAmount;
	}

	public void setWalletAmount(Float walletAmount) {
		this.walletAmount = walletAmount;
	}

}
