package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.repositry.Userrepositry;

@Service
public class Userserviceimpl implements Userservice {
	@Autowired
	Userrepositry repo;
	@Override
	public String adduser(Users user) {
		repo.save(user);
		return "user added suucessfully";
	}
	@Override
	public boolean emailExists(String email) {
	if(repo.findByEmail(email)==null) {
		return false;
	}
	else {
		return true;
	}
	
	


	}
	@Override
	public boolean validateuser(String email, String password) {
		Users user=repo.findByEmail(email);
		if(password.equals(user.getPassword())) {
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public String getrole(String email) {
		Users user=repo.findByEmail(email);
		return user.getRole();
	}
	@Override
	public Users getUser(String mail) {
		return repo.findByEmail(mail);
	}
	@Override
	public void updateUser(Users u) {
		
		repo.save(u);
	}
	
	

}
