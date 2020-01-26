package com.hibernate.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries(  
	    {  
	        @NamedQuery(  
	        name = "listItems",  
	        query = "from Item"  
	        )  
	    }  
	)  

@Entity
public class Item {
	@Id
	private int id;
	private String name;
	private int quantity;
	private int price;
	
	
	public Item() {
		
	}
	
	public Item(int id, String name, int quantity,int price) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price=price;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Id:"+this.id+" Name:"+this.name+" Quantity:"+this.quantity+" Price:"+this.price;
	}
	
	
}
