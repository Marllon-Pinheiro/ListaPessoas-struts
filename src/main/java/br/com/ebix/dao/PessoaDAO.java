package br.com.ebix.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ebix.model.Pessoa;

@Component
public class PessoaDAO {

	MySQLDAO conn = new MySQLDAO();

	public void cadastrar(Pessoa pessoa) throws Exception {

		String sql = "INSERT INTO pessoas (nome,cpf) VALUES (?, ?)";
		Connection connection = conn.getConnection();
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, pessoa.getNome());
			stm.setString(2, pessoa.getCpf());
			stm.execute();

		} catch (SQLException ex) {
			throw new RuntimeException("Erro ao cadastrar pessoa");
		} finally {
			connection.close();
		}
	}

	public void remover(Pessoa pessoa) throws Exception {

		String sql = "DELETE FROM pessoas WHERE id = ?";
		Connection connection = conn.getConnection();
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setInt(1, pessoa.getId());
			stm.execute();
		} catch (SQLException ex) {
			throw new RuntimeException("Erro ao remover pessoa");
		} finally {
			connection.close();
		}
	}

	public void atualizar(Pessoa pessoa) throws Exception {

		String sql = "UPDATE pessoas SET nome = ?, cpf = ? WHERE id = ?";
		Connection connection = conn.getConnection();
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, pessoa.getNome());
			stm.setString(2, pessoa.getCpf());
			stm.setInt(3, pessoa.getId());
			stm.execute();
		} catch (SQLException ex) {
			throw new RuntimeException("Erro ao atualizar pessoa");
		} finally {
			connection.close();
		}
	}

	public List<Pessoa> listar() throws Exception {

		String sql = "SELECT * FROM pessoas";
		ResultSet result = null;

		List<Pessoa> pessoas = new ArrayList<>();
		Connection connection = conn.getConnection();
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			result = stm.executeQuery();

			while (result.next()) {

				Pessoa pessoa = new Pessoa();
				pessoa.setId(result.getInt("id"));
				pessoa.setNome(result.getString("nome"));
				pessoa.setCpf(result.getString("cpf"));
				pessoas.add(pessoa);
			}
		} catch (SQLException ex) {
			throw new RuntimeException("Erro ao listar pessoas");
		} finally {
			connection.close();
		}
		return pessoas;
	}

	public List<Pessoa> consultarCpf(String cpf) throws Exception {

		String sql = "SELECT nome FROM pessoas WHERE cpf = ?";
		ResultSet result = null;
		Connection connection = conn.getConnection();

		List<Pessoa> pessoas = new ArrayList<>();
		try {

			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, cpf);
			result = stm.executeQuery();

			while (result.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setNome(result.getString("nome"));
				pessoas.add(pessoa);
			}
		} catch (SQLException ex) {
			throw new RuntimeException("Erro ao consultar nome");
		} finally {
			connection.close();
		}
		return pessoas;
	}

}
