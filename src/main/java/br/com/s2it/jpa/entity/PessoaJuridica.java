package br.com.s2it.jpa.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "J")
public class PessoaJuridica extends Pessoa {

	@Column(name = "nome_fantasia", nullable = true)
	private String nomeFantasia;

	public PessoaJuridica() {
		setTipo(TipoPessoa.J);
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	@Override
	public String getCodigoFormatado() {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public String toString() {
		return "PessoaJuridica [nomeFantasia=" + nomeFantasia + "] " + super.toString();
	}
	
}
