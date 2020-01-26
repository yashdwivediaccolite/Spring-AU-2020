package com.hibernate.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class ShoppingCart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int user_id;
	
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="CART_NAME", joinColumns=@JoinColumn(name="CART_ID"),inverseJoinColumns=@JoinColumn(name="ITEM_ID"))
	private List<Item>items=new ArrayList<>();
	
	public ShoppingCart() {
		
	}
	
	public ShoppingCart(int user_id) {
		this.user_id = user_id;
	}


	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
	
}
