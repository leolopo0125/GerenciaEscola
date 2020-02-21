package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


public class PainelTeste {
	
	private JFrame janela;
	private JPanel painelDaJanela;
	private JPanel painel1;
	private JPanel painel2;
	
	private JLabel teste;
	private JLabel teste2;
	
	private JTextField txtSecretaria;
	private JTextField txtProfessor;

	public void iniciaGui() {

		// criar instancias
		janela = new JFrame();
		painelDaJanela = (JPanel) janela.getContentPane();
		painel1 = new JPanel();
		painel2 = new JPanel();

		teste = new JLabel("Ramal");
		teste2 = new JLabel("Materia");
		
		txtSecretaria = new JTextField();
		txtProfessor = new JTextField();

		teste.setBounds(75,-20,100,80);
		teste2.setBounds(75,-20,100,80);
		
		txtProfessor.setBounds(30, 45, 145, 30);
		txtSecretaria.setBounds(30, 45, 145, 30);

		painel1.setBounds(4, 6, 200, 100);
		painel1.setLayout(null);
		painel1.setBorder(BorderFactory.createEtchedBorder());
		
		painel1.add(txtSecretaria);
		painel1.add(teste);
		
		painel2.setBounds(208, 6, 200, 100);
		painel2.setLayout(null);
		painel2.setBorder(BorderFactory.createEtchedBorder());
	
		painel2.add(txtProfessor);
		painel2.add(teste2);	
		// configuração do painel da janela
		painelDaJanela.setLayout(null);
		painelDaJanela.add(painel1);
		painelDaJanela.add(painel2);


		// configurações da tela
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(new Dimension(422, 246));
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

	}

	public static void main(String[] args) {
		new PainelTeste().iniciaGui();
	}

}
