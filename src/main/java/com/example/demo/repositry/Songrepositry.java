package com.example.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Songs;

public interface Songrepositry extends JpaRepository<Songs,Integer> {

	public Songs findByName(String name);

}
