package com.JPA.SpringDataAssignment2.entities.inheritanceMappingJoined;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cardTable")
@PrimaryKeyJoinColumn(name = "id")
public class CreditCardJoinedStrategy extends PaymentJoined{
    @Column(name = "cardNumber")
    private String creditCard;

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
}
