package model;
/**
 * Classe modelo de cidade
 * @author llopo
 * @since 26/02/2020
 * @version 0.1
 *
 */

public class Cidade {
	private String nome;

	public Cidade() {

	}

	public Cidade(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
