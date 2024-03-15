package com.music.padanisa.services;

import com.music.padanisa.entity.Padanisa;

public interface Padanisaservice {
	
	public String addUser(Padanisa pada);
	public boolean emailExisting(String email);
	public boolean validateUser(String email,String password);
	public String getRole(String email);
	public Padanisa getUser(String email);
	public void updateUser(Padanisa user);
}
