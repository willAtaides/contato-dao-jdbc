package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.ContatoDao;
import model.entities.Contato;

public class ContatoDaoJDBC implements ContatoDao{

	
	private Connection conn;
	
	public ContatoDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Contato contato) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Contato contato) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Contato findById(long id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"select *"
					+ "from contatos "
					+ "where id = ?");
			st.setLong(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				return contato;
			}
			return null;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}

	@Override
	public List<Contato> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contato> findByFirstLetter(char firstLetter) {
		// TODO Auto-generated method stub
		return null;
	}

}
