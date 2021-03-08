package com.rest.RestfulWebService1;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;

@Component
public class EmployeeService {

    private static ArrayList<Employee> employees = new ArrayList<>();

    private static int employeeCount = 2;

    static {
        employees.add(new Employee(1,"Parth",23));
        employees.add(new Employee(2,"Megha",22));
    }

    public ArrayList<Employee> findAll(){
        return employees;
    }

    public Employee findOneById(Integer id){
        for (Employee employee:employees) {
                if(id.equals(employee.getId()))
                    return employee;
        }
        return null;
    }

    public Employee createNewEmployee(Employee employee){
        if(employee.getId()==null){
            employee.setId(++employeeCount);
        }
        else
            return null;
        employees.add(employee);
        return employee;
    }

    public Employee updateEmployeeDetails(Employee employee){
        for(Employee employee1:employees)
        {
            if(employee1.getId().equals(employee.getId()))
            {
                employee1.setName(employee.getName());
                employee1.setAge(employee.getAge());
                return employee1;
            }
        }
        return null;
    }

    public Employee deleteById(Integer id){
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()){
            Employee employee = iterator.next();
            if(employee.getId().equals(id)){
                iterator.remove();
                return employee;
            }
        }
        return null;
    }
}
