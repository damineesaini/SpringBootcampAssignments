package com.SpringData.SpringDataAssignment1.repositories;

import com.SpringData.SpringDataAssignment1.entities.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Integer> {
    List<Employee> findByName(String name);
    List<Employee> findByNameLike(String name);
    List<Employee> findByAgeBetween(int age1,int age2);
}

