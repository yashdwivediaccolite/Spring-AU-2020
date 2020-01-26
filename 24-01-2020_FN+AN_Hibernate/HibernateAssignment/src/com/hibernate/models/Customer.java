package com.hibernate.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer extends WebSiteUsers{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private int age;
	
	@ElementCollection
	private List<Item> items=new ArrayList<>();

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="locality",column=@Column(name="MAIN_LOCALITY")),
		@AttributeOverride(name="pincode",column=@Column(name="MAIN_PINCODE")),
		@AttributeOverride(name="street",column=@Column(name="MAIN_STREET"))
	})
	private Address mainAddress;
	
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="locality",column=@Column(name="SECONDARY_LOCALITY")),
		@AttributeOverride(name="pincode",column=@Column(name="SECONDARY_PINCODE")),
		@AttributeOverride(name="street",column=@Column(name="SECONDARY_STREET"))
	})
	private Address secondaryAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
	private ShoppingCart cart;
	
	
	public Customer(){
		
	}
	
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

	public Address getMainAddress() {
		return mainAddress;
	}

	public void setMainAddress(Address mainAddress) {
		this.mainAddress = mainAddress;
	}

	
	
	public Address getSecondaryAddress() {
		return secondaryAddress;
	}

	public void setSecondaryAddress(Address secondaryAddress) {
		this.secondaryAddress = secondaryAddress;
	}

	@Override
	public String toString() {
		return "Id:"+this.id+" Name:"+this.name+" Age:"+this.age;
	}
	
	
	
}
