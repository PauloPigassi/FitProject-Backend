package com.example.project.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.User;
import com.example.project.repository.UserRepository;
import com.example.project.service.UserService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	
	
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> Get() {
        return userService.getUser();
    }
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> GetById(@PathVariable(value = "id") int id)
    {
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/user", method =  RequestMethod.POST)
    public User Post(@Valid @RequestBody User user)
    {
//    	user.setActive(true);
//    	user.setAddress("Street 123");
//    	user.setIdentity("Id 123");
//    	user.setName("Paulo");
//    	user.setPassword("123");
//    	user.setPhone("11 99999999");
//    	user.setUsername("Pigassi");
        return userService.createUser(user);
    }

    @RequestMapping(value = "/user/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<User> Put(@PathVariable(value = "id") int id, @Valid @RequestBody User newUser)
    {
//    	newUser.setActive(true);
//    	newUser.setAddress("Street 123");
//    	newUser.setIdentity("Id 123");
//    	newUser.setName("Paulo Pigassi");
//    	newUser.setPassword("123");
//    	newUser.setPhone("11 99999999");
//    	newUser.setUsername("Pigassi");
        
    	return userService.updateUser(newUser);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") int id)
    {
    	return userService.deleteUser(id);
    }
}

