package com.example.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Playlist;

public interface Playlistrepositry extends JpaRepository<Playlist,Integer> {

}
