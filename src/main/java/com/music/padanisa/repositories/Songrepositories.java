package com.music.padanisa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.music.padanisa.entity.Songs;

public interface Songrepositories extends JpaRepository<Songs, Integer>{
	
	
	public Songs findByName(String name);

}
