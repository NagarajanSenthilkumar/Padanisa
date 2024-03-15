package com.music.padanisa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.music.padanisa.entity.Songs;
import com.music.padanisa.services.SongsSerivce;

@Controller
public class SongController {
	@Autowired
	SongsSerivce songserv;
	
	@PostMapping("addsongs")
	public String addSongs(@ModelAttribute Songs song)
	{
		boolean songAdded= songserv.existedName(song.getName());
		if(songAdded==false)
		{
			songserv.addSongs(song);
			return"adminsuccess";
		}
		else
		{
			return "adminfail";
		}
		
	}
	@GetMapping("viewsong")
	public String getAllSongs(Model model)
	{
		List<Songs> songlist=songserv.getAllSongs();
		model.addAttribute("song", songlist);
		return "viewsongs";
	}
	@GetMapping("viewSongs")
	public String viewSongs(Model model)
	{
		boolean primeStatus=false;
		if(primeStatus==true)
		{ 
			List<Songs> songlist=songserv.getAllSongs();
			model.addAttribute("song", songlist);
			return "viewsongs";

		}
		else
		{
			return "makepayment";
		}
	}

}