package controller;
/**
 * controlador para criação e modificação de funcionarios
 * @author llopo
 * @since 21/02/2020
 * @version 0.1
 * 
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import javax.swing.JTextField;

import model.Aluno;
import model.Cidade;
import model.Data;
import model.Endereco;
import model.Estado;
import model.Faxineira;
import model.Funcionario;
import model.Professor;
import model.Secretaria;

public class FuncionarioController {

	public void consistirDados(String nome, String dataNasc, String cidade, String estado, String rg, String cpf,
			String tel, String numero, String cep, String compl, String logradouro, String bairro, String uf,
			String profissao,String periodo,String materia,String ramal) {

		String dataN[] = dataNasc.split("/");
		int dia = Integer.parseInt(dataN[0]);
		int mes = Integer.parseInt(dataN[1]);
		int ano = Integer.parseInt(dataN[2]);
		Data d1 = new Data(dia, mes, ano);

		int num = Integer.parseInt(numero);

		// instanciando classes
		Funcionario func = new Funcionario();
		Endereco endereco = new Endereco();
		Cidade cd = new Cidade();
		Estado e = new Estado();
		Faxineira f = new Faxineira();
		Professor p = new Professor();
		Secretaria s = new Secretaria();

		// atribundo nome de cidade
		cd.setNome(cidade);
		e.setNome(estado);
		e.setUf(uf);

		// atribuindo campos do endereço

		endereco.setCep(cep);
		endereco.setBairro(bairro);
		endereco.setCidade(cd);
		endereco.setComplemento(compl);
		endereco.setEstado(e);
		endereco.setLogradouro(logradouro);

		endereco.setNumero(num);

		// atribuindo valores inseridos ao aluno

		func.setNome(nome);
		func.setDatanasc(d1);
		func.setEndereco(endereco);
		func.setCpf(cpf);
		func.setRg(rg);
		func.setTelefone(tel);

		String r = profissao;
		if (r.equals("PROFESSOR")) {

			func.setId(1);
			p.setMateria(materia);
			
		} else if (r.equals("FAXINEIRA")) {

			func.setId(3);
			f.setTurno(periodo);
			

		} else if (r.equals("SECRETARIA")) {
			int ramal1= Integer.parseInt(ramal);
			func.setId(2);
			s.setRamal(ramal1);
		}

		if (func.getId() == 1) {

			new ProfessorController().inserirProfessor(func,p);
		} else if (func.getId() == 2) {
			new SecretariaController().inserirSecretaria(func,s);
		}else if (func.getId()==3) {
			new FaxineiraController().inserirFaxineira(func,f);
		}
	}

	
	public void listarTodos() {

		InputStream is;

		try {

			is = new FileInputStream("professor.txt");
			InputStreamReader isr = new InputStreamReader(is);

			BufferedReader leitor = new BufferedReader(isr);
			String texto = leitor.readLine();

			while (texto != null) {

				String dados[] = texto.split(";");
				System.out.println("Matricula do aluno: " + dados[0]);
				System.out.println("Nome do aluno: " + dados[1]);
				System.out.println("Data de nascimento do aluno: " + dados[2]);
				System.out.println("Sexo do aluno: " + dados[3]);
				texto = leitor.readLine();
			}

		} catch (FileNotFoundException e) {

			System.out.println("Arquivo de entrada não encontrado.");
//			e.printStackTrace();
		} catch (IOException e) {

//			e.printStackTrace();
		}

	}

}
