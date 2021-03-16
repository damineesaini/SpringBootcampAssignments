package com.JPA.SpringDataAssignment3.repositories.ManyToMany;

import com.JPA.SpringDataAssignment3.entities.ManyToMany.AuthorManyToMany;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepoManyToMany extends CrudRepository<AuthorManyToMany,Integer> {
}
