package com.JPA.SpringDataAssignment2.entities.componentMapping;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class EmployeeComponentMapping {
    @Id
    private int id;
    @Column(name = "empname")
    private String name;
    @Embedded
    private Address address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
