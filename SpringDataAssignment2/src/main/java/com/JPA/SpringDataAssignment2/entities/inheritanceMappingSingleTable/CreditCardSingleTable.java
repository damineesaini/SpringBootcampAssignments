package com.JPA.SpringDataAssignment2.entities.inheritanceMappingSingleTable;

import javax.persistence.*;

@Entity
@DiscriminatorValue("cc")
public class CreditCardSingleTable extends PaymentSingleTable {
    @Column(name = "cardNumber")
    private String creditCard;

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
}
