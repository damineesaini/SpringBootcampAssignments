package com.SpringData.SpringDataAssignment1;

import com.SpringData.SpringDataAssignment1.entities.Employee;
import com.SpringData.SpringDataAssignment1.repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringDataAssignment1ApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	void contextLoads() {
	}

	//Ques 3
	@Test
	public void testCreateEmployee(){
		Employee employee = new Employee();
		employee.setName("Aadarsh");
		employee.setAge(30);
		employee.setLocation("Mumbai");
		employeeRepository.save(employee);
		Employee employee2 = new Employee();
		employee2.setName("Agastya");
		employee2.setAge(29);
		employee2.setLocation("Faridabad");
		employeeRepository.save(employee2);
	}

	//Ques 4
	@Test
	public void testUpdateEmployee(){
		Employee employee = employeeRepository.findById(2).get();
		employee.setLocation("London");
		employeeRepository.save(employee);
		System.out.println("=============================================================================");
		System.out.println("Name  \t\t  Location");
		System.out.println(employee.getName()+" \t  " +employee.getLocation());
	}

	//Ques 5
	@Test
	public void testDeleteEmployeeById(){
		employeeRepository.deleteById(1);
	}

	//Ques 6
	@Test
	public void testReadEmployeeById(){
		Employee employee = employeeRepository.findById(2).get();
		assertNotNull(employee);
		assertEquals("Agastya",employee.getName());
		System.out.println("=============================================================================");
		System.out.println("Name  \t\t  Location");
		System.out.println(employee.getName()+" \t  " +employee.getLocation());
	}

	//Ques 7
	@Test
	public void testCountEmployees(){
		System.out.println("Total Records in Employee Table ============>"+employeeRepository.count());
	}

	//Ques 8
	@Test
	public void testFindAllPagingAndSortingOnEmployee(){
		Pageable pageable = PageRequest.of(0, 2, Sort.by(Sort.Order.asc("age")));
		Page<Employee> results = employeeRepository.findAll(pageable);
		System.out.println("=============================================================================");
		System.out.println("Name  \t\t  Age");
		results.forEach(result->System.out.println(result.getName() + " \t  "+result.getAge()));
	}

	//Ques 9
	@Test
	public void testFindByNameOfEmployee(){
		List<Employee> employees = employeeRepository.findByName("Agastya");
		System.out.println("=============================================================================");
		System.out.println("Name  \t\t  Location");
		employees.forEach(employee -> System.out.println(employee.getName()+" \t  " +employee.getLocation()));
	}

	//Ques 10
	@Test
	public void testFindByNameThatStartsWithAOfEmployee(){
		List<Employee> employees = employeeRepository.findByNameLike("A%");
		System.out.println("=============================================================================");
		System.out.println("Name  \t\t  Location");
		employees.forEach(employee -> System.out.println(employee.getName()+" \t  " +employee.getLocation()));
	}

	//Ques 11
	@Test
	public void testFindByAgeBetween28And32ofEmployee(){
		List<Employee> employees = employeeRepository.findByAgeBetween(28,32);
		System.out.println("=============================================================================");
		System.out.println("Name  \t\t  Age");
		employees.forEach(employee -> System.out.println(employee.getName()+" \t  " +employee.getAge()));
	}
}
