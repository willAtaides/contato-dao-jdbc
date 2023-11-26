package model.dao;

import db.DB;
import model.dao.impl.ContatoDaoJDBC;

public class DaoFactory {

	public static ContatoDao createContatoDao() {
		return new ContatoDaoJDBC(DB.getConnection());
	}
}
