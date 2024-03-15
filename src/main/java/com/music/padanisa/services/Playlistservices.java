package com.music.padanisa.services;

import java.util.List;

import com.music.padanisa.entity.PlaylistSongs;

public interface Playlistservices {
	
	public void createPlaylistt(PlaylistSongs plays);
	public List<PlaylistSongs> viewPlaylist();

}
