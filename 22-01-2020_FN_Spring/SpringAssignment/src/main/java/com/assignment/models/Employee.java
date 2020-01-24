package com.assignment.models;

import java.util.HashMap;
import java.util.Map;

public class Employee {
	
	private int id;
	private String fname;
	private String lname;
	private int age;
	private Map<Integer,Employee>map;
	
	Employee(){
		
	}
	
	Employee(HashMap<Integer,Employee>h){
		this.map=h;
	}
	
	Employee(int id,String fname,String lname,int age){
		this.id=id;
		this.fname=fname;
		this.lname=lname;
		this.age=age;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Map<Integer, Employee> getMap() {
		return map;
	}

	public void setMap(Map<Integer, Employee> map) {
		this.map = map;
	}

	@Override
	public String toString() {
		return "Id:"+this.id+" First Name:"+this.fname+" Last Name:"+this.lname+" Age:"+this.age;
	}
}
