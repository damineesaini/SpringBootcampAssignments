package com.restApi2.RestfulWebServices2.ContentNegotiation;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @ApiModelProperty(notes = "Fetch list of users")
    public ArrayList<User> retrieveAllUsers(){
        return userService.findAll();
    }

    @PostMapping
    @ApiModelProperty(notes = "create a new user")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) throws UserNotFoundException {
        User newUser = userService.createUser(user);
        if (newUser == null)
            throw new UserNotFoundException("please do not provide id");
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    @ApiModelProperty(notes = "delete an existing user")
    public void delete(@PathVariable Integer id) throws UserNotFoundException {
        User user = userService.deleteUserById(id);
        if(user == null)
            throw new UserNotFoundException("Incorrect id");
    }

    //HATEOAS implementation
    @GetMapping("/{id}")
    @ApiModelProperty(notes = "showing hateoas implementation")
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
