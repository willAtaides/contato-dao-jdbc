package Aplicacao;

import java.util.Scanner;

import model.dao.ContatoDao;
import model.dao.DaoFactory;
import model.entities.Contato;

public class UpdateContato {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ContatoDao contatoDao = DaoFactory.createContatoDao();
		
		System.out.print("=====Informe o ID do contato a ser atualizado: =====");
		long idParaAtualizar = sc.nextLong();
		Contato contatoParaAtualizar = contatoDao.findById(idParaAtualizar);

		if (contatoParaAtualizar != null) {
			System.out.print("=====Informe o novo nome: =====");
			sc.nextLine(); 
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
		
		sc.close();
	}

}
