package com.JPA.SpringDataAssignment2.entities.InheritanceMappingTablePerClass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "card")
public class CreditCardTablePerClass extends PaymentTablePerClass{
    @Column(name = "cardNumber")
    private String creditCard;

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
}
