package com.springBootAmazon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBootAmazon.model.Items;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Integer> {

}
