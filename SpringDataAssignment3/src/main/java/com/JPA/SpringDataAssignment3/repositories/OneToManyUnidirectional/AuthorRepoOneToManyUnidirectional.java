package com.JPA.SpringDataAssignment3.repositories.OneToManyUnidirectional;

import com.JPA.SpringDataAssignment3.entities.OneToManyUnidirectional.AuthorOneToManyUnidirectional;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepoOneToManyUnidirectional extends CrudRepository<AuthorOneToManyUnidirectional,Integer> {
}
