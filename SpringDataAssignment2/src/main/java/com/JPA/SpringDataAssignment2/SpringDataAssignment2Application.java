package com.JPA.SpringDataAssignment2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataAssignment2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataAssignment2Application.class, args);
	}
	/* Spring Data JPA part 2 Exercise :
		jPQL:
			Employee class in entities package
			EmployeeRepository Interface in repositories package
		Ques 1 -> EmployeeRepository Interface in repositories package -> findAllEmployeeBySalaryGreaterThan()
				  in src -> test folder --> SpringDataAssignment2ApplicationTests -> testFindAllStudentsPartial()

		Ques 2 -> EmployeeRepository Interface in repositories package -> updateSalaryOfEmployeeLessThanAvg()
				  in src -> test folder --> SpringDataAssignment2ApplicationTests -> testUpdateSalaryOfEmployeeLessThanAvg()

		Ques 3 -> EmployeeRepository Interface in repositories package -> deleteEmployeeSalary()
				  in src -> test folder --> SpringDataAssignment2ApplicationTests -> testDeleteEmployeeSalary()

		Native Query:
		Ques 1 -> EmployeeRepository Interface in repositories package -> getAllEmployeeWhoseNameEndsWith()
				  in src -> test folder --> SpringDataAssignment2ApplicationTests -> testGetAllEmployeeWhoseNameEndsWith()

		Ques 2 -> EmployeeRepository Interface in repositories package -> deleteEmployeeHavingAgeGreaterThan()
				  in src -> test folder --> SpringDataAssignment2ApplicationTests -> testDeleteEmployeeHavingAgeGreaterThan()

		Inheritance Mapping:
		Ques 1 -> under InheritanceMappingSingleTable packages under entities package
				  in src -> test folder --> SpringDataAssignment2ApplicationTests -> testCreatePaymentWithCardSingleTable() and testCreatePaymentWithCheckSingleTable()

		Ques 2 -> under InheritanceMappingTablePerClass packages under entities package
				  in src -> test folder --> SpringDataAssignment2ApplicationTests -> testCreatePaymentWithCardTablePerClass() and testCreatePaymentWithCheckTablePerClass()

		Ques 3 -> under InheritanceMappingJoined packages under entities package
				  in src -> test folder --> SpringDataAssignment2ApplicationTests -> testCreatePaymentWithCardJoined() and testCreatePaymentWithCheckJoined()

		Component Mapping:
		Ques 1 -> under ComponentMapping packages under entities package
				  in src -> test folder --> SpringDataAssignment2ApplicationTests -> testCreateWithComponentMapping()
		*/
}
