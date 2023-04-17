package com.vitinejv.filmes.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vitinejv.filmes.entities.Filme;

@Service
public class FilmeServices {
	public List<Filme> getFilmes(){
		return List.of(	new Filme(1L, "Star Wars", 130, 8));
	}
}
