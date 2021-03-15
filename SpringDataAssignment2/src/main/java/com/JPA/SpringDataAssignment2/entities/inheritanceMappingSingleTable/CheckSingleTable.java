package com.JPA.SpringDataAssignment2.entities.inheritanceMappingSingleTable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ch")
public class CheckSingleTable extends PaymentSingleTable {
    @Column(name = "checkNumber")
    private String checkNumber;

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }
}
