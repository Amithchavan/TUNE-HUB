	package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Playlist;
import com.example.demo.entity.Songs;
import com.example.demo.service.Playlistservice;
import com.example.demo.service.Songservice;

import jakarta.persistence.Entity;

@Controller
public class Playlistcontroller {
	@Autowired
	Songservice songservice;
	
	@Autowired
	Playlistservice plservice;

	
	@GetMapping("/playList")
public String createplaylist(Model model) {
		List<Songs> song=songservice.fetchAllSong();
		model.addAttribute("songs",song);
		return "createplaylist";
		
	}
	
	@PostMapping("/addplaylist")
	public String addplaylist(@ModelAttribute Playlist pl) {
		
		//update playlist table
		plservice.addplaylist(pl);
		
		//update songs table
		List<Songs> songs=pl.getSongs();
		for(Songs s:songs) {
			s.getPlaylist().add(pl);
			songservice.updatesong(s);
		}
		return	"adminhome";
		
		
	}
	@GetMapping("/viewplaylist")
	public String viewplaylist(Model model) {
		List<Playlist> allplaylist=plservice.fetchAllPlaylist();
		
		model.addAttribute("allplaylists",allplaylist);
		
		return "displayplaylist";
	}
}

