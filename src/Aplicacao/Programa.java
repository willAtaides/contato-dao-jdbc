package Aplicacao;

import model.dao.ContatoDao;
import model.dao.DaoFactory;
import model.entities.Contato;

public class Programa {

	public static void main(String[] args) {
		
		Contato contato1 = new Contato(1, "Willian", "sg552.santos@gmail.com","av.roosevelt 770");
		
		ContatoDao contato = DaoFactory.createContatoDao();
		
		System.out.println(contato1);
		}

}
