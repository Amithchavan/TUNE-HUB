package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Songs;
import com.example.demo.repositry.Songrepositry;

@Service
public class Songserviceimpl implements Songservice {
	@Autowired
	Songrepositry repo;

	@Override
	public void addsong(Songs song) {
		repo.save(song);
		
	}

	@Override
	public List<Songs> fetchAllSong() {
		return repo.findAll();
	}

	@Override
	public boolean songExist(String name) {
		Songs song=repo.findByName(name) ;
				if(song==null)
			return false;
		
		else {
			return true;
		}
		
			}

	@Override
	public void updatesong(Songs s) {
		repo.save(s);
				
	}

	
}
