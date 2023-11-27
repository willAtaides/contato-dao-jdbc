package Aplicacao;

import java.util.Scanner;

import model.dao.ContatoDao;
import model.dao.DaoFactory;
import model.entities.Contato;

public class EncontrarContatoId {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ContatoDao contatoDao = DaoFactory.createContatoDao();
		
		System.out.println("=====Informe o ID para encontrar um contato: =====");
		long idParaBuscar = sc.nextLong();
		Contato contatoEncontrado = contatoDao.findById(idParaBuscar);
		System.out.println("Contato encontrado:\n" + contatoEncontrado);
		
		sc.close();

	}

}
