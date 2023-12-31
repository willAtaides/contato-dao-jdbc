package Aplicacao;

import java.util.List;
import java.util.Scanner;

import model.dao.ContatoDao;
import model.dao.DaoFactory;
import model.entities.Contato;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
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

		System.out.println("==== TESTE 4 contato update ====");
		contato = contatoDao.findById(25);
		contato.setNome("Camila");
		contatoDao.update(contato);
		System.out.println("Update completo");

		System.out.println("==== TESTE 4 contato delete ====");
		System.out.println("Entre com o id que deseja deletar: ");
		Long id = sc.nextLong();
		contatoDao.deleteById(id);
		System.out.println("Delete completo");
		
		System.out.println("==== TESTE 5 contato findByFirstLetter ====");
		List<Contato> contatosComLetraA = contatoDao.findByFirstLetter('C');
		for (Contato cont : contatosComLetraA) {
		    System.out.println(cont);
		}
		
		sc.close();
	}
}
