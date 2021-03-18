package com.JPA.SpringDataAssignment3.entities.OneToManyUnidirectional;

import com.JPA.SpringDataAssignment3.entities.Address;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "author")
public class AuthorOneToManyUnidirectional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "author_name")
    private String name;

    @Embedded
    private Address address;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name="author_id")
    private Set<BookOneToManyUnidirectional> books;

    public Set<BookOneToManyUnidirectional> getBookSet() {
        return books;
    }

    public void setBookSet(Set<BookOneToManyUnidirectional> bookSet) {
        this.books = bookSet;
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

    public void addBookName(BookOneToManyUnidirectional book){
        if(book!=null){
            if(books==null){
                books=new HashSet<>();
            }
            books.add(book);
        }
    }
}
