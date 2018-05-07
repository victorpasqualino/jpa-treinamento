package br.com.s2it.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_item")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 8604807817139703621L;

	@Id
	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
	private Order order;

	@Id
	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;

	@Column(name = "valor", nullable = false)
	private Double valor;

	@Column(name = "quantidade", nullable = false)
	private Integer quantidade;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
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

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getCliente() == null) ? 0 : getCliente().hashCode());
		result = prime * result + ((getOrder() == null) ? 0 : getOrder().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof OrderItem))
			return false;
		OrderItem other = (OrderItem) obj;
		if (getCliente() == null) {
			if (other.getCliente() != null)
				return false;
		} else if (!getCliente().equals(other.getCliente()))
			return false;
		if (getOrder() == null) {
			if (other.getOrder() != null)
				return false;
		} else if (!getOrder().equals(other.getOrder()))
			return false;
		return true;
	}
	
}
