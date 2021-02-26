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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private int cartId;

	private int orderId;

	private String category;

	private String subCategory;

	private String specificCategory;

	private boolean isPlaced;
	
	@Column(unique = true)
	private int cid;
	
	@Column(unique = true)
	private int sid;
	
	@Column(unique = true)
	private int specid;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "cart_items", joinColumns = @JoinColumn(name = "cart_id"), inverseJoinColumns = @JoinColumn(name = "items_id"))
	private Set<Items> items = new HashSet<>();

	public Cart() {

	}

	public Cart(int orderId, String category, String subCategory, String specificCategory, boolean isPlaced, int cid,
			int sid, int specid, Set<Items> items) {
		super();
		this.orderId = orderId;
		this.category = category;
		this.subCategory = subCategory;
		this.specificCategory = specificCategory;
		this.isPlaced = isPlaced;
		this.cid = cid;
		this.sid = sid;
		this.specid = specid;
		this.items = items;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
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

	public boolean isPlaced() {
		return isPlaced;
	}

	public void setPlaced(boolean isPlaced) {
		this.isPlaced = isPlaced;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getSpecid() {
		return specid;
	}

	public void setSpecid(int specid) {
		this.specid = specid;
	}

	public Set<Items> getItems() {
		return items;
	}

	public void setItems(Set<Items> items) {
		this.items = items;
	}

}
