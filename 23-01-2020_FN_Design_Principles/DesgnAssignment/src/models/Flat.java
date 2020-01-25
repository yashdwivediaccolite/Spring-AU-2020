package models;
import java.util.ArrayList;
import java.util.List; 

public class Flat implements CommonFeatures{
	List<Room> roomList=new ArrayList<>();
	private int flatNumber;
	private String type;
	private String owner;
	
		
	
	public Flat(List<Room> roomList, int flatNumber, String type, String owner) {

		this.roomList = roomList;
		this.flatNumber = flatNumber;
		this.type = type;
		this.owner = owner;
	}

	public List<Room> getRoomList() {
		return roomList;
	}

	public void addRoomList(Room room) {
		this.roomList.add(room);
	}

	public int getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(int flatNumber) {
		this.flatNumber = flatNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getDescription() {
		return "Flat Number:"+this.flatNumber+" Flat type:"+this.type+" Total Rooms:"+this.roomList.size()+" Owner:"+this.owner;
	}

	@Override
	public double getArea() {
		if(this.roomList.size()>0) {
			double totalArea=0;
			for(Room room:this.roomList) {
				totalArea+=(double)room.getArea();
			}
			return totalArea;
		}
		return 0;
	}

	@Override
	public int getTotalWindows() {
		if(this.roomList.size()>0) {
			int totalWindows=0;
			for(Room room:this.roomList) {
				totalWindows+=(double)room.getTotalWindows();
			}
			return totalWindows;
		}
		return 0;
	}
	
	
	
}

