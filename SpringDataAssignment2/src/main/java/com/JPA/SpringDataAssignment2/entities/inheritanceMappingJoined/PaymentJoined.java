package com.JPA.SpringDataAssignment2.entities.inheritanceMappingJoined;

import javax.persistence.*;

@Entity
@Table(name = "paymentTable")
@Inheritance(strategy = InheritanceType.JOINED)
public class PaymentJoined {
    @Id
    private int id;
    private double amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
