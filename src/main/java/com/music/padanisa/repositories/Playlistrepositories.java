package com.music.padanisa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.music.padanisa.entity.PlaylistSongs;

public interface Playlistrepositories extends JpaRepository<PlaylistSongs,Integer>{

}
