package com.example.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.project.model.User;
import com.example.project.repository.UserRepository;


@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/listUsers")
	public List getUsers(){
		return (List) userRepository.findAll(); 
	}
}

