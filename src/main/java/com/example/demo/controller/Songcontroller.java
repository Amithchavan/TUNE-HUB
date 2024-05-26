package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Songs;
import com.example.demo.service.Songservice;

@Controller
public class Songcontroller {
	@Autowired
	Songservice service;
	
	@PostMapping("/addsong")
	public String addsong(@ModelAttribute Songs song) {
		
		boolean songStatus=service.songExist(song.getName());
		if(songStatus==false) {
			service.addsong(song);
			System.out.println("added");
		}
		else {
			System.out.println("song already added");
		}
		
		
		return "adminhome";
		
	}
	
	@GetMapping("/viewSong")
	public String viewsong(Model model) {
		List<Songs> songs=service.fetchAllSong();
		System.out.println(songs);
		model.addAttribute("song",songs);
		
		return "displaysong";
	}



}
