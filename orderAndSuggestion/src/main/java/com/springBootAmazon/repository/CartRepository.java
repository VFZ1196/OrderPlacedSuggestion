package com.springBootAmazon.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBootAmazon.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

	Optional<Cart> findBySpecificCategory(String specificCategory);


}
