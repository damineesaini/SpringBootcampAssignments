package com.JPA.SpringDataAssignment3.entities.Ques3and4;

import com.JPA.SpringDataAssignment3.entities.Address;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "author_name")
    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "author",cascade = CascadeType.PERSIST)
    private List<Subject> subjects;

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

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void addSubjectName(Subject subject){
        if(subject!=null){
            if(subjects==null){
                subjects=new ArrayList<>();
            }
            subject.setAuthor(this);
            subjects.add(subject);
        }
    }
}
