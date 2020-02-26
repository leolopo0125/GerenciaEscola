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

import javax.swing.JOptionPane;

import model.Cidade;
import model.Funcionario;
import view.RelatorioFuncionario;

public class CidadeController {
	
	public void recebeCidade(String cidade) {
		Cidade c1 = new Cidade();
		c1.setNome(cidade);
		
		inserirCidade(c1);
		
	}
	
	
	
	public void inserirCidade(Cidade cidade) {

		File arquivo = new File("cidade.txt");

		try {

			FileOutputStream arquivoOutput = new FileOutputStream(arquivo, true);
			PrintStream gravador = new PrintStream(arquivoOutput);

			gravador.print(cidade.getNome());
			gravador.print(";");

			gravador.close();
			JOptionPane.showMessageDialog(null, "Cidade cadastrada com sucesso");
			arquivoOutput.close();

		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}
		
		
		

	}
	
	public String listarTodos() {

		InputStream is;
		String ciddados = "";
		try {
		
			is = new FileInputStream("cidade.txt");
			InputStreamReader isr = new InputStreamReader(is);

			BufferedReader leitor = new BufferedReader(isr);
			String texto = leitor.readLine();

			while (texto != null) {

				 ciddados += texto;
				  
				texto = leitor.readLine();

			}

		} catch (FileNotFoundException e) {

			System.out.println("Arquivo de entrada não encontrado.");
//			e.printStackTrace();
		} catch (IOException e) {

//			e.printStackTrace();
		}

		return ciddados;
	}

}
	

