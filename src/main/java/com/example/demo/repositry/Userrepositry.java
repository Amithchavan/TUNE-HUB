package com.example.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Users;

public interface Userrepositry extends JpaRepository<Users,Integer>{

	public Users findByEmail(String email);
	



}
