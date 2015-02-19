package com.algaworks.financeiro.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.algaworks.financeiro.model.Livro;

@ManagedBean
@ViewScoped
public class LivrosBean {

	private List<Livro> livros;
	private Livro novoLivro;

	public LivrosBean() {
		this.livros = new ArrayList<Livro>();
		this.novoLivro = new Livro();
	}
	
	public void adicionar() {
		this.livros.add(novoLivro);
		this.novoLivro = new Livro();
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
	
	public Livro getNovoLivro() {
		return novoLivro;
	}

}
