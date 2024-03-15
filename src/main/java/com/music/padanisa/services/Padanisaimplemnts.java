package com.music.padanisa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.music.padanisa.entity.Padanisa;
import com.music.padanisa.repositories.Padanisarepositories;

@Service
public class Padanisaimplemnts implements Padanisaservice {
	@Autowired
	Padanisarepositories padarepo;
	@Override
	public String addUser(Padanisa pada) {
		padarepo.save(pada);
		return "User is Created and Saved";
	}
	@Override
	public boolean emailExisting(String email) {
		if (padarepo.findByEmail(email) == null) {
			return false;
		} else {
			return true;
		}
	}
	@Override
	public boolean validateUser(String email, String password) {
		Padanisa padaa = padarepo.findByEmail(email);
		String db_passcode = padaa.getPassword();
		if (db_passcode.equals(password)) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public String getRole(String email) {
		return (padarepo.findByEmail(email).getRole());
	}
	@Override
	public Padanisa getUser(String email) {
		return padarepo.findByEmail(email);
	}
	@Override
	public void updateUser(Padanisa user) {
		padarepo.save(user);
		
	}

}
