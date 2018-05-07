package br.com.s2it.jpa.pessoa.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.List;

import javax.sql.DataSource;

import br.com.s2it.jpa.entity.Pessoa;
import br.com.s2it.jpa.entity.PessoaFisica;
import br.com.s2it.jpa.entity.PessoaJuridica;
import br.com.s2it.jpa.repository.AbstractJdbcrepository;

public class JdbcPessoaRepository extends AbstractJdbcrepository<Long, Pessoa> implements PessoaRepository {
	
	private static final String INSERT_PESSOA_FISICA = "INSERT INTO pessoa(id, codigo, tipo, nome, data_nascimento) VALUES (?, ?, 'F', ?, ?)";  
	private static final String INSERT_PESSOA_JURIDICA = "INSERT INTO pessoa(id, codigo, tipo, nome, nome_fantasia) VALUES (?, ?, 'J', ?, ?)";
	
	public JdbcPessoaRepository(DataSource dataSource) {
		super(dataSource);
	}

	@Override
	public Pessoa gravar(Pessoa pessoa) {
		PreparedStatement ps = null;
		try (Connection connection = getDataSource().getConnection()){
			Long nextSequenceValue = nextSequenceValue(connection);
			if (pessoa.isFisica()) {
				ps = connection.prepareStatement(INSERT_PESSOA_FISICA);
			} else if (pessoa.isJuridica()) {
				ps = connection.prepareStatement(INSERT_PESSOA_JURIDICA);
			} else {
				throw new IllegalArgumentException("Parâmetro desconhecido " + pessoa);
			}
			pessoa.setId(nextSequenceValue);
			ps.setLong(1, pessoa.getId());
			ps.setString(2, pessoa.getCodigo());
			ps.setString(3, pessoa.getNome());
			if (pessoa.isFisica()) {
				ps.setTimestamp(4, Timestamp.valueOf(((PessoaFisica) pessoa).getDataNascimento().atTime(LocalTime.MIN)));
			} else {
				ps.setString(4, ((PessoaJuridica) pessoa).getNomeFantasia());
			}
			int executeUpdate = ps.executeUpdate();
			if (executeUpdate == 0) throw new SQLException("Insert failed of " + pessoa);
			ps.close();
			return pessoa;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Pessoa findById(Long id) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public Pessoa update(Pessoa pessoa) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public void remove(Pessoa pessoa) {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public List<Pessoa> findAll() {
		throw new UnsupportedOperationException("Not Implemented");
	}

	@Override
	public Pessoa findByCodigo(String codigo) {
		throw new UnsupportedOperationException("Not Implemented");
	}
	
	public Long nextSequenceValue(Connection connection) throws SQLException {
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("select nextval('sq_pessoa');");
		Long result = null;
		if (rs.next()) {
			result = rs.getLong(1);
		}
		rs.close();
		st.close();
		if (result == null) {
			throw new SQLException("Could not get next sequence value");
		}
		return result;
	}

}
