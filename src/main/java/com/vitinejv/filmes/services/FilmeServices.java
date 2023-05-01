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
		if (f.getTitulo() == null || !(f.getTitulo().length() > 0)) {
			throw new IllegalStateException("Título inválido");
		}
		
		if (!(f.getDuracao() > 0)) {
			throw new IllegalStateException("Duração não pode ser igual ou menor que 0");
		}

		repository.save(f);
	}

	@Transactional
	public void deleteFilmes(Long id) {
		if(repository.existsById(id)) {
			Filme f = repository.getReferenceById(id);
			repository.delete(f);
		}
		else {
			throw new IllegalStateException("filme com o id " + id + " não existe");
		}
	}

	@Transactional
	public void updateFilmes(Long id, Filme update) {
		Filme f = repository.findById(id).orElseThrow(() -> 
			new IllegalStateException("Filme com id " + id + " não existe"));
		
		if (update.getTitulo() != null && update.getTitulo().length() > 0
				&& update.getTitulo() != f.getTitulo()) {
			
			Optional<Filme> optionalFilme = repository.findByTitulo(update.getTitulo());
			if (optionalFilme.isPresent() && !update.getTitulo().equals(f.getTitulo())) {
				throw new IllegalStateException("Já existe um filme com esse título");
			}
			f.setTitulo(update.getTitulo());
		}
		
		if (update.getDuracao() > 0	&& update.getDuracao() != f.getDuracao()) {
			f.setDuracao(update.getDuracao());
		}
		
		if (update.getNota() != f.getNota()) {
			f.setNota(update.getNota());
		}
		
	}
}
