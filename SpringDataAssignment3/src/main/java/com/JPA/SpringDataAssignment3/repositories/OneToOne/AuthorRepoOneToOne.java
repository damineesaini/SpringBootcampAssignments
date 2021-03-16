package com.JPA.SpringDataAssignment3.repositories.OneToOne;

import com.JPA.SpringDataAssignment3.entities.OneToOne.AuthorOneToOne;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepoOneToOne extends CrudRepository<AuthorOneToOne , Integer> {
}
