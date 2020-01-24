package com.assignment.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class EmployeeService {
	public List<Employee> getAllEmployees(){
		List<Employee> li=new ArrayList<>();
		li.add(new Employee(1,"Yash","Dwivedi",21));
		li.add(new Employee(2,"Akshat","Nayak",21));
		li.add(new Employee(3,"Manjeet","Singh",21));
		li.add(new Employee(4,"Varun","Nambiar",21));
		li.add(new Employee(5,"Siddhant","Bhusan",21));
		return li;
	}
}
