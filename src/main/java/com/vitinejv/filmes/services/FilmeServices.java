package com.vitinejv.filmes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitinejv.filmes.entities.Filme;
import com.vitinejv.filmes.repositories.FilmeRepository;

import jakarta.transaction.Transactional;

@Service
public class FilmeServices {
	
	private final FilmeRepository repository;
	
	@Autowired
	public FilmeServices(FilmeRepository filmeRepository) {
		this.repository = filmeRepository;
	}
	
	@Transactional
	public List<Filme> getFilmes(){
		return repository.findAll();
	}

	@Transactional
	public void addFilme(Filme f) {
		Optional<Filme> filmeOptional = repository.findByTitulo(f.getTitulo());
		if(filmeOptional.isPresent()) {
			throw new IllegalStateException("Já existe um filme com este nome");
		}
		repository.save(f);
	}
}
