package assignment.jdbc;

public class EmployeeDepartment {
	private int employee_id;
	private String employee_name;;
	private String job_name;
	private String salary;
	private int department_id;
	private String department;
	
	EmployeeDepartment(int employee_id,String employee_name,String job_name,String salary,int department_id,String department){
		this.employee_id=employee_id;
		this.employee_name=employee_name;
		this.job_name=job_name;
		this.salary=salary;
		this.department_id=department_id;
		this.department=department;
	}
	
	EmployeeDepartment(){
		
	}
	
	void set_emp_id(int val) {
		this.employee_id=val;
	}
	
	int get_emp_id() {
		return this.employee_id;
	}
	
	void set_emp_name(String val) {
		this.employee_name=val;
	}
	
	String get_emp_name() {
		return this.employee_name;
	}
	
	void set_job_name(String val) {
		this.job_name=val;
	}
	
	String get_job_name() {
		return this.job_name;
	}
	
	void set_salary(String val) {
		this.salary=val;
	}
	
	String get_salary() {
		return this.salary;
	}
	
	void set_dep_id(int val) {
		this.department_id=val;
	}
	
	int get_dep_id() {
		return this.department_id;
	}
	
	void set_department(String val) {
		this.department=val;
	}
	
	String get_department() {
		return this.department;
	}
	
	@Override
	public String toString() {
		return "Employee id:"+this.employee_id+" Employee Name:"+this.employee_name+" Job Name:"+this.job_name+" Employee Salary:"+this.salary+" Department id:"+this.department_id+" Department:"+this.department;
	}
	
}
