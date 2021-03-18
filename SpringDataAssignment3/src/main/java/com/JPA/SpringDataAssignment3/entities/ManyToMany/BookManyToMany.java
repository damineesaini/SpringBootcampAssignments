package com.JPA.SpringDataAssignment3.entities.ManyToMany;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "book_table")
public class BookManyToMany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "book_name")
    private String bookName;

    @ManyToMany(mappedBy = "books")
    private Set<AuthorManyToMany> authors;

    public Set<AuthorManyToMany> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorManyToMany> authors) {
        this.authors = authors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
