package com.music.padanisa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.music.padanisa.entity.Padanisa;

public interface Padanisarepositories  extends JpaRepository<Padanisa, Integer>{
	
	public Padanisa findByEmail(String email);

}
