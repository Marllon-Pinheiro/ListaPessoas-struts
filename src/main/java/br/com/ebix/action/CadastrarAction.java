package br.com.ebix.action;

import com.opensymphony.xwork2.ActionSupport;

import br.com.ebix.service.PessoaServiceFacadeImpl;

public class CadastrarAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String nome;
	private String cpf;
	
	public CadastrarAction() {
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String cadastro() {
		
		PessoaServiceFacadeImpl facade = new PessoaServiceFacadeImpl();
		Boolean resultado = facade.validarCadastro(getNome(), getCpf());
		if(resultado) {
			return SUCCESS;
		} else {
			return ERROR;
		}
		
	}
}
