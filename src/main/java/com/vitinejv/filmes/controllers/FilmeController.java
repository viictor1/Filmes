package com.vitinejv.filmes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitinejv.filmes.entities.Filme;
import com.vitinejv.filmes.services.FilmeServices;

@RestController
@RequestMapping(path = "api/v1/filmes")
public class FilmeController {
	
	private final FilmeServices services;
	
	@Autowired
	public FilmeController(FilmeServices filmeServices) {
		this.services = filmeServices;
	}
	
	@GetMapping
	public List<Filme> getFilmes(){
		return services.getFilmes();
	}
	
	@PostMapping
	public void addFilmes(@RequestBody Filme f) {
		services.addFilme(f);
	}
}
