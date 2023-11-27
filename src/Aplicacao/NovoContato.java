package Aplicacao;

import java.util.Scanner;

import model.dao.ContatoDao;
import model.dao.DaoFactory;
import model.entities.Contato;

public class NovoContato {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ContatoDao contatoDao = DaoFactory.createContatoDao();

		System.out.println("==== Entre com os dados do novo Contato: ====");
		System.out.println();

		System.out.println("==== Informe o nome:  ====");
		String nome = sc.nextLine();

		System.out.println("==== Informe o e-mail:  ====");
		String email = sc.nextLine();

		System.out.println("==== Informe o endereço:  ====");
		String endereco = sc.nextLine();

		Contato novoContato = new Contato(null, nome, email, endereco);
		contatoDao.insert(novoContato);
		System.out.println("Inserido! Novo id = " + novoContato.getId());
		sc.close();
	}

}
