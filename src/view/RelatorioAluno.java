package view;
/**
 * @author llopo
 * @since 26/02/2020
 * @version 0.1
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.AlunoController;

public class RelatorioAluno {

	private JFrame janela;
	private JPanel painelDaJanela;
	private JTable tabela;
	private String[] colunas = new String[] { "Matricula", "Nome", "Data de nascimento" };
	private JButton botaoConfirmar;
	private JScrollPane painelDeScroll;


	
	public void iniciaGui() {
		
		AlunoController ac = new AlunoController();
		
		janela = new JFrame("Relatório de alunos");
		tabela = new JTable();
		botaoConfirmar = new JButton("Confirmar");

		painelDaJanela = (JPanel) janela.getContentPane();
		
		DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
		tabela = new JTable(modelo);
		
		String dadosAluno[] = ac.listarTodos().split(",");
        int i=0;
        while(i<dadosAluno.length) {

                String nomeAluno[] = dadosAluno[i].split(";");


                modelo.addRow(nomeAluno);

                i++;
        }
		
		tabela.setEnabled(false);

		// instanciando e inserindo a tabela no scroll
		painelDeScroll = new JScrollPane(tabela);
		painelDeScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		// configuração dos componentes da tela
		painelDeScroll.setBounds(1, 5, 381, 200);
		tabela.setBounds(-10, 30, 300, 200);
		botaoConfirmar.setBounds(145, 215, 100, 30);
		botaoConfirmar.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				janela.dispose();
				
			}
		});

		// configurações do painel de janela

		painelDaJanela.setLayout(null);
		painelDaJanela.add(painelDeScroll);
		painelDaJanela.add(botaoConfirmar);
		
		

		// configurações da janela
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
		janela.setVisible(true);
		janela.setSize(400, 300);
		janela.setLocationRelativeTo(null);

	}// fim do metodo inicia gui
	


	public static void main(String[] args) {
		new RelatorioAluno().iniciaGui();
	}

}
