package br.com.ebix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.ebix.dao.PessoaDAO;
import br.com.ebix.model.Pessoa;


public class PessoaServiceFacadeImpl implements PessoaServiceFacade {

	@Override
	public boolean validarCadastro(String nome, String cpf) {
		PessoaDAO dao = new PessoaDAO();
		Pessoa pessoa = new Pessoa();
		try {
			List<Pessoa> list = dao.consultarCpf(cpf);
			if(list.isEmpty()) {
				pessoa.setNome(nome);
				pessoa.setCpf(cpf);
				dao.cadastrar(pessoa);
				return true;
			} else {
				throw new RuntimeException("CPF já está cadastrado na nossa base de dados.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
		
	}

	@Override
	public void verificarId() {
		
		
	}

}
