package com.example.demo.service;

import com.example.demo.entity.Users;

public interface Userservice {
	public String adduser(Users user);

	public boolean emailExists(String email);

	public boolean validateuser(String email, String password);

	public String getrole(String email);

	public Users getUser(String mail);

	public void updateUser(Users u);

	



	


	
		

}
