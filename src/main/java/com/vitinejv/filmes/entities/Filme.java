package com.vitinejv.filmes.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Filme{
	
	@Id
	@SequenceGenerator(
			name = "filme_sequence",
			sequenceName = "filme_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "filme_sequence"
	)
	private Long id;
	
	private String titulo;
	private int duracao;
	private float nota;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	public float getNota() {
		return nota;
	}
	public void setNota(float nota) {
		this.nota = nota;
	}
	
	public Filme() {
	
	}
	
	public Filme(Long id, String titulo, int duracao, float nota) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.duracao = duracao;
		this.nota = nota;
	}
	
	public Filme(String titulo, int duracao, float nota) {
		super();
		this.titulo = titulo;
		this.duracao = duracao;
		this.nota = nota;
	}
	@Override
	public String toString() {
		return "Filme [id=" + id + ", titulo=" + titulo + ", duracao=" + duracao + ", nota=" + nota + "]";
	}
	
	
	
 }
