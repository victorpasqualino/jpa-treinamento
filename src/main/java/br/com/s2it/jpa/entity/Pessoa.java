package br.com.s2it.jpa.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
public abstract class Pessoa {

	@Id
	@SequenceGenerator(initialValue = 1, allocationSize = 1, name = "pessoaGenerator", sequenceName = "sq_pessoa")
	@GeneratedValue(generator = "pessoaGenerator", strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", nullable = false, insertable = false, updatable = false)
	private TipoPessoa tipo;

	@Column(name = "codigo", nullable = false)
	private String codigo;

	@Column(name = "nome", nullable = false)
	private String nome;
	
	public abstract String getCodigoFormatado();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	protected TipoPessoa getTipo() {
		return tipo;
	}

	protected void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public enum TipoPessoa {

		F("Física"), J("Jurídica");

		private String description;

		private TipoPessoa(String description) {
			this.description = description;
		}

		public String getDescription() {
			return description;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getCodigo() == null) ? 0 : getCodigo().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Pessoa))
			return false;
		Pessoa other = (Pessoa) obj;
		if (getCodigo() == null) {
			if (other.getCodigo() != null)
				return false;
		} else if (!getCodigo().equals(other.getCodigo()))
			return false;
		return true;
	}

	public static Pessoa create(TipoPessoa tipoPessoa) {
		if (TipoPessoa.F.equals(tipoPessoa)) {
			return new PessoaFisica();
		} else if (TipoPessoa.J.equals(tipoPessoa)) {
			return new PessoaJuridica();
		} else {
			throw new IllegalArgumentException("Unsuported person type: " + tipoPessoa);
		}
	}

	public boolean isFisica() {
		return TipoPessoa.F.equals(tipo);
	}

	public boolean isJuridica() {
		return TipoPessoa.J.equals(tipo);
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", tipo=" + tipo + ", codigo=" + codigo + ", nome=" + nome + "]";
	}

}
