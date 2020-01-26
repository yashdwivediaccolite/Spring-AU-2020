package com.hibernate.main;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.models.Address;
import com.hibernate.models.Customer;
import com.hibernate.models.Item;
import com.hibernate.models.Seller;
import com.hibernate.models.ShoppingCart;


public class HibernateMain {
	
	public static void main(String []args) {
		
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();

		try {
			System.out.println("Creating ----------------------------");
			session.beginTransaction();
			Address addr1=new Address();
			Address addr2=new Address();
			Customer cust1=new Customer("Yash",21);
			cust1.setMainAddress(addr1);
			cust1.setMainAddress(addr2);
			Seller seller=new Seller(1,"Akshat",21);
			Item item1=new Item(1,"Laptop",10,65000);
			Item item2=new Item(2,"Game",11,60000);
			List<Item>l=new ArrayList<>();
			l.add(item1);
			l.add(item2);
			seller.setItems(l);
			ShoppingCart shoppingCart=new ShoppingCart(1);
			shoppingCart.setItems(l);
			session.save(cust1);
			session.save(seller);
			session.save(item1);
			session.save(item2);
			session.save(shoppingCart);
			session.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		try {
			System.out.println("Reading --------------------------");
			String hql="FROM Customer";
			Query query = session.createQuery(hql,Customer.class);							//Using HQL		
			List<Customer> c1=query.getResultList();
			for(Customer c:c1) {
				System.out.println(c);
			}

			
			List<Seller>li =session.createNamedQuery("seller.get").getResultList();	    //Using Native Named Queries
			for(Seller s:li) {
				System.out.println(s);
			}
			
		
			TypedQuery q = session.getNamedQuery("listItems"); 								//Using Named Queries
			List<Item> l=q.getResultList();
			for(Item item:l) {
				System.out.println(item);
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		try {
			System.out.println("Updating --------------------------");
			session.beginTransaction();
			Item It1=session.get(Item.class, 2);
			It1.setPrice(70000);
			It1.setQuantity(20);
			session.getTransaction().commit();
			System.out.println("Successfully updated");
		}
		catch(Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		try {
			System.out.println("Deleting --------------------------");
			session.beginTransaction();
			Customer I1=session.get(Customer.class, 0);
			session.delete(I1);
			session.getTransaction().commit();
			System.out.println("Successfully deleted");
		}
		catch(Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		
		session.close();
		
	}
	
}
