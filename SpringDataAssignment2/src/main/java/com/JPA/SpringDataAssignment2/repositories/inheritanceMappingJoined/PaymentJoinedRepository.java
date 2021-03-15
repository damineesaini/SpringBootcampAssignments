package com.JPA.SpringDataAssignment2.repositories.inheritanceMappingJoined;

import com.JPA.SpringDataAssignment2.entities.inheritanceMappingJoined.PaymentJoined;
import org.springframework.data.repository.CrudRepository;

public interface PaymentJoinedRepository extends CrudRepository<PaymentJoined,Integer> {
}
