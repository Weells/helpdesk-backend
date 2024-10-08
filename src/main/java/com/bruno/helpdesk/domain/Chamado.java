package com.bruno.helpdesk.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.bruno.helpdesk.domain.enums.Prioridade;
import com.bruno.helpdesk.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Chamado implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataAbertura = LocalDate.now();
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataFechamento;
	
	private Prioridade prioridade;
	private Status status;
	private String titulo;
	private String observacoes;
	
	@ManyToOne
	@JoinColumn(name = "tecnico_id")
	private Tecnico tecnico;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	public Chamado() {
		super();
	}
	
	public Chamado(Integer id, Prioridade prioridade, Status status, String titulo, String observacoes, Tecnico tecnico,
			Cliente cliente) {
		super();
		this.id = id;
		this.prioridade = prioridade;
		this.status = status;
		this.titulo = titulo;
		this.observacoes = observacoes;
		this.tecnico = tecnico;
		this.cliente = cliente;
	}
	
	public Chamado(Builder builder) {
		super();
		this.id = builder.id;
		this.prioridade = builder.prioridade;
		this.status = builder.status;
		this.titulo = builder.titulo;
		this.observacoes = builder.observacoes;
		this.tecnico = builder.tecnico;
		this.cliente = builder.cliente;
	}

	public static class Builder{
		private Integer id;
		private Prioridade prioridade;
		private Status status;
		private String titulo;
		private String observacoes;
		private Tecnico tecnico;
		private Cliente cliente;
		
		public Builder() {}

		public Builder setId(Integer id) {
			this.id = id;
			return this;
		}

		public Builder setPrioridade(Prioridade prioridade) {
			this.prioridade = prioridade;
			return this;
		}

		public Builder setStatus(Status status) {
			this.status = status;
			return this;
		}

		public Builder setTitulo(String titulo) {
			this.titulo = titulo;
			return this;
		}

		public Builder setObservacoes(String observacoes) {
			this.observacoes = observacoes;
			return this;
		}

		public Builder setTecnico(Tecnico tecnico) {
			this.tecnico = tecnico;
			return this;
		}

		public Builder setCliente(Cliente cliente) {
			this.cliente = cliente;
			return this;
		}
		
		public Chamado build() {
			return new Chamado(this);
		}
	}
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public LocalDate getDataAbertura() {
		return dataAbertura;
	}


	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}


	public LocalDate getDataFechamento() {
		return dataFechamento;
	}


	public void setDataFechamento(LocalDate dataFechamento) {
		this.dataFechamento = dataFechamento;
	}


	public Prioridade getPrioridade() {
		return prioridade;
	}


	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getObservacoes() {
		return observacoes;
	}


	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}


	public Tecnico getTecnico() {
		return tecnico;
	}


	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chamado other = (Chamado) obj;
		return Objects.equals(id, other.id);
	}
	
}
