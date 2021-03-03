package com.springBootAmazon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBootAmazon.model.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Integer>{

}
