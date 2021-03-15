package com.JPA.SpringDataAssignment2.repositories;

import com.JPA.SpringDataAssignment2.entities.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

    @Query("from Employee")
    List<Employee> findAllEmployees();

    @Query("select emp.firstName,emp.lastName from Employee emp where emp.salary > (select AVG(salary) from Employee)")
    List<Object[]> findAllEmployeeBySalaryGreaterThan( Sort sort);

//    @Modifying
//    @Query("update Employee set salary =:salary where salary < (select avgSalary from (select avg(salary) from Employee) as t)")
//    void updateSalaryOfEmployeeLessThanAvg(@Param("salary") double salary);

//    @Modifying()
//    @Query("delete from Employee where salary IN (select dt.minSalary from ( select min(salary) as minSalary from Employee) as dt)")
//    void deleteEmployeeSalary();

    @Query(value = "select empId,empFirstName from employeeTable where empLastName like '%singh'", nativeQuery = true)
    List<Object[]> getAllEmployeeWhoseNameEndsWith();

    @Modifying
    @Query(value = "delete from employeeTable where empAge>:age", nativeQuery = true)
    void deleteEmployeeHavingAgeGreaterThan(@Param("age") int age);
}
