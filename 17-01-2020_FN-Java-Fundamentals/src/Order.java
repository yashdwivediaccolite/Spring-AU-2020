import java.util.*;
public class Order {
	int o_id;
	String username;
	ArrayList<Product> arr=new ArrayList<>();
	
	Order(int o_id,String username,ArrayList<Product> arr){
		this.o_id=o_id;
		this.username=username;
		this.arr=arr;
	}
	
	Order(){
		
	}
}
