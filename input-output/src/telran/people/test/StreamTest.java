package telran.people.test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import telran.people.Employee;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StreamTest {

	
	@Test
	@Order(1)
	void writeEmployee() throws Exception {
		EmployeeTest empl = new EmployeeTest(123, "Vasya", "developer", 10000);
		empl.employee = empl;
		try(ObjectOutputStream output = new ObjectOutputStream(
				new FileOutputStream("employees.data"))){
			output.writeObject(empl);
		}
	}
	@Test 
	@Order(2)
	void readEmployee() throws Exception {
		EmployeeTest empl = null;
		EmployeeTest expected = new EmployeeTest(123, "Vasya", "developer", 10000);
		try(ObjectInputStream input = new ObjectInputStream(new FileInputStream("employees.data"))){
			empl = (EmployeeTest) input.readObject();
		}
		assertEquals(expected, empl.employee);
	}

}
