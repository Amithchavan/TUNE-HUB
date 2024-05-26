package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Playlist;
import com.example.demo.repositry.Playlistrepositry;

@Service
public class Playlistserviceimpl implements Playlistservice {
	@Autowired
	Playlistrepositry repo;

	@Override
	public void addplaylist(Playlist pl) {
		repo.save(pl);
		
	}

	@Override
	public List<Playlist> fetchAllPlaylist() {
		return repo.findAll();
	}

}
