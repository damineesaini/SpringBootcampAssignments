package com.JPA.SpringDataAssignment2.entities.InheritanceMappingTablePerClass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bankCheck")
public class CheckTablePerClass extends PaymentTablePerClass{
    private String checkNumber;

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }
}
