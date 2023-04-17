package com.vitinejv.filmes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitinejv.filmes.entities.Filme;
import com.vitinejv.filmes.repositories.FilmeRepository;

@Service
public class FilmeServices {
	
	private final FilmeRepository repository;
	
	@Autowired
	public FilmeServices(FilmeRepository filmeRepository) {
		this.repository = filmeRepository;
	}
	
	
	public List<Filme> getFilmes(){
		return repository.findAll();
	}
}
