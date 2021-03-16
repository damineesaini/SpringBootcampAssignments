package com.JPA.SpringDataAssignment3.entities.OneToMany;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class BookManyToOne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bookName;

    @ManyToOne
    @JoinColumn(name="authorId")
    private AuthorOneToMany author;

    public AuthorOneToMany getAuthor() {
        return author;
    }

    public void setAuthor(AuthorOneToMany author) {
        this.author = author;
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
