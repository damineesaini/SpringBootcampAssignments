package com.JPA.SpringDataAssignment3.entities.OneToOne;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class BookOneToOne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bookName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "authorId")
    private AuthorOneToOne author;

    public AuthorOneToOne getAuthor() {
        return author;
    }

    public void setAuthor(AuthorOneToOne author) {
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
