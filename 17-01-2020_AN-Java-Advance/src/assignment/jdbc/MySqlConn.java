package assignment.jdbc;
import java.util.ArrayList;
import java.sql.*;

/*
CREATE DEFINER=`root`@`localhost` PROCEDURE `join_procedure`()
BEGIN
	select * from employee inner join department on employee.department_id=department.dep_id; 
END
 */

public class MySqlConn {
	public static void main(String args[]){
		ArrayList<EmployeeDepartment>arr=new ArrayList<>();
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/assignment","root","123abyash");  
		String query="{CALL join_procedure()}";
		CallableStatement stmt=con.prepareCall(query);  
		ResultSet rs=stmt.executeQuery();  
		while(rs.next()) {
			EmployeeDepartment ed=new EmployeeDepartment(rs.getInt("emp_id"),rs.getString("emp_name"),rs.getString("job_name"),rs.getString("salary"),rs.getInt("dep_id"),rs.getString("dep_name"));
			arr.add(ed);
		} 
		for(EmployeeDepartment empdep:arr) {
			System.out.println(empdep);
		}
		con.close();  
		}catch(Exception e){ System.out.println(e.toString());}  
		}
}
