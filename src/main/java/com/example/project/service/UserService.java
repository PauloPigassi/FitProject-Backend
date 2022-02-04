package com.example.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.project.model.User;
import com.example.project.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> getUser() {
		return userRepository.findAll();
	}
	
	public ResponseEntity<User> getUserById(Integer id){
		 Optional<User> userService = userRepository.findById(id);
	        if(userService.isPresent())
	            return new ResponseEntity<User>(userService.get(), HttpStatus.OK);
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public ResponseEntity<User> updateUser(User user){
		Optional<User> oldUser = userRepository.findById(user.getUserId());
        if(oldUser.isPresent()){
            User userService = oldUser.get();
            userService.setName(user.getName());
            userService.setActive(user.getActive());
            userService.setAddress(user.getAddress());
            userService.setIdentity(user.getIdentity());
            userService.setPassword(user.getPassword());
            userService.setPhone(user.getPhone());
            userService.setUsername(user.getUsername());
            userRepository.save(userService);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<Object> deleteUser(Integer id){
		Optional<User> userService = userRepository.findById(id);
        if(userService.isPresent()){
            userRepository.delete(userService.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
