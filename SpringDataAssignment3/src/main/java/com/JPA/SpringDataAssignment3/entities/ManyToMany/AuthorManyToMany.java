package com.JPA.SpringDataAssignment3.entities.ManyToMany;

import com.JPA.SpringDataAssignment3.entities.Address;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "author")
public class AuthorManyToMany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "author_name")
    private String name;

    @Embedded
    private Address address;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "authors_books",joinColumns = @JoinColumn(name = "author_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "book_id",referencedColumnName = "id"))
    private Set<BookManyToMany> books;

    public Set<BookManyToMany> getBooks() {
        return books;
    }

    public void setBooks(Set<BookManyToMany> books) {
        this.books = books;
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
