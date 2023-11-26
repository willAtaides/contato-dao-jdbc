package model.dao;

import java.util.List;

import model.entities.Contato;

public interface ContatoDao {
	void insert(Contato contato);
	void update(Contato contato);
	void deleteById(long id);
	Contato findById(long id);
	List<Contato> findAll();
	List<Contato> findByFirstLetter(char firstLetter);
}
