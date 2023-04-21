package com.vitinejv.filmes.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vitinejv.filmes.entities.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long>{

	@Query("SELECT f FROM Filme f WHERE f.titulo = ?1")
	Optional<Filme> findByTitulo(String titulo);
}
