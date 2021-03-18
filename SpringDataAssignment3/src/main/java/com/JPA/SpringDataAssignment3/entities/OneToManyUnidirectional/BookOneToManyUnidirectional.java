package com.JPA.SpringDataAssignment3.entities.OneToManyUnidirectional;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class BookOneToManyUnidirectional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "book_name")
    private String bookName;

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
