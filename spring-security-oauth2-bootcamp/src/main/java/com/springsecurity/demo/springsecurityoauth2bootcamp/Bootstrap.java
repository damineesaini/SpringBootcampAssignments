package com.springsecurity.demo.springsecurityoauth2bootcamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements ApplicationRunner {
    @Autowired
    UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(userRepository.count()<1){
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            UserEntity userEntity= new UserEntity();
            userEntity.setUsername("user1");
            userEntity.setPassword(passwordEncoder.encode("pass"));
            userEntity.setRole("ROLE_USER");

            UserEntity userEntity2= new UserEntity();
            userEntity2.setUsername("user2");
            userEntity2.setPassword(passwordEncoder.encode("pass"));
            userEntity2.setRole("ROLE_ADMIN");

            userRepository.save(userEntity);
            userRepository.save(userEntity2);
            System.out.println("Total users saved::"+userRepository.count());
        }
    }
}
