package br.ufpb.tcc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.ufpb.tcc.dao.UsuarioOperadoraDAO;
import br.ufpb.tcc.model.UsuarioOperadora;
import br.ufpb.tcc.util.ConexaoPostgres;
import br.ufpb.tcc.util.TccException;

public class UsuarioOperadoraDAOPostgres implements UsuarioOperadoraDAO {

	@Override
	public void save(UsuarioOperadora entidade) throws TccException {
		if (entidade == null) {
			String mensagem = "Não foi informado o usuarioOperadora a cadastrar.";
			throw new TccException(mensagem);
		}

		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConexaoPostgres.getConexao();
			String sql = "INSERT INTO usuario_operadora (id_usuario, id_operadora) VALUES (?, ?)";

			pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstm.setInt(1, entidade.getUsuario().getId());
			pstm.setInt(2, entidade.getOperadora().getId());
			pstm.executeUpdate();

			// recuperar o ResultSet
			ResultSet rs = pstm.getGeneratedKeys();
			rs.next();
			int id = rs.getInt(1); // <= o valor do campo está aqui

			entidade.setId(id);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexaoPostgres.closeConexao(conn, pstm);
		}

	}

	@Override
	public void update(UsuarioOperadora entity) throws TccException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(UsuarioOperadora entity) throws TccException {
		// TODO Auto-generated method stub

	}

	@Override
	public UsuarioOperadora findOne(UsuarioOperadora entity)
			throws TccException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioOperadora> findAll() throws TccException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioOperadora> findKeyValue(UsuarioOperadora entity)
			throws TccException {
		// TODO Auto-generated method stub
		return null;
	}

}
