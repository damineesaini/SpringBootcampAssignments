package com.JPA.SpringDataAssignment2;

import com.JPA.SpringDataAssignment2.entities.InheritanceMappingTablePerClass.CheckTablePerClass;
import com.JPA.SpringDataAssignment2.entities.InheritanceMappingTablePerClass.CreditCardTablePerClass;
import com.JPA.SpringDataAssignment2.entities.componentMapping.Address;
import com.JPA.SpringDataAssignment2.entities.componentMapping.EmployeeComponentMapping;
import com.JPA.SpringDataAssignment2.entities.inheritanceMappingJoined.CheckJoinedStrategy;
import com.JPA.SpringDataAssignment2.entities.inheritanceMappingJoined.CreditCardJoinedStrategy;
import com.JPA.SpringDataAssignment2.entities.inheritanceMappingSingleTable.CheckSingleTable;
import com.JPA.SpringDataAssignment2.entities.inheritanceMappingSingleTable.CreditCardSingleTable;
import com.JPA.SpringDataAssignment2.entities.Employee;
import com.JPA.SpringDataAssignment2.repositories.EmployeeRepository;
import com.JPA.SpringDataAssignment2.repositories.componentMapping.EmployeeComponentMappingRepository;
import com.JPA.SpringDataAssignment2.repositories.inheritanceMappingSIngleTable.PaymentSingleTableRepository;
import com.JPA.SpringDataAssignment2.repositories.inheritanceMappingJoined.PaymentJoinedRepository;
import com.JPA.SpringDataAssignment2.repositories.inheritanceMappingTablePerClass.PaymentTablePerClassRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class SpringDataAssignment2ApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	PaymentSingleTableRepository paymentSingleTableRepository;

	@Autowired
	PaymentJoinedRepository paymentJoinedRepository;

	@Autowired
	PaymentTablePerClassRepository paymentTablePerClassRepository;

	@Autowired
	EmployeeComponentMappingRepository employeeComponentMappingRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testEmployeeCreate(){
		Employee employee = new Employee();
		employee.setFirstName("amulya");
		employee.setLastName("singh");
		employee.setSalary(67000);
		employee.setAge(23);
		employeeRepository.save(employee);

		Employee employee2 = new Employee();
		employee2.setFirstName("sakshi");
		employee2.setLastName("drall");
		employee2.setSalary(70000);
		employee2.setAge(22);
		employeeRepository.save(employee2);

		Employee employee3 = new Employee();
		employee3.setFirstName("daminee");
		employee3.setLastName("saini");
		employee3.setSalary(78000);
		employee3.setAge(22);
		employeeRepository.save(employee3);
	}

	@Test
	public void testFindAllEmployees(){
		System.out.println(employeeRepository.findAllEmployees());
	}

	@Test
	public void testFindAllStudentsPartial(){
		Sort sort = Sort.by("age").ascending().and(Sort.by("salary").descending());
		List<Object[]> partialData = employeeRepository.findAllEmployeeBySalaryGreaterThan(sort);
		for (Object[] objects : partialData) {
			System.out.println(objects[0]+ " "+objects[1]);
		}
 	}

//	@Test
//	@Transactional
//	//@Rollback(value = true)
//	public void testUpdateSalaryOfEmployeeLessThanAvg(){
//		double salary = 6800;
//		employeeRepository.updateSalaryOfEmployeeLessThanAvg(salary);
//	}
//
//	@Test
//	@Transactional
////	@Rollback(value = false)
//	public void testDeleteEmployeeSalary(){
//		employeeRepository.deleteEmployeeSalary();
//	}

	@Test
	public void testGetAllEmployeeWhoseNameEndsWith(){
		List<Object[]> empData = employeeRepository.getAllEmployeeWhoseNameEndsWith();
		for(Object[] obj: empData){
			System.out.println(obj[0]+" "+obj[1]);
		}
	}

	@Test
	@Transactional
	@Rollback(value = false)
	public void testDeleteEmployeeHavingAgeGreaterThan(){
		employeeRepository.deleteEmployeeHavingAgeGreaterThan(45);
	}

	@Test
	public void testCreatePaymentWithCardSingleTable() {
		CreditCardSingleTable cc = new CreditCardSingleTable();
		cc.setId(1);
		cc.setAmount(5000);
		cc.setCreditCard("20210301");
		paymentSingleTableRepository.save(cc);
	}

	@Test
	public void testCreatePaymentWithCheckSingleTable(){
		CheckSingleTable checkSingleTable = new CheckSingleTable();
		checkSingleTable.setId(2);
		checkSingleTable.setAmount(6000);
		checkSingleTable.setCheckNumber("20210302");
		paymentSingleTableRepository.save(checkSingleTable);
	}

	@Test
	public void testCreatePaymentWithCardTablePerClass() {
		CreditCardTablePerClass creditCardTablePerClass = new CreditCardTablePerClass();
		creditCardTablePerClass .setId(3);
		creditCardTablePerClass .setAmount(5000);
		creditCardTablePerClass .setCreditCard("20210303");
		paymentTablePerClassRepository.save(creditCardTablePerClass );
	}

	@Test
	public void testCreatePaymentWithCheckTablePerClass(){
		CheckTablePerClass checkTablePerClass = new CheckTablePerClass();
		checkTablePerClass.setId(4);
		checkTablePerClass.setAmount(6000);
		checkTablePerClass.setCheckNumber("20210304");
		paymentTablePerClassRepository.save(checkTablePerClass);
	}

	@Test
	public void testCreatePaymentWithCardJoined() {
		CreditCardJoinedStrategy creditCardJoinedStrategy = new CreditCardJoinedStrategy();
		creditCardJoinedStrategy.setId(5);
		creditCardJoinedStrategy.setAmount(5000);
		creditCardJoinedStrategy.setCreditCard("20210305");
		paymentJoinedRepository.save(creditCardJoinedStrategy);
	}

	@Test
	public void testCreatePaymentWithCheckJoined(){
		CheckJoinedStrategy checkJoinedStrategy = new CheckJoinedStrategy();
		checkJoinedStrategy.setId(6);
		checkJoinedStrategy.setAmount(6000);
		checkJoinedStrategy.setCheckNumber("20210306");
		paymentJoinedRepository.save(checkJoinedStrategy);
	}

	@Test
	public void testCreateWithComponentMapping(){
		EmployeeComponentMapping employeeComponentMapping = new EmployeeComponentMapping();
		employeeComponentMapping.setId(1);
		employeeComponentMapping.setName("Daminee");
		Address address = new Address();
		address.setStreetAddress("street no 123");
		address.setCity("lucknow");
		address.setState("up");
		address.setCountry("India");
		address.setZipcode("110041");
		employeeComponentMapping.setAddress(address);
		employeeComponentMappingRepository.save(employeeComponentMapping);
	}

}
