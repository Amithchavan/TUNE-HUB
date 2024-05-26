package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Users;
import com.example.demo.service.Userservice;

import jakarta.servlet.http.HttpSession;


@Controller
public class Usercontroller {
	@Autowired
	Userservice service;
	@PostMapping("/register")
	public String addUsers(@ModelAttribute Users user) {
		boolean userstatus=service.emailExists(user.getEmail());
		if(userstatus==false) {
		
		service.adduser(user);
		System.out.print("added");
	
		}
		else {
			System.out.print("already exists email");
		}
		return "login";
		
	}
	@PostMapping("/validate")
	public String validate(@RequestParam("email")String email, @RequestParam("password") String password,HttpSession session) {
		if(service.validateuser(email,password)==true) {
			String role=service.getrole(email);
			session.setAttribute("email", email);
				if(role.equals("admin")) {
					return "adminhome";
				}
				else {
					return "customerhome";
				}
			}
		
		
		else {
			return "login";
		}
		
		
	}
	
	
}
