package com.JPA.SpringDataAssignment2.entities.inheritanceMappingJoined;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "bankCheckTable")
@PrimaryKeyJoinColumn(name = "id")
public class CheckJoinedStrategy extends PaymentJoined{

    private String checkNumber;

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }
}
