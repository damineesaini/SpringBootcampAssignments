package com.JPA.SpringDataAssignment2.repositories.inheritanceMappingSIngleTable;

import com.JPA.SpringDataAssignment2.entities.inheritanceMappingSingleTable.PaymentSingleTable;
import org.springframework.data.repository.CrudRepository;

public interface PaymentSingleTableRepository extends CrudRepository<PaymentSingleTable,Integer> {
}
