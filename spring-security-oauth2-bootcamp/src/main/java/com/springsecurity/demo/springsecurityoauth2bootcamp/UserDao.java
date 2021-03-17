package com.springsecurity.demo.springsecurityoauth2bootcamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDao {

    @Autowired
    UserRepository userRepository;

    public ApplicationUser loadUserByUserName(String username){
        UserEntity user  = userRepository.findByUsername(username);
        if(username != null){
            return new ApplicationUser(user.getUsername(), user.getPassword(), Arrays.asList(new GrantAuthorityImpl(user.getRole())));
        }else{
            throw new RuntimeException();
        }
    }
}
