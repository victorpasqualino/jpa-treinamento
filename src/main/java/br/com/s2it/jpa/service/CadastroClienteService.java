package br.com.s2it.jpa.service;

import br.com.s2it.jpa.cliente.repository.ClienteRepository;
import br.com.s2it.jpa.entity.Cliente;
import br.com.s2it.jpa.entity.Pessoa;
import br.com.s2it.jpa.pessoa.repository.PessoaRepository;
import br.com.s2it.jpa.vo.CadastroClienteVo;

public class CadastroClienteService {
	
	private PessoaRepository pessoaRepository;
	private ClienteRepository clienteRepostory;
	
	public CadastroClienteService(PessoaRepository pessoaRepository, ClienteRepository clienteRepostory) {
		this.pessoaRepository = pessoaRepository;
		this.clienteRepostory = clienteRepostory;
	}
	
	public Cliente cadastrarCliente(CadastroClienteVo cadastroClienteVo) {
		Cliente cliente = cadastroClienteVo.toCliente();
		
		Pessoa pessoa = pessoaRepository.findByCodigo(cliente.getPessoa().getCodigo());
		if ( pessoa != null ) {
			cliente.setPessoa(pessoa);
		} else {
			cliente.setPessoa(pessoaRepository.gravar(pessoa));
		}
		
		return clienteRepostory.gravar(cliente);
	}
	

}
