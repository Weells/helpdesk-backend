package com.bruno.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bruno.helpdesk.domain.dtos.ClienteDTO;
import com.bruno.helpdesk.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Chamado> chamados = new ArrayList<>();

	public Cliente() {
		super();
		addPerfil(Perfil.CLIENTE);
	}
	
	public Cliente(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
		addPerfil(Perfil.CLIENTE);
	}

	public Cliente(ClienteDTO obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = obj.getDataCriacao();
	}
	
	public Cliente(Builder builder) {
		super(builder.id, builder.nome, builder.cpf, builder.email, builder.senha);
	}
	
	public static class Builder{
		private Integer id;
		private String nome;
		private String cpf;
		private String email;
		private String senha;
		
		public Builder() {}
		
		public Builder setId(Integer id) {
			this.id = id;
			return this;
		}
		public Builder setNome(String nome) {
			this.nome = nome;
			return this;
		}
		public Builder setCpf(String cpf) {
			this.cpf = cpf;
			return this;
		}
		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}
		public Builder setSenha(String senha) {
			this.senha = senha;
			return this;
		}
		public Cliente build() {
			return new Cliente(this);
		}
	}

	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}
	
}
