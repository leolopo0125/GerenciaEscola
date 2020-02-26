package controller;
/**controlador da classe faxineira
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

import model.Faxineira;
import model.Funcionario;
import view.RelatorioFuncionario;

public class FaxineiraController {
	public void inserirFaxineira(Funcionario func,Faxineira f) {

		File arquivo = new File("faxineira.txt");

		try {

			FileOutputStream arquivoOutput = new FileOutputStream(arquivo, true);
			PrintStream gravador = new PrintStream(arquivoOutput);

			gravador.print(func.getId());
			gravador.print(";");
			gravador.print(func.getNome());
			gravador.print(";");
			gravador.print(func.getDatanasc());
			gravador.print(";");
			gravador.print(f.getTurno());
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
		String faxineiraDados = "";
		try {
			RelatorioFuncionario rf = new RelatorioFuncionario();

			is = new FileInputStream("faxineira.txt");
			InputStreamReader isr = new InputStreamReader(is);

			BufferedReader leitor = new BufferedReader(isr);
			String texto = leitor.readLine();

			while (texto != null) {

				String dados[] = texto.split(";");
				faxineiraDados += dados[11] += ";";
				faxineiraDados += dados[1] += ";";
				faxineiraDados += dados[2] += ";";
				faxineiraDados += ",";

				texto = leitor.readLine();

			}

		} catch (FileNotFoundException e) {

			System.out.println("Arquivo de entrada não encontrado.");
//			e.printStackTrace();
		} catch (IOException e) {

//			e.printStackTrace();
		}

		return faxineiraDados;
	}


}
