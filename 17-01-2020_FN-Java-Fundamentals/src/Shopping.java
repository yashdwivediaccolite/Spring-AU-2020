import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Shopping {
	
	void addToCart(ArrayList<Product>prods,HashMap<Product,Integer>cart) { // For adding a product to cart
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			int choice;
			System.out.println("Select items by choosing numbers");
			for(int i=0;i<prods.size();i++) {
				System.out.println(i+".Name:"+prods.get(i).p_name+" Price:"+prods.get(i).rate+" Quantity Remaining:"+prods.get(i).quantity);	
			}
			System.out.println("-1.Go Back");
			System.out.println("Enter your choice:");
			choice=sc.nextInt();
			if(choice==-1)
				break;
			if(prods.get(choice).quantity==0) {
				System.out.println("Out of Stock");
			}
			else {
				int quant=0;
				if(cart.containsKey(prods.get(choice))) {
					quant=cart.get(prods.get(choice));
				}
				quant++;
				cart.put(prods.get(choice),quant);
				Product temp= prods.get(choice);
				temp.quantity-=1;
				prods.set(choice, temp);
				System.out.println(prods.get(choice).p_name+" added to cart");
			}
		}
	}
	
	void removeFromCart(ArrayList<Product>prods,HashMap<Product,Integer>cart) {   //For removing a product from cart
		Scanner sc=new Scanner(System.in);
		if(cart.size()==0) {
			System.out.println("No items in cart to delete");
			return;
		}
		while(true) {
			HashMap<Integer,Product> delete=new HashMap<>();
			int index=0,choice;
			for(Product pd:cart.keySet()) {
				System.out.println(index+". Name:"+pd.p_name+" Quantity:"+cart.get(pd));
				delete.put(index,pd);
				index++;
			}
			System.out.println("-1.Go back");
			System.out.println("Enter your choice:");
			choice=sc.nextInt();
			if(choice==-1) {
				break;
			}
			if(delete.containsKey(choice)) {
				Product pd=delete.get(choice);
				int removedQuant=cart.get(pd);
				cart.remove(pd);
				int delIndex=0;
				Product temp=new Product();
				for(int i=0;i<prods.size();i++) {
					if(prods.get(i).p_id==pd.p_id) {
						temp=prods.get(i);
						temp.quantity+=removedQuant;
						delIndex=i;
						break;
					}
				}
				prods.set(delIndex, temp);
				
			}
		}
	}
	
	void showCart(HashMap<Product,Integer>cart) {	//For showing all items in a cart
		Scanner sc=new Scanner(System.in);
		if(cart.size()==0) {
			System.out.println("No items in cart");
			return;
		}
		while(true) {
		System.out.println("Press 1 to go Back");
			for(Product pd:cart.keySet()) {
				System.out.print("Id:"+pd.p_id+" Name:"+pd.p_name+" Quantity:"+cart.get(pd));
				int price=cart.get(pd)*pd.rate;
				System.out.println(" Price:"+price);
			}
			if(sc.nextInt()==1)
				break;
			}
		}
		
	Order placeOrder(HashMap<Product,Integer>cart) {  // For placing order or cancelling
		
		if(cart.size()==0) {
			System.out.println("Nothing in cart to buy");
			return null;
		}
		Scanner sc=new Scanner(System.in);
		int total=0;
		ArrayList<Product> p=new ArrayList<>();
		for(Product pd:cart.keySet()) {
			total+=cart.get(pd)*pd.rate;
			p.add(pd);
		}
		System.out.println("Your total is:"+total);
		System.out.println("1.Proceed to Pay");
		System.out.println("2.Cancel Payment");
		System.out.println("Enter your choice:");
		int choice=sc.nextInt();
		if(choice==1) {
			System.out.println("Enter your name");
			String name=sc.nextLine();
			sc.nextLine();
			System.out.println("Enter your transaction number");
			int id=sc.nextInt();
			System.out.println("Thanks for buying");
			Order ord=new Order(id,name,p);
			return ord;
		}
		else{
			return null;
		}
	}
	public static void main(String []args) {
		Scanner sc=new Scanner(System.in);
		Shopping shp=new Shopping();
		ArrayList<Order>orderHistory=new ArrayList<>();
		ArrayList<Product>prods=new ArrayList<>();
		prods.add(new Product(1,"A",10,100));
		prods.add(new Product(2,"B",6,90));
		prods.add(new Product(3,"C",8,80));
		prods.add(new Product(4,"D",11,60));
		HashMap<Product,Integer>cart=new HashMap<>();
		boolean flag=true;
		while(flag==true) {
			System.out.println("1.Show Products and add them to cart");
			System.out.println("2.Remove a product from cart");
			System.out.println("3.Show all Products in cart");
			System.out.println("4.Place Order");
			System.out.println("5.Exit");
			System.out.println("Enter your choice:");
			int choice=sc.nextInt();
			switch(choice) {
				case 1:shp.addToCart(prods,cart);
						break;
				case 2:shp.removeFromCart(prods,cart);	
						break;
				case 3:shp.showCart(cart);
						break;
				case 4:Order ord=shp.placeOrder(cart);
						if(ord!=null)
							orderHistory.add(ord);
						break;
				case 5:	flag=false;
						break;
				default:System.out.println("Enter a valid choice");
						break;
			}
		}
	}
}
