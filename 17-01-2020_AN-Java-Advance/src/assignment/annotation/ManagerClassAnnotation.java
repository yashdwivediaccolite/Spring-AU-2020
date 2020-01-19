package assignment.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.TYPE) 
public @interface ManagerClassAnnotation {
	String managerId() default "Not Alloted";
	int experience() default 0;
}

@ManagerClassAnnotation(managerId="ABC123",experience=12)
class Manager1{	
	private String name;
	private String employee_id;
	private int age;
}

@ManagerClassAnnotation
class Manager2{
	private String name;
	private String employee_id;
	private int age;
}