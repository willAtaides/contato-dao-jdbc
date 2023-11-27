package Aplicacao;

import java.util.Scanner;

import model.dao.ContatoDao;
import model.dao.DaoFactory;

public class ExcluaContato {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ContatoDao contatoDao = DaoFactory.createContatoDao();
		
		System.out.print("=====Informe o ID do contato a ser excluído: =====");
		long idParaExcluir = sc.nextLong();
		contatoDao.deleteById(idParaExcluir);
		System.out.println("Contato excluído com sucesso!");

		sc.close();
	}

}
