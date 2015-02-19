package com.algaworks.financeiro.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class CadastroBean {

	private String nome;

	public void cadastrar() {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Cadastro efetuado.", "Cliente " + this.nome
						+ " cadastrado com sucesso.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
