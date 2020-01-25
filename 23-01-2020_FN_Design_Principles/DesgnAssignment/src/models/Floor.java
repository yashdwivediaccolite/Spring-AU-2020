package models;
import java.util.ArrayList;
import java.util.List; 

public class Floor implements CommonFeatures{
	private List<Flat> flatList=new ArrayList<>();
	private int floorNumber;
	
	public void Floor() {
		
	}

	public Floor(List<Flat> flatList, int floorNumber) {
		this.flatList = flatList;
		this.floorNumber = floorNumber;
	}

	public List<Flat> getFlatList() {
		return flatList;
	}

	public void addFlatList(Flat flat) {
		this.flatList.add(flat);
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	@Override
	public double getArea() {
		if(this.flatList.size()>0) {
			double totalArea=0;
			for(Flat flat:this.flatList) {
				totalArea+=(double)flat.getArea();
			}
			return totalArea;
		}
		return 0;
	}

	@Override
	public int getTotalWindows() {
		if(this.flatList.size()>0) {
			int totalWindows=0;
			for(Flat flat:this.flatList) {
				totalWindows+=(double)flat.getTotalWindows();
			}
			return totalWindows;
		}
		return 0;
	}
	
	
	
}

