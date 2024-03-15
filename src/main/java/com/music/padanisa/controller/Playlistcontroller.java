package com.music.padanisa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.music.padanisa.entity.PlaylistSongs;
import com.music.padanisa.entity.Songs;
import com.music.padanisa.services.Playlistservices;
import com.music.padanisa.services.SongsSerivce;

@Controller
public class Playlistcontroller {
	@Autowired
	Playlistservices playserv;
	@Autowired
	SongsSerivce sserv;
	
	@GetMapping("map-playlist")
	public String createPlaylistt(Model model)
	{
		List<Songs> songlist=sserv.getAllSongs();
		model.addAttribute("songlist", songlist);
		return"createplaylist";
	}
	@PostMapping("addPlaylist")
	public String addedPlaylist(@ModelAttribute PlaylistSongs playsli)
	{
		playserv.createPlaylistt(playsli);
		List<Songs> Songlist = playsli.getSong();
		for(Songs songs: Songlist)
		{
			songs.getPlsongs().add(playsli);
			sserv.updateSong(songs);
		}
		return "addedplaylist";
	}
	@GetMapping("mapviewplaylist")
	public String viewPlaylist(Model model)
	{
		List<PlaylistSongs>play=playserv.viewPlaylist();
		model.addAttribute("plistview",play);
		return "viewplaylist";
	}
	@GetMapping("mapviewplaylist1")
	public String viewCsPlaylist(Model model)
	{
		List<PlaylistSongs>play=playserv.viewPlaylist();
		model.addAttribute("plistview",play);
		return "customerpl";
	}
	
	

}
