package com.springBootAmazon.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private int cartId;

	private String category;

	private String subCategory;

	private String specificCategory;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "cart_items", joinColumns = @JoinColumn(name = "cart_id"),
	                                inverseJoinColumns = @JoinColumn(name = "items_id"))
	private Set<Items> items = new HashSet<>();

	public Cart() {

	}

	public Cart(String category, String subCategory, String specificCategory, Set<Items> items) {
		super();
		this.category = category;
		this.subCategory = subCategory;
		this.specificCategory = specificCategory;
		this.items = items;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getSpecificCategory() {
		return specificCategory;
	}

	public void setSpecificCategory(String specificCategory) {
		this.specificCategory = specificCategory;
	}

	public Set<Items> getItems() {
		return items;
	}

	public void setItems(Set<Items> items) {
		this.items = items;
	}

}
