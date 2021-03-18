package com.JPA.SpringDataAssignment3.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
    @Column(name = "street_number")
    private String  streetNumber;
    private String location;
    private String State;

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }
}
