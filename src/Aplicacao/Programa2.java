package Aplicacao;

import java.util.List;
import java.util.Scanner;

import model.dao.ContatoDao;
import model.dao.DaoFactory;
import model.entities.Contato;

public class Programa2 {

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

		System.out.println("===== TODOS OS CONTATOS DE SUA LISTA =====");
		List<Contato> list = contatoDao.findAll();
		for (Contato contatos : list) {
			System.out.println(contatos);
		}

		System.out.print("==== Informe a letra para encontrar contatos: ====");
		System.out.println();
		char letra = sc.nextLine().toUpperCase().charAt(0);
		List<Contato> contatosComLetra = contatoDao.findByFirstLetter(letra);
		System.out.println("===== CONTATOS COM A LETRA'" + letra + "' =====");
		for (Contato cont : contatosComLetra) {
			System.out.println(cont);
		}

		System.out.println();
		System.out.println("=====Informe o ID para encontrar um contato: =====");
		long idParaBuscar = sc.nextLong();
		Contato contatoEncontrado = contatoDao.findById(idParaBuscar);
		System.out.println("Contato encontrado:\n" + contatoEncontrado);

		System.out.print("=====Informe o ID do contato a ser atualizado: =====");
		long idParaAtualizar = sc.nextLong();
		Contato contatoParaAtualizar = contatoDao.findById(idParaAtualizar);

		if (contatoParaAtualizar != null) {
			System.out.print("=====Informe o novo nome: =====");
			sc.nextLine(); // Limpeza do buffer
			String novoNome = sc.nextLine();

			System.out.print("=====Informe o novo e-mail: =====");
			String novoEmail = sc.nextLine();

			System.out.print("=====Informe o novo endereço: =====");
			String novoEndereco = sc.nextLine();

			contatoParaAtualizar.setNome(novoNome);
			contatoParaAtualizar.setEmail(novoEmail);
			contatoParaAtualizar.setEndereco(novoEndereco);

			contatoDao.update(contatoParaAtualizar);
			System.out.println("Contato atualizado com sucesso!");
		} else {
			System.out.println("Contato não encontrado. Atualização cancelada.");
		}

		System.out.print("=====Informe o ID do contato a ser excluído: =====");
		long idParaExcluir = sc.nextLong();
		contatoDao.deleteById(idParaExcluir);
		System.out.println("Contato excluído com sucesso!");

		sc.close();
	}

}
