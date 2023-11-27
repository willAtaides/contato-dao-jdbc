package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.ContatoDao;
import model.entities.Contato;

public class ContatoDaoJDBC implements ContatoDao {

	private Connection conn;

	public ContatoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Contato contato) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO contatos (nome, email, endereco) VALUES (?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			st.setString(1, contato.getNome());
			st.setString(2, contato.getEmail());
			st.setString(3, contato.getEndereco());

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					contato.setId(id);
				}
				DB.closeResultSet(rs);
			} else {
				throw new DbException("Erro Inesperado! Nenhuma linha foi afetada! ");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Contato contato) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("update contatos set nome = ?, email = ?, endereco = ? where id = ?");

			st.setString(1, contato.getNome());
			st.setString(2, contato.getEmail());
			st.setString(3, contato.getEndereco());
			st.setLong(4, (long) contato.getId());

			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteById(long id) {

		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("delete from contatos where id = ?");
			
			st.setLong(1,id);
			
			st.executeUpdate();
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Contato findById(long id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("select *" + "from contatos " + "where id = ?");
			st.setLong(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Contato contato = instanciarContato(rs);
				return contato;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}

	private Contato instanciarContato(ResultSet rs) throws SQLException {
		Contato contato = new Contato();
		contato.setId(rs.getLong("id"));
		contato.setNome(rs.getString("nome"));
		contato.setEmail(rs.getString("email"));
		contato.setEndereco(rs.getString("endereco"));
		return contato;
	}

	@Override
	public List<Contato> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Contato> contatos = new ArrayList<>();

		try {
			st = conn.prepareStatement("SELECT * FROM contatos ORDER BY nome");
			rs = st.executeQuery();

			while (rs.next()) {
				Contato contato = instanciarContato(rs);
				contatos.add(contato);
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

		return contatos;
	}

	@Override
	public List<Contato> findByFirstLetter(char firstLetter) {
		 PreparedStatement st = null;
		    ResultSet rs = null;
		    List<Contato> contatos = new ArrayList<>();

		    try {
		        st = conn.prepareStatement("select * from contatos where lower(substring(nome, 1, 1)) = ?");
		        st.setString(1, String.valueOf(firstLetter).toLowerCase());

		        rs = st.executeQuery();

		        while (rs.next()) {
		            Contato contato = instanciarContato(rs);
		            contatos.add(contato);
		        }
		    } catch (SQLException e) {
		        throw new DbException(e.getMessage());
		    } finally {
		        DB.closeStatement(st);
		        DB.closeResultSet(rs);
		    }

		    return contatos;
		}
	}


