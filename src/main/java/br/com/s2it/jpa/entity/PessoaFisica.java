package br.com.s2it.jpa.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "F")
public class PessoaFisica extends Pessoa {

	@Column(name = "data_nascimento", nullable = true)
	private LocalDate dataNascimento;
	
	public PessoaFisica() {
		setTipo(TipoPessoa.F);
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String getCodigoFormatado() {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public String toString() {
		return "PessoaFisica [dataNascimento=" + dataNascimento + "] " + super.toString();
	}

}
