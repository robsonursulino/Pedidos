package com.algaworks.pedidovenda.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.pedidovenda.model.Categoria;

public class CategoriaRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public List<Categoria> listarCategorias() {
		return manager.createQuery("from Categoria where categoriaPai is null", Categoria.class).getResultList();
	}

	public Categoria porId(Long id) {
		return manager.find(Categoria.class, id);
	}

	public List<Categoria> listarSubcategorias(Categoria categoria) {
		return manager.createQuery("from Categoria where categoriaPai = :categoria", Categoria.class).setParameter("categoria", categoria).getResultList();
	}

}
