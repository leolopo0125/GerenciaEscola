package controller;
/**
 *classe responsavel pela criação de professores
 * @author leonardo
 * @since 24/02/2020
 * @version 0.1
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

import model.Funcionario;


import model.Professor;
import view.RelatorioAluno;
import view.RelatorioFuncionario;

public class ProfessorController {
	
	public void inserirProfessor(Funcionario func,Professor p) {

		File arquivo = new File("professor.txt");

		try {

			FileOutputStream arquivoOutput = new FileOutputStream(arquivo, true);
			PrintStream gravador = new PrintStream(arquivoOutput);

			gravador.print(func.getId());
			gravador.print(";");
			gravador.print(func.getNome());
			gravador.print(";");
			gravador.print(func.getDatanasc());
			gravador.print(";");
			gravador.print(p.getMateria());
			gravador.print(";");
			gravador.print(func.getEndereco().getEstado().getNome());
			gravador.print(";");
			gravador.print(func.getEndereco().getCidade().getNome());
			gravador.print(";");
			gravador.print(func.getEndereco().getLogradouro());
			gravador.print(";");
			gravador.print(func.getEndereco().getBairro());
			gravador.print(";");
			gravador.print(func.getEndereco().getCep());
			gravador.print(";");
			gravador.print(func.getCpf());
			gravador.print(";");
			gravador.print(func.getRg());
			gravador.print(";");
			gravador.print(func.getTelefone());
			gravador.println(";");
		

			gravador.close();
			arquivoOutput.close();

		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}

	}
	
	public String listarTodos() {

		InputStream is;
		String professorDados = "";
		try {
			RelatorioFuncionario rf = new RelatorioFuncionario();

			is = new FileInputStream("professor.txt");
			InputStreamReader isr = new InputStreamReader(is);

			BufferedReader leitor = new BufferedReader(isr);
			String texto = leitor.readLine();

			while (texto != null) {

				String dados[] = texto.split(";");
				professorDados += dados[11] += ";";
				professorDados += dados[1] += ";";
				professorDados += dados[2] += ";";
				professorDados += ",";

				texto = leitor.readLine();

			}

		} catch (FileNotFoundException e) {

			System.out.println("Arquivo de entrada não encontrado.");
//			e.printStackTrace();
		} catch (IOException e) {

//			e.printStackTrace();
		}

		return professorDados;
	}

}
