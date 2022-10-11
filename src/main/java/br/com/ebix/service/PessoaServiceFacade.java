package br.com.ebix.service;

public interface PessoaServiceFacade {

	boolean validarCadastro(String nome, String cpf);
	
	void verificarId();
}
