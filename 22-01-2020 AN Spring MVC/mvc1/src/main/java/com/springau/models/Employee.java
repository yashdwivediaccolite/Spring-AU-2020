package com.springau.models;

public class Employee {
	private int id;
	private String fname;
	private String lname;
	private long number;
	
	public Employee() {
		
	}
	
	public Employee(int id, String fname, String lname, long number) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.number = number;
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
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	
	
}
