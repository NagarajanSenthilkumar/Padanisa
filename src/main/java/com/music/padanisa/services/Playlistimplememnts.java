package com.music.padanisa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.padanisa.entity.PlaylistSongs;
import com.music.padanisa.repositories.Playlistrepositories;
@Service
public class Playlistimplememnts implements Playlistservices{
	@Autowired
	Playlistrepositories playrepo;

	@Override
	public void createPlaylistt(PlaylistSongs plays) {
		playrepo.save(plays);	
	
	}

	@Override
	public List<PlaylistSongs> viewPlaylist() {
		
		return playrepo.findAll();
	}

}
