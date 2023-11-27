package Aplicacao;

import java.util.List;
import java.util.Scanner;

import model.dao.ContatoDao;
import model.dao.DaoFactory;
import model.entities.Contato;

public class EncontrarContatoLetra {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ContatoDao contatoDao = DaoFactory.createContatoDao();
		
		System.out.print("==== Informe a letra para encontrar contatos: ====");
		System.out.println();
		char letra = sc.nextLine().toUpperCase().charAt(0);
		List<Contato> contatosComLetra = contatoDao.findByFirstLetter(letra);
		System.out.println("===== CONTATOS COM A LETRA'" + letra + "' =====");
		for (Contato cont : contatosComLetra) {
			System.out.println(cont);
		}
		sc.close();
	}
}
