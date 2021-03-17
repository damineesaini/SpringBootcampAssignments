package com.springsecurity.demo.springsecurityoauth2bootcamp;

import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<UserEntity,Integer> {
    UserEntity findByUsername(String username);
}
