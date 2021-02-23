package com.springBootAmazon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Items {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "items_id")
	private int itemsId;

	private String suggestedCategory;

	public Items() {

	}

	public Items(String suggestedCategory) {
		super();
		this.suggestedCategory = suggestedCategory;
	}

	public int getItemsId() {
		return itemsId;
	}

	public void setItemsId(int itemsId) {
		this.itemsId = itemsId;
	}

	public String getSuggestedCategory() {
		return suggestedCategory;
	}

	public void setSuggestedCategory(String suggestedCategory) {
		this.suggestedCategory = suggestedCategory;
	}

	
	
}
