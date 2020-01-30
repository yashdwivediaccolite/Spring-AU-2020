package com.springau.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.springau.models.Employee;

public class EmployeeOperations implements EmployeeInterface{
	private JdbcTemplate jdbcTemplate;
	
	public EmployeeOperations(DataSource dataSource) {
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
	
	public EmployeeOperations() {
	}

	@Override()
	public void update(Employee emp) {
		String sqlQuery="UPDATE employee set fname=?,lname=?,number=? where idemployee=?";
		jdbcTemplate.update(sqlQuery,emp.getFname(),emp.getLname(),emp.getNumber(),emp.getId());
	}
	
	@Override()
	public void delete(int id) {
		String sqlQuery="DELETE from  employee where idemployee=?";
		jdbcTemplate.update(sqlQuery,id);
	}
	
	@Override
	public void create(Employee emp) {
		String sqlQuery="insert into employee (idemployee,fname,lname,number) values(?,?,?,?)";
		jdbcTemplate.update(sqlQuery,emp.getId(),emp.getFname(),emp.getLname(),emp.getNumber());
	}

	@Override()
	public Employee getEmployeeById(int id) {
	    String sql = "SELECT * FROM employee WHERE idemployee=" + id;
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Employee>() {
	 
	        @Override
	        public Employee extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Employee emp= new Employee();
	                emp.setId(rs.getInt("idemployee"));
	                emp.setFname(rs.getString("fname"));
	                emp.setLname(rs.getString("lname"));
	                emp.setNumber(rs.getLong("number"));
	                return emp;
	            }
	 
	            return null;
	        }
	 
	    });
	}

	
	@Override()
	public List<Employee> getEmployees(){
		String sqlQuery="SELECT * from employee";
	    List<Employee> list = jdbcTemplate.query(sqlQuery, new RowMapper<Employee>() {
	    	 
	        @Override
	        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Employee emp = new Employee();
	 
	            emp.setId(rs.getInt("idemployee"));
	            emp.setFname(rs.getString("fname"));
	            emp.setLname(rs.getString("lname"));
	            emp.setNumber(Long.parseLong(rs.getString("number")));
	 
	            return emp;
	        }
	 
	    });
	 
	    return list;
	}
}
