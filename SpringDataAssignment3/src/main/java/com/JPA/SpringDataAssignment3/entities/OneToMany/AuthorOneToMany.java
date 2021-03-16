package com.JPA.SpringDataAssignment3.entities.OneToMany;

import com.JPA.SpringDataAssignment3.entities.Address;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="author")
public class AuthorOneToMany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "authorName")
    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "author",cascade =CascadeType.ALL)
    private Set<BookManyToOne> bookSet;

    public Set<BookManyToOne> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<BookManyToOne> bookSet) {
        this.bookSet = bookSet;
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

    public void addBookName(BookManyToOne book){
        if(book!=null){
            if(bookSet==null){
                bookSet=new HashSet<>();
            }
            book.setAuthor(this);
            bookSet.add(book);
        }
    }
}
