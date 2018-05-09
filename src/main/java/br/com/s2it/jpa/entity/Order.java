package br.com.s2it.jpa.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "order_")
public class Order implements Serializable {

	private static final long serialVersionUID = -526678874853490743L;

	@Id
	@SequenceGenerator(initialValue = 1, allocationSize = 1, name = "orderGenerator", sequenceName = "sq_order")
	@GeneratedValue(generator = "orderGenerator", strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;

	@Column(name = "valor")
	private Double valor;

	@Column(name = "data_compra")
	private LocalDateTime dataCompra;

	@Enumerated(EnumType.STRING)
	@Column(name = "status_pagamento")
	private StatusPagamento statusPagamento;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "order_item", 
		joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "cliente_id", referencedColumnName = "id")
	)
	private Set<Item> items;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public LocalDateTime getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDateTime dataCompra) {
		this.dataCompra = dataCompra;
	}

	public StatusPagamento getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(StatusPagamento statusPagamento) {
		this.statusPagamento = statusPagamento;
	}
	
	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Order))
			return false;
		Order other = (Order) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

	public enum StatusPagamento {

		AP("Aguardando Pagamento"), PE("Pagamento Efetuado");

		private String description;

		private StatusPagamento(String description) {
			this.description = description;
		}

		public String getDescription() {
			return description;
		}

	}

}
