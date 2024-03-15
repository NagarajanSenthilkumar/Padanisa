package com.music.padanisa.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.music.padanisa.entity.Padanisa;
import com.music.padanisa.services.Padanisaservice;
import com.music.padanisa.services.SongsSerivce;
import com.music.padanisa.entity.Songs;

import jakarta.servlet.http.HttpSession;

@Controller
public class PadanisaController {
	@Autowired
	Padanisaservice padserv;
	@Autowired
	SongsSerivce songserv;
	
	@PostMapping("register")
	public String addUser(@ModelAttribute Padanisa user)
	{
		boolean useStatus = padserv.emailExisting(user.getEmail());
		if(useStatus==false)
		{
			padserv.addUser(user);
			return "login";
		}
		else {
			return "registerfail";
		}
		
	}
	
	@PostMapping("login")
	public String validateUser(@RequestParam String email,String password, HttpSession session)
	{
		boolean emailExists = padserv.emailExisting(email);
        if (!emailExists) {
             return "registerfailemail";
        }
		boolean loginstatus=padserv.validateUser(email,password);
		if(loginstatus==true)
		{
			session.setAttribute("email", email);
			if(padserv.getRole(email).equals("Admin"))
			{
				return "adminhome";
			}
			else
			{
				return "customerhome";
			}
		}
		else 
		{
			return "loginfail";
		}
	}
		@GetMapping("/exploreSongs")
		public String exploreSongs(HttpSession session,Model model)
		{
			String email = (String) session.getAttribute("email");
			Padanisa pada=padserv.getUser(email);
			boolean userStatus=pada.isPremium();
			if(userStatus == true) {
				List<Songs> lis= songserv.getAllSongs();
				model.addAttribute("song",lis);
				return "customervs";
			}
			else {
				return "makepayment";
			}
		}
}
