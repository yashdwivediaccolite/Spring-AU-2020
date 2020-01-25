package models;

public class Room implements CommonFeatures{
	private String type;
	private double height;
	private double area;
	private int totalWindows;
	
	public Room(){
		
	}
	

	public Room(String type, double height, double area, int totalWindows) {
		this.type = type;
		this.height = height;
		this.area = area;
		this.totalWindows = totalWindows;
	}

	@Override
	public double getArea() {
		return area;
	}
	
	@Override
	public int getTotalWindows() {
		return totalWindows;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	public void setArea(double area) {
		this.area = area;
	}


	public void setTotalWindows(int totalWindows) {
		this.totalWindows = totalWindows;
	}
	
	
	
	
}
