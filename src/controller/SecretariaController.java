package controller;

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
import model.Secretaria;
import view.RelatorioFuncionario;

/**
 * classe responsavel pela criação de secretarias
 * @author leonardo
 *@since 25/02/2020
 *@version 0.1
 */

public class SecretariaController {
	

	public void inserirSecretaria(Funcionario func,Secretaria s) {

		File arquivo = new File("secretaria.txt");

		try {

			FileOutputStream arquivoOutput = new FileOutputStream(arquivo, true);
			PrintStream gravador = new PrintStream(arquivoOutput);

			gravador.print(func.getId());
			gravador.print(";");
			gravador.print(func.getNome());
			gravador.print(";");
			gravador.print(func.getDatanasc());
			gravador.print(";");
			gravador.print(s.getRamal());
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
		String dadosSecretaria = "";
		try {
			RelatorioFuncionario rf = new RelatorioFuncionario();

			is = new FileInputStream("secretaria.txt");
			InputStreamReader isr = new InputStreamReader(is);

			BufferedReader leitor = new BufferedReader(isr);
			String texto = leitor.readLine();

			while (texto != null) {

				String dados[] = texto.split(";");
				dadosSecretaria += dados[11] += ";";
				dadosSecretaria += dados[1] += ";";
				dadosSecretaria += dados[2] += ";";
				dadosSecretaria += ",";

				texto = leitor.readLine();

			}

		} catch (FileNotFoundException e) {

			System.out.println("Arquivo de entrada não encontrado.");
//			e.printStackTrace();
		} catch (IOException e) {

//			e.printStackTrace();
		}

		return dadosSecretaria;
	}

}
