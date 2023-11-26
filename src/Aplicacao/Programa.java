package Aplicacao;

import model.dao.ContatoDao;
import model.dao.DaoFactory;
import model.entities.Contato;

public class Programa {

	public static void main(String[] args) {

		ContatoDao contatoDao = DaoFactory.createContatoDao();

		Contato contato = contatoDao.findById(1);
		System.out.println(contato);
	}

}
