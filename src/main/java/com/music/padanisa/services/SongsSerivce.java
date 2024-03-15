package com.music.padanisa.services;

import java.util.List;

import com.music.padanisa.entity.Songs;

public interface SongsSerivce {
	
	public String addSongs(Songs songs);
	public boolean existedName(String name);
	public List<Songs> getAllSongs();
	public void updateSong(Songs song);

}
