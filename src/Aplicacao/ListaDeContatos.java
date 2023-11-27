package Aplicacao;

import java.util.List;

import model.dao.ContatoDao;
import model.dao.DaoFactory;
import model.entities.Contato;

public class ListaDeContatos {

	public static void main(String[] args) {
		ContatoDao contatoDao = DaoFactory.createContatoDao();
		System.out.println("===== TODOS OS CONTATOS DE SUA LISTA =====");
		List<Contato> list = contatoDao.findAll();
		for (Contato contatos : list) {
			System.out.println(contatos);
		}

	}

}
