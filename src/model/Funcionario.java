package model;
/**
 * Classe modelo de funcionario
 * @author llopo
 *@since 26/02/2020
 *@version 0.1
 */

public class Funcionario {
	private int id;
	private String nome;
	private String cpf;
	private String rg;
	private Data datanasc;
	private String telefone;
	private Endereco endereco;
	private double salario;

//construtor sem parametros	
	public Funcionario() {

		System.out.println("Funcionario criado.");

	}
//construtor com parametros

//getters and setters
	public String getNome() {
		return nome;
	}

	public Funcionario(int id, String nome, String cpf, String rg, Data datanasc, String telefone, Endereco endereco,
			double salario) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.datanasc = datanasc;
		this.telefone = telefone;
		this.endereco = endereco;
		this.salario = salario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Data getDatanasc() {
		return datanasc;
	}

	public void setDatanasc(Data datanasc) {
		this.datanasc = datanasc;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void exibe() {
		System.out.println("Nome do funcionario: " + nome);
		System.out.println("CPF do funcionario: " + cpf);
		System.out.println("Salário do funcionario: " + salario);

	}

}
