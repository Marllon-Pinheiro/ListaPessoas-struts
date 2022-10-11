package br.com.ebix.dao;

import br.com.ebix.model.Pessoa;
import br.com.ebix.service.PessoaServiceFacadeImpl;

public class main {

	public static void main(String[] args) throws Exception {
		PessoaDAO dao = new PessoaDAO();
		Pessoa pessoa = new Pessoa();
//		dao.cadastrar(pessoa);
		/*pessoa.setId(3);
		dao.remover(pessoa);*/
//		pessoa.setNome("Marllinho");
//		pessoa.setId(1);
//		dao.atualizar(pessoa);
//		dao.listar();
		System.out.println(dao.consultarCpf("151.441.767-71"));
		
		PessoaServiceFacadeImpl facade = new PessoaServiceFacadeImpl();
		facade.validarCadastro("Ennio", "151.441.722-33");
	}
	


}
