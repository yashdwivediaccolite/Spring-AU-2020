package assignment.annotation;
import java.lang.reflect.Method;

import assignment.annotation.*;

public class AnnotationTestor {
	public static void main(String []args) throws Exception{
		Manager1 mg1=new Manager1();  
		Class<? extends Manager1> m1=mg1.getClass();  
		  
		ManagerClassAnnotation manno1=(ManagerClassAnnotation)m1.getAnnotation(ManagerClassAnnotation.class);  
		System.out.println("Manager Id is:"+manno1.managerId()+" and Experience is: "+manno1.experience());
		
		
		Manager2 mg2=new Manager2();  
		Class<? extends Manager2> m2=mg2.getClass();  
		  
		ManagerClassAnnotation manno2=(ManagerClassAnnotation)m2.getAnnotation(ManagerClassAnnotation.class);  
		System.out.println("Manager Id is:"+manno2.managerId()+" and Experience is: "+manno2.experience());
		
		
		Book b=new Book();  
		Method m=b.getClass().getMethod("getBooks");  
		  
		BookMethodAnnotation bma=m.getAnnotation(BookMethodAnnotation.class);  
		System.out.println("Owner is:"+bma.owner()+" and Version is:"+bma.version()+" and Publisher is:"+bma.publisher());  
		
		BookDefault bd=new BookDefault();  
		Method md=bd.getClass().getMethod("getBooks");  
		  
		BookMethodAnnotation bmad=md.getAnnotation(BookMethodAnnotation.class);  
		System.out.println("Owner is:"+bmad.owner()+" and Version is:"+bmad.version()+" and Publisher is:"+bmad.publisher());  
		 
		 
	}
}
