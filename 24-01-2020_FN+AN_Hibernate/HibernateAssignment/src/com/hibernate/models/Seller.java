package com.hibernate.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NamedNativeQuery;


@Entity
@DiscriminatorValue("2")
@NamedNativeQuery(name = "seller.get",query = "SELECT * FROM Seller",resultClass=Seller.class)
public class Seller extends WebSiteUsers{
	@Id
	private int id;
	private String name;
	private int age;
	
	public Seller() {
		
	}
	
	@OneToMany(cascade=CascadeType.REMOVE)
	@JoinTable(name="SELLER_NAME", joinColumns=@JoinColumn(name="SELLER_ID"),inverseJoinColumns=@JoinColumn(name="ITEM_ID"))
	private List<Item> items=new ArrayList<>();
	
	public Seller(int id, String name, int age) {
		super();
		this.id = id;
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
	
	
	@Override
	public String toString() {
		return "Id:"+this.id+" Name:"+this.name+" Age:"+this.age;
	}
	
	
	
	
}
