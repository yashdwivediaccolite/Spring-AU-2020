package com.example.demo;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.MediaType;


class DataStore{
	static List<User>arr=new ArrayList<>();
}


@Path("/apis")
public class RestApi {
	
	
	@GET
	@Produces("application/json")
	public List<User> getAllUsers() {
		return DataStore.arr;
	} 
	
	@GET()
	@Path("find/{name}")
	@Produces("application/json")
	public String postAllUsers(@PathParam("name")String name) {
		for(int i=0;i<DataStore.arr.size();i++) {
			if(DataStore.arr.get(i).name.equals(name)) {
				return name+" found";
			}
		}
		return "Not Found";
	} 
	
	@POST()
	@Produces("application/json")
	public String postUser(String name) {
		return name+" was successfully sent to the server";
	} 
	
	@PUT
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces("application/json")
	public String putUser(String name){
		User u=new User(name);
		DataStore.arr.add(u);
		return u.name+" added";
	}
	
	
	@DELETE
	@Path("/{index}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces("application/json")
	public String deleteUser(@PathParam("index")String index){
		int val=Integer.parseInt(index);
		User u=DataStore.arr.remove(val);
		return u.name+" with index "+ val +" deleted";
	}
	
}
