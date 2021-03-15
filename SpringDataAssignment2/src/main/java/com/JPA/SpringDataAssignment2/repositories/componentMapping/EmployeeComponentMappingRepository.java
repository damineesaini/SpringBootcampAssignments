package com.JPA.SpringDataAssignment2.repositories.componentMapping;

import com.JPA.SpringDataAssignment2.entities.componentMapping.EmployeeComponentMapping;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeComponentMappingRepository extends CrudRepository<EmployeeComponentMapping, Integer> {
}
