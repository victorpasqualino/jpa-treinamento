package br.com.s2it.jpa.vo;

import java.time.LocalDate;

import br.com.s2it.jpa.entity.Cliente;
import br.com.s2it.jpa.entity.Pessoa;
import br.com.s2it.jpa.entity.Pessoa.TipoPessoa;
import br.com.s2it.jpa.entity.PessoaFisica;
import br.com.s2it.jpa.entity.PessoaJuridica;

public class CadastroClienteVo {

	private String nome;

	private String codigo;

	private TipoPessoa tipoPessoa;

	private LocalDate dataNascimento;

	private String nomeFantasia;

	private String login;

	private String email;

	private String password;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Cliente toCliente() {
		Cliente cliente = new Cliente();
		cliente.setEmail(email);
		cliente.setLogin(login);
		cliente.setPassword(password);
		cliente.setPessoa(toPessoa());
		return cliente;
	}
	
	private Pessoa toPessoa() {
		Pessoa pessoa = Pessoa.create(tipoPessoa);
		if ( pessoa.isFisica() ) {
			((PessoaFisica) pessoa).setDataNascimento(dataNascimento);
		}
		if ( pessoa.isJuridica() ) {
			((PessoaJuridica) pessoa).setNomeFantasia(nomeFantasia);
		}
		pessoa.setCodigo(codigo);
		pessoa.setNome(nome);
		return pessoa;
	}

	@Override
	public String toString() {
		return "CadastroClienteVo [nome=" + nome + ", codigo=" + codigo + ", tipoPessoa=" + tipoPessoa
				+ ", dataNascimento=" + dataNascimento + ", nomeFantasia=" + nomeFantasia + ", login=" + login
				+ ", email=" + email + ", password=" + password + "]";
	}
	
}
