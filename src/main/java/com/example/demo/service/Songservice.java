package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Songs;

public interface Songservice {

	void addsong(Songs song);

	List<Songs> fetchAllSong();

	public boolean songExist(String name);

	void updatesong(Songs s);
	





}
