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

    @Query("select avg(salary) from Employee")
    double findAverageSalary();

    @Modifying
    @Query("update Employee set salary =:salary where salary < :avgSalary")
    void updateSalaryOfEmployeeLessThanAvg(@Param("salary") double salary,@Param("avgSalary") double avgSalary);

    @Query("select min(salary) from Employee")
    double findMinimumSalary();

    @Modifying()
    @Query("delete from Employee where salary=:minSalary")
    void deleteEmployeeSalary(@Param("minSalary") double salary);

    @Query(value = "select empId,empFirstName from employeeTable where empLastName like '%singh'", nativeQuery = true)
    List<Object[]> getAllEmployeeWhoseNameEndsWith();

    @Modifying
    @Query(value = "delete from employeeTable where empAge>:age", nativeQuery = true)
    void deleteEmployeeHavingAgeGreaterThan(@Param("age") int age);
}
