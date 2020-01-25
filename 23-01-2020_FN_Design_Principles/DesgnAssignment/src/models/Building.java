package models;
import java.util.ArrayList;
import java.util.List; 

public class Building implements CommonFeatures{
	List<Floor> floorList=new ArrayList<>();
	private int storeys;
	private String name;

	
	public Building(List<Floor> floorList, int storeys, String name) {
		this.floorList = floorList;
		this.storeys = storeys;
		this.name = name;
	}

	public List<Floor> getFloorList() {
		return floorList;
	}

	public void addFloorList(Floor floor) {
		this.floorList.add(floor);
	}

	public int getStoreys() {
		return storeys;
	}

	public void setStoreys(int storeys) {
		this.storeys = storeys;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getTotalFlats() {
		int totalFlats=0;
		for(Floor floor:this.floorList) {
			for(Flat room:floor.getFlatList()) {
				totalFlats+=1;
			}
		}
		return totalFlats;
	}

	@Override
	public double getArea() {
		if(this.floorList.size()>0) {
			double totalArea=0;
			for(Floor floor:this.floorList) {
				totalArea+=(double)floor.getArea();
			}
			return totalArea;
		}
		return 0;
	}

	@Override
	public int getTotalWindows() {
		if(this.floorList.size()>0) {
			int totalWindows=0;
			for(Floor floor:this.floorList) {
				totalWindows+=(double)floor.getTotalWindows();
			}
			return totalWindows;
		}
		return 0;
	}
	
	
	
}

