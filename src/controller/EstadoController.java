package controller;
/**
 * classe de controle dos estados
 * @author llopo
 * @since 26/02/2020
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

import javax.swing.JOptionPane;

import model.Cidade;
import model.Estado;
import model.Funcionario;
import view.RelatorioFuncionario;

public class EstadoController {

	public void recebeEstado(String estado, String uf) {
		Estado e1 = new Estado();
		e1.setNome(estado);
		e1.setUf(uf);

		inserirEstado(e1);

	}

	public void inserirEstado(Estado estado) {

		File arquivo = new File("estado.txt");

		try {

			FileOutputStream arquivoOutput = new FileOutputStream(arquivo, true);
			PrintStream gravador = new PrintStream(arquivoOutput);

			gravador.print(estado.getNome());
			gravador.print("-");
			gravador.print(estado.getUf());
			gravador.print(";");

			gravador.close();
			JOptionPane.showMessageDialog(null, "Estado cadastrado com sucesso");
			arquivoOutput.close();

		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}

	}

	public String listarTodos() {

		InputStream is;
		String estdados = "";
		try {

			is = new FileInputStream("estado.txt");
			InputStreamReader isr = new InputStreamReader(is);

			BufferedReader leitor = new BufferedReader(isr);
			String texto = leitor.readLine();

			while (texto != null) {

				estdados += texto;

				texto = leitor.readLine();

			}

		} catch (FileNotFoundException e) {

			System.out.println("Arquivo de entrada não encontrado.");
//			e.printStackTrace();
		} catch (IOException e) {

//			e.printStackTrace();
		}

		return estdados;
	}

}
