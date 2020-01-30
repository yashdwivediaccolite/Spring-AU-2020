package testing;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;

import com.springau.database.EmployeeOperations;
import com.springau.models.Employee;
import com.springau.spring.MainController;

@RunWith(MockitoJUnitRunner.class)
public class TestClass {

	@InjectMocks
	MainController mainController=new MainController();
	
	@Mock
	EmployeeOperations empOp;
	
	@Test
	public void TestControllers() throws Exception {
		Employee emp1=new Employee();
		emp1.setId(1);
		emp1.setFname("Yash");
		emp1.setLname("Dwivedi");
		emp1.setNumber(1234567891);
		
		Employee emp2=new Employee();
		emp2.setId(2);
		emp2.setFname("Akshat");
		emp2.setLname("Nayak");
		emp2.setNumber(1234567891);
		
		List<Employee>l=new ArrayList<>();
		l.add(emp1);
		l.add(emp2);
		
		Mockito.when(empOp.getEmployees()).thenReturn(l);
		Assert.assertEquals(mainController.getEmployees().getViewName(),"showAll");
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setParameter("employee_id", "1");
		Mockito.when(empOp.getEmployeeById(1)).thenReturn(emp1);
		Assert.assertEquals(mainController.editEmployees(request).getViewName(),"editForm");
		
		MockHttpServletRequest request1 = new MockHttpServletRequest();
		request1.setParameter("employee_id", "2");
		Mockito.when(empOp.getEmployeeById(2)).thenReturn(emp2);
		Assert.assertEquals(mainController.deleteEmployees(request1),"index");
		
	}
	
}
