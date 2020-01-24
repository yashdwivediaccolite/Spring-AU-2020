package com.assignment.spring.SpringAssignment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.assignment.config.AppConfig;
import com.assignment.models.Employee;
import com.assignment.models.EmployeeService;
import com.assignment.models.Point;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    	
    	EmployeeService empService=context.getBean(EmployeeService.class);
    	Employee emp=(Employee)context.getBean("EmployeeMap");
    	
    	empService.getAllEmployees();
    	
    	System.out.println("The injected map is:"+emp.getMap());
    	
    	ApplicationContext pointContext = new AnnotationConfigApplicationContext(AppConfig.class);
    	
    	Point p=(Point) pointContext.getBean("point");
    	System.out.println("Point class x value is:"+p.getX()+" and y value:"+p.getY());
    	
    }
}
