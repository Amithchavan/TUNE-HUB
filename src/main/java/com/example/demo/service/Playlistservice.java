package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Playlist;

public interface Playlistservice {

	 public void addplaylist(Playlist pl);

	public List<Playlist> fetchAllPlaylist();

}
