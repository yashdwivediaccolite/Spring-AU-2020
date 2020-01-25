package main;

import java.util.ArrayList;
import java.util.List;

import models.Building;
import models.Flat;
import models.Floor;
import models.Room;

public class Main {
	public static void main(String []args) {
		Room r1=new Room("bedroom",3,500,2);
		Room r2=new Room("bathroom",3,250,0);
		Room r3=new Room("kitchen",3,300,1);
		Room r4=new Room("bedroom",2,400,2);
		List<Room> rList1=new ArrayList<>();
		rList1.add(r1);
		rList1.add(r2);
		rList1.add(r3);
		rList1.add(r4);
		Flat f1=new Flat(rList1,1,"2bhk","Yash");
		
		Room r5=new Room("bedroom",4,600,2);
		Room r6=new Room("bathroom",4,250,0);
		Room r7=new Room("kitchen",4,300,1);
		Room r8=new Room("bedroom",4,400,2);
		Room r9=new Room("bedroom",4,400,2);
		List<Room> rList2=new ArrayList<>();
		rList2.add(r5);
		rList2.add(r6);
		rList2.add(r7);
		rList2.add(r8);
		rList2.add(r9);
		Flat f2=new Flat(rList2,2,"3bhk","Akshat");
		
		
		List<Flat> flatList1=new ArrayList<>();
		flatList1.add(f1);
		flatList1.add(f2);
		Floor floor1=new Floor(flatList1,1);
		
		Room r10=new Room("bedroom",3,700,2);
		Room r11=new Room("bathroom",3,750,0);
		Room r12=new Room("kitchen",3,700,1);
		List<Room> rList3=new ArrayList<>();
		rList3.add(r10);
		rList3.add(r11); 
		rList3.add(r12);
		Flat f3=new Flat(rList3,3,"1bhk","Varun");
		
		Room r13=new Room("bedroom",4,600,2);
		Room r14=new Room("bathroom",4,500,0);
		Room r15=new Room("kitchen",4,500,1);
		Room r16=new Room("bedroom",4,400,3);
		Room r17=new Room("bedroom",4,400,3);
		List<Room> rList4=new ArrayList<>();
		rList4.add(r13);
		rList4.add(r14);
		rList4.add(r15);
		rList4.add(r16);
		rList4.add(r17);
		Flat f4=new Flat(rList4,4,"3bhk","Harsh");
		
		List<Flat> flatList2=new ArrayList<>();
		flatList2.add(f3);
		flatList2.add(f4);
		Floor floor2=new Floor(flatList2,2);
		
		List<Floor> b=new ArrayList<>();
		b.add(floor1);
		b.add(floor2);
		
		Building RegentGarden=new Building(b,2,"Regent Garden");
		
		
		System.out.println("<-->For the bulding Regent Garden<-->");
		System.out.println("The total areas of all rooms are:"+RegentGarden.getArea());
		System.out.println("The total windows in all rooms are:"+RegentGarden.getTotalWindows());
		System.out.println("It is a "+RegentGarden.getStoreys()+" storied building");
		System.out.println("It has "+RegentGarden.getFloorList().size()+" floors full of Flats");
		System.out.println("It has a total of "+RegentGarden.getTotalFlats()+" Flats");
		
		System.out.println("--------------------------------------------");
		
		for(Floor floor:RegentGarden.getFloorList()) {
			for(Flat flat:floor.getFlatList()) {
				System.out.println(flat.getDescription());
				System.out.println("---------------------------------------------------");
			}
		}
		
	}
}
