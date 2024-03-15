package com.music.padanisa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Navcontroller {
	@GetMapping("register")
	public String navRegister()
	{
		return "register";
	}
	
	@GetMapping("login")
	public String navLogin()
	{
		return "login";
	}
	@GetMapping("home")
	public String navHome()
	{
		return "adminhome";
	}
	@GetMapping("home1")
	public String navCsHome()
	{
		return "customerhome";
	}
	
	@GetMapping("song")
	public String navSongs()
	{
		return "addsongs";
	}
	@GetMapping("samplepayment")
	public String samplepayment() {
		return "samplepayment";
	}
	
	@GetMapping("adminregister")
	public String adminReister() {
		return "adminregister";
	}
	@GetMapping("customerregister")
	public String CustomerReister() {
		return "index";
	}
	@GetMapping("adminfailemail")
	public String adminReister1() {
		return "adminfailemail";
	}
	@GetMapping("customerfailemail")
	public String CustomerReister1() {
		return "registerfailemail";
	}

}
