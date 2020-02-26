package controller;
/**
 * controlador para criação e modificação de alunos
 * @author llopo
 * @since 18/02/2020
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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Aluno;
import model.Cidade;
import model.Data;
import model.Endereco;
import model.Estado;
import view.RelatorioAluno;

public class AlunoController {

	public void consistirDados(String matricula, String nome, String dataNasc, String sexo, String cidade,
			String estado, String rg, String cpf, String tel, String senha, String numero, String cep, String compl,
			String logradouro, String bairro, String uf) {

		char s = sexo.charAt(0);
		String dataN[] = dataNasc.split("/");
		int dia = Integer.parseInt(dataN[0]);
		int mes = Integer.parseInt(dataN[1]);
		int ano = Integer.parseInt(dataN[2]);
		Data d1 = new Data(dia, mes, ano);

		int num = Integer.parseInt(numero);

		// instanciando classes
		Aluno al = new Aluno();
		Endereco endereco = new Endereco();
		Cidade cd = new Cidade();
		Estado e = new Estado();

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
		al.setMatricula(matricula);
		al.setNome(nome);
		al.setSexo(s);
		al.setDataNascimento(d1);
		al.setEndereco(endereco);
		al.setCpf(cpf);
		al.setRg(rg);
		al.setTelefone(tel);
		al.setSenha(senha);
		
		if( matricula!="" ||  nome!=""  ||  dataNasc!=""  || sexo!="" ||  cidade!="" ||
				 estado!="" ||  rg!="" ||  cpf!="" ||  tel!="" ||  senha!="" ||  numero!="" ||  cep!="" ||  compl!="" ||
				 logradouro!="" ||  bairro!="" ||  uf!="" ) {

		inserirAluno(al);
		}else {JOptionPane.showMessageDialog(null, "Revise o(s) campo(s) em branco!");}

	}

	public void inserirAluno(Aluno a1) {

		File arquivo = new File("aluno.txt");

		try {

			FileOutputStream arquivoOutput = new FileOutputStream(arquivo, true);
			PrintStream gravador = new PrintStream(arquivoOutput);

			gravador.print(a1.getMatricula());
			gravador.print(";");
			gravador.print(a1.getNome());
			gravador.print(";");
			gravador.print(a1.getDataNascimento());
			gravador.print(";");
			gravador.print(a1.getSexo());
			gravador.print(";");
			gravador.print(a1.getEndereco().getEstado().getNome());
			gravador.print(";");
			gravador.print(a1.getEndereco().getCidade().getNome());
			gravador.print(";");
			gravador.print(a1.getEndereco().getLogradouro());
			gravador.print(";");
			gravador.print(a1.getEndereco().getBairro());
			gravador.print(";");
			gravador.print(a1.getEndereco().getCep());
			gravador.print(";");
			gravador.print(a1.getCpf());
			gravador.print(";");
			gravador.print(a1.getRg());
			gravador.print(";");
			gravador.print(a1.getTelefone());
			gravador.print(";");
			gravador.println(a1.getSenha());

			gravador.close();
			arquivoOutput.close();

		} catch (FileNotFoundException e) {

//			e.printStackTrace();
		} catch (IOException e) {

//			e.printStackTrace();
		}

	}

	public String listarTodos() {

		InputStream is;
		String alunoDados = "";
		try {
			RelatorioAluno ra = new RelatorioAluno();

			is = new FileInputStream("aluno.txt");
			InputStreamReader isr = new InputStreamReader(is);

			BufferedReader leitor = new BufferedReader(isr);
			String texto = leitor.readLine();

			while (texto != null) {

				String dados[] = texto.split(";");
				alunoDados += dados[0] += ";";
				alunoDados += dados[1] += ";";
				alunoDados += dados[2] += ";";
				alunoDados += ",";

				texto = leitor.readLine();

			}

		} catch (FileNotFoundException e) {

			System.out.println("Arquivo de entrada não encontrado.");
//			e.printStackTrace();
		} catch (IOException e) {

//			e.printStackTrace();
		}

		return alunoDados;
	}

	public void listarAniversariantes(int mes) {

		InputStream is;

		try {

			is = new FileInputStream("aluno.txt");
			InputStreamReader isr = new InputStreamReader(is);

			BufferedReader leitor = new BufferedReader(isr);
			String texto = leitor.readLine();

			while (texto != null) {

				String dados[] = texto.split(";");
				String data1[] = dados[2].split("/");

				int mA = Integer.parseInt(data1[1]);

				if (mA == mes) {
					System.out.println("Matricula do aluno: " + dados[0]);
					System.out.println("Nome do aluno: " + dados[1]);
					System.out.println("Data de nascimento do aluno: " + dados[2]);
					System.out.println("Sexo do aluno: " + dados[3]);
				}

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
