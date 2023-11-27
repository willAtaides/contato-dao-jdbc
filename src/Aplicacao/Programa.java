package Aplicacao;

import java.util.List;

import model.dao.ContatoDao;
import model.dao.DaoFactory;
import model.entities.Contato;

public class Programa {

	public static void main(String[] args) {

		ContatoDao contatoDao = DaoFactory.createContatoDao();

		System.out.println("==== TESTE 1 contato findById ====");
		Contato contato = contatoDao.findById(1);
		System.out.println(contato);
		
		System.out.println("==== TESTE 2 contato findAll ====");
		List<Contato> list = contatoDao.findAll();
		for (Contato contatos : list) {
			System.out.println(contatos);
		}
			
			
		System.out.println("==== TESTE 3 contato insert ====");
		Contato novoContato = new Contato(null, "Cami", "cami@gmail.com", "Av. Roosevelt 770");
		contatoDao.insert(novoContato);
		System.out.println("Inserido! Novo id = " + novoContato.getId());
		}
	}


