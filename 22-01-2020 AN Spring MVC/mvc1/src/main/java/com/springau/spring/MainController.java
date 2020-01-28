package com.springau.spring;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springau.database.EmployeeOperations;
import com.springau.models.Employee;


@Controller
public class MainController {
	
	@Autowired
	EmployeeOperations empOp;
	
	@RequestMapping("/")
	public String welcomeJSP() {
		return "index";
	}
	
	
	@RequestMapping(value="/saveEmployee",method=RequestMethod.POST)
	public String saveJSP(HttpServletRequest req) throws Exception{
		String id=req.getParameter("id");
		if(Integer.parseInt(id)<0) {
			throw new SQLException("error");
		}
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		String number=req.getParameter("number");
		Employee emp=new Employee(Integer.parseInt(id),fname,lname,Long.parseLong(number));
		empOp.create(emp);
		return "index";
	}
	
	@RequestMapping("/showAllEmployees")
	public ModelAndView getEmployees() {
		ModelAndView model=new ModelAndView();
		List<Employee>li=this.empOp.getEmployees();
		model.setViewName("showAll");
		model.addObject("employees", li);
		return model;
	}
	
	@RequestMapping("/editEmployees")
	public ModelAndView editEmployees(HttpServletRequest req) throws Exception{
		int id=Integer.parseInt(req.getParameter("employee_id"));
		Employee emp=this.empOp.getEmployeeById(id);
		ModelAndView model=new ModelAndView();
		model.setViewName("editForm");
		model.addObject("employee",emp);
		
		return model;
		
	}
	
	@RequestMapping("/updateEmployees")
	public String updateEmployees(HttpServletRequest req) {
		String id=req.getParameter("id");
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		String number=req.getParameter("number");
		Employee emp=new Employee(Integer.parseInt(id),fname,lname,Long.parseLong(number));
		this.empOp.update(emp);
		return "index";
	}
	
	@RequestMapping("/deleteEmployees")
	public String deleteEmployees(HttpServletRequest req) {
		int id=Integer.parseInt(req.getParameter("employee_id"));
		this.empOp.delete(id);
		return "index";
	}
	
	
	
}
