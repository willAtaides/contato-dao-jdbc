package model.dao;

import model.dao.impl.ContatoDaoJDBC;

public class DaoFactory {

	public static ContatoDao createContatoDao() {
		return new ContatoDaoJDBC();
	}
}
