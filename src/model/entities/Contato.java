package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Contato implements Serializable {
	

	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private String email;
	private String endereco;
	
	public Contato() {
		
	}

	public Contato(Long id, String nome, String email, String endereco) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
	}

	public double getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Double.doubleToLongBits(id) == Double.doubleToLongBits(other.id);
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + ", nome=" + nome + ", email=" + email + ", endereco=" + endereco + "]";
	}


	
	
	
	
}
