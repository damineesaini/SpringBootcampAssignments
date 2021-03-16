package com.JPA.SpringDataAssignment3.repositories.OneToMany;

import com.JPA.SpringDataAssignment3.entities.OneToMany.AuthorOneToMany;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepoOneToMany extends CrudRepository<AuthorOneToMany,Integer> {
}
