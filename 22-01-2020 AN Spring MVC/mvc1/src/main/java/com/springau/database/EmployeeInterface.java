package com.springau.database;

import java.util.List;

import com.springau.models.Employee;

public interface EmployeeInterface {
	public void create(Employee emp);
	public void delete(int a);
	public void update(Employee emp);
	public List<Employee> getEmployees();
	Employee getEmployeeById(int id);
}
