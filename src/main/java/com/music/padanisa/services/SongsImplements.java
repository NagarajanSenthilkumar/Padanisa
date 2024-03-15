package com.music.padanisa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.padanisa.entity.Songs;
import com.music.padanisa.repositories.Songrepositories;

@Service
public class SongsImplements implements SongsSerivce{
	@Autowired
	Songrepositories songrep;

	@Override
	public String addSongs(Songs songs) {
		songrep.save(songs);
		return"Created songs";
	}

	@Override
	public boolean existedName(String name) {
		if(songrep.findByName(name)==null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	@Override
	public List<Songs> getAllSongs() {
		List<Songs> songlist=songrep.findAll();
		return songlist;
	}

	@Override
	public void updateSong(Songs song) {
		songrep.save(song);
		
	}

}
