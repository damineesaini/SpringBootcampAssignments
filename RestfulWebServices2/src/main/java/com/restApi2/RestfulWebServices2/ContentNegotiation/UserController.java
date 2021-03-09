package com.restApi2.RestfulWebServices2.ContentNegotiation;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ArrayList<User> retrieveAllUsers(){
        return userService.findAll();
    }

    @PostMapping("/users-create")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) throws UserNotFoundException {
        User newUser = userService.createUser(user);
        if (newUser == null)
            throw new UserNotFoundException("please do not provide id");
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users-delete/{id}")
    public void delete(@PathVariable Integer id) throws UserNotFoundException {
        User user = userService.deleteUserById(id);
        if(user == null)
            throw new UserNotFoundException("Incorrect id");
    }

    //HATEOAS
    @GetMapping("/user-hateoas/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) throws UserNotFoundException {
        User user = userService.findOneById(id);

        if(user==null)
            throw new UserNotFoundException("incorrect id");

        EntityModel<User> resource = EntityModel.of(user);

        WebMvcLinkBuilder linkTo =
                linkTo(methodOn(this.getClass()).retrieveAllUsers());

        resource.add(linkTo.withRel("all-users"));

        return resource;
    }

}
