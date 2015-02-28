package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import com.algaworks.pedidovenda.model.Categoria;
import com.algaworks.pedidovenda.model.Produto;
import com.algaworks.pedidovenda.repository.CategoriaRepository;
import com.algaworks.pedidovenda.service.CadastroProdutoService;
import com.algaworks.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CategoriaRepository categoriaRepository;

	@Inject
	private CadastroProdutoService cadastroProdutoService;

	private Produto produto;
	private Categoria categoria;

	private List<Categoria> categorias;
	private List<Categoria> subcategorias;

	public CadastroProdutoBean() {
		System.out.println("Inicializou cad prod bean...");
		limpar();
	}

	public void inicializar() {
		if (FacesUtil.isNotPostback()) {
			categorias = categoriaRepository.listarCategorias();

			if (this.categoria != null) {
				carregarSubcategorias();
			}
		}
	}

	public void carregarSubcategorias() {
		subcategorias = categoriaRepository.listarSubcategorias(categoria);
	}

	private void limpar() {
		this.produto = new Produto();
		this.categoria = null;
		this.subcategorias = new ArrayList<>();
	}

	public void salvar() {
		this.produto = cadastroProdutoService.salvar(this.produto);
		limpar();
		FacesUtil.addInfoMessage("Produto salvo com sucesso!");
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		System.out.println("chamou set produto...");
		this.produto = produto;

		if (this.produto != null) {
			this.categoria = this.produto.getCategoria().getCategoriaPai();
		}
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	@NotNull
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getSubcategorias() {
		return subcategorias;
	}

	public boolean isEditando() {
		return this.produto.getId() != null;
	}

}
