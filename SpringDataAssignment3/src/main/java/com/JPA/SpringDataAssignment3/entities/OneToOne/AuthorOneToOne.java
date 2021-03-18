package com.JPA.SpringDataAssignment3.entities.OneToOne;

import com.JPA.SpringDataAssignment3.entities.Address;


import javax.persistence.*;

@Entity
@Table(name = "author")
public class AuthorOneToOne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "author_name")
    private String name;

    @Embedded
    private Address address;

    @OneToOne(mappedBy = "author",cascade = CascadeType.ALL)
    private BookOneToOne book;


    public BookOneToOne getBook() {
        return book;
    }

    public void setBook(BookOneToOne book) {
        this.book = book;
    }

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
