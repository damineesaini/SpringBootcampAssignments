package com.JPA.SpringDataAssignment2.repositories.inheritanceMappingTablePerClass;

import com.JPA.SpringDataAssignment2.entities.InheritanceMappingTablePerClass.PaymentTablePerClass;
import org.springframework.data.repository.CrudRepository;

public interface PaymentTablePerClassRepository extends CrudRepository<PaymentTablePerClass,Integer> {
}
