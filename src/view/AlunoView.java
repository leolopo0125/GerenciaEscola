package view;
/**
 * @author leonardo
 * @since 20/02/2020
 * @version 0.1
 * 
 */

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


import controller.AlunoController;
import controller.CidadeController;
import controller.EstadoController;

public class AlunoView {

	private JFrame janela;
	private JPanel painelDaJanela;
	private JPanel painel1;
	private JPanel painel2;
	private JLabel lblNome;
	private JLabel lblTelefone;
	private JLabel lblDataNasc;
	private JLabel lblRG;
	private JLabel lblCPF;
	private JLabel lblSexo;
	private JLabel lblMatricula;
	private JButton cancelar;
	private JButton salvar;
	private JTextField txtNome;
	private JTextField txtDataNasc;
	private JTextField txtRG;
	private JTextField txtCPF;
	private JTextField txtTelefone;
	private JRadioButton rbtDiurno;
	private JRadioButton rbtNoturno;
	private JTextField txtLogradouro;
	private JTextField txtCep;
	private JTextField txtNum;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField txtMatricula;
	private JLabel lbltituloEnd;
	private JLabel lblCidade;
	private JLabel lblEstado;
	private JLabel lblLogradouro;
	private JLabel lblNum;
	private JLabel lblCep;
	private JLabel lblComplemento;
	private JLabel lblBairro;
	private JComboBox cboxEstado;
	private JComboBox cboxCidade;
	private JRadioButton rbtMasculino;
	private JRadioButton rbtFeminino;
	private ButtonGroup grpRadio;
	private JPasswordField jpwSenha;
	private JLabel jtfSenha;
	private JLabel lblSenha;
	private JPanel painelSexo;

	private JLabel lblTitulo;

	public void iniciaGui() {

		// criar instancias
		janela = new JFrame("Cadastro de Alunos");
		painelDaJanela = (JPanel) janela.getContentPane();
		painel1 = new JPanel();
		painel2 = new JPanel();

		lblTitulo = new JLabel("Dados do Aluno");
		lblNome = new JLabel();
		lblCPF = new JLabel();
		lblRG = new JLabel();
		lblDataNasc = new JLabel();

		lblTelefone = new JLabel();
		cancelar = new JButton("Cancelar");
		salvar = new JButton("Salvar");

		txtNome = new JTextField();
		txtDataNasc = new JTextField();
		txtRG = new JTextField();
		txtCPF = new JTextField();
		txtTelefone = new JTextField();

		rbtDiurno = new JRadioButton();
		rbtNoturno = new JRadioButton();
		grpRadio = new ButtonGroup();

		lbltituloEnd = new JLabel("Dados de endereço");
		lblCidade = new JLabel();
		lblEstado = new JLabel();
		lblTelefone = new JLabel();
		lblLogradouro = new JLabel();
		lblMatricula = new JLabel();
		lblNum = new JLabel();
		lblCep = new JLabel();
		lblComplemento = new JLabel();
		lblBairro = new JLabel();
		txtLogradouro = new JTextField();
		txtNum = new JTextField();
		txtCep = new JTextField();
		txtComplemento = new JTextField();
		txtBairro = new JTextField();
		txtMatricula = new JTextField();
		cboxEstado = new JComboBox();
		cboxCidade = new JComboBox();
		jtfSenha = new JLabel();
		jpwSenha = new JPasswordField();
		lblSenha = new JLabel();
		rbtMasculino = new JRadioButton();
		rbtFeminino = new JRadioButton();
		painelSexo = new JPanel();
		lblSexo = new JLabel();

		lblTitulo.setBounds(180, -20, 250, 80);
		lbltituloEnd.setBounds(180, 180, 250, 80);

		// DEFININDO LABELS DO PAINEL Aluno
		lblNome.setText("Nome:");
		lblNome.setBounds(5, 40, 70, 20);

		lblMatricula.setText("Matricula:");
		lblMatricula.setBounds(337, 40, 100, 20);

		lblDataNasc.setText("Data de Nasc:");
		lblDataNasc.setBounds(5, 66, 80, 20);

		lblRG.setText("RG:");
		lblRG.setBounds(197, 67, 85, 20);

		lblCPF.setText("CPF:");
		lblCPF.setBounds(337, 67, 80, 20);

		lblSexo.setText("Sexo");
		lblSexo.setBounds(327, 100, 80, 20);

		// definindo textfields com mascara


		try {
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("(##)#####-####");
			txtTelefone = new javax.swing.JFormattedTextField(dt);
		} catch (Exception e) {
		}
		txtTelefone.setBounds(95, 115, 100, 20);

		txtNome.setBounds(50, 43, 275, 20);

		try {
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("##/##/####");
			txtDataNasc = new javax.swing.JFormattedTextField(dt);
		} catch (Exception e) {
		}
		txtDataNasc.setBounds(100, 68, 75, 20);

		// formatação do campo rg
		try {
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("##.###.###-A");
			txtRG = new javax.swing.JFormattedTextField(dt);
		} catch (Exception e) {
		}
		txtRG.setBounds(227, 68, 85, 20);

		// formatação do campo CPF
		try {
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("###.###.###-##");
			txtCPF = new javax.swing.JFormattedTextField(dt);
		} catch (Exception e) {
		}
		txtCPF.setBounds(377, 68, 95, 20);

		jpwSenha.setBounds(95, 93, 100, 20);

		// definindo painel de cidade

		lblCidade.setText("Cidade");
		lblCidade.setBounds(340, 275, 80, 20);

		lblEstado.setText("Estado");
		lblEstado.setBounds(340, 248, 80, 20);

		lblLogradouro.setText("Logradouro");
		lblLogradouro.setBounds(5, 250, 80, 20);

		lblNum.setText("Numero");
		lblNum.setBounds(5, 275, 80, 20);

		lblCep.setText("Cep");
		lblCep.setBounds(5, 300, 80, 20);

		lblComplemento.setText("Complemento");
		lblComplemento.setBounds(5, 325, 80, 20);

		lblBairro.setText("Bairro");
		lblBairro.setBounds(5, 350, 80, 20);

		lblSenha.setText("Senha");
		lblSenha.setBounds(5, 90, 83, 20);

		lblTelefone.setText("Telefone");
		lblTelefone.setBounds(5, 114, 80, 20);

		// Declaração dos textfields

		txtMatricula.setBounds(410, 43, 95, 20);
		txtLogradouro.setBounds(95, 250, 200, 20);

		// formatação do campo CEP

		try {
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("#####-###");
			txtCep = new javax.swing.JFormattedTextField(dt);
		} catch (Exception e) {
		}
		txtCep.setBounds(95, 300, 70, 20);

		txtComplemento.setBounds(95, 325, 200, 20);

		txtBairro.setBounds(95, 350, 200, 20);

		txtNum.setBounds(95, 275, 200, 20);

		// configuração da combobox estados
		EstadoController ec = new EstadoController();

		String dadosEstado[] = ec.listarTodos().split(";");
		int e = 0;
		while (e < dadosEstado.length) {

			cboxEstado.addItem(dadosEstado[e]);

			e++;
		}

		cboxEstado.setSelectedIndex(-1);
		cboxEstado.setBounds(385, 250, 120, 20);
		cboxEstado.setMaximumRowCount(28);

		// configuração da combobox Cidades
		CidadeController cc = new CidadeController();

		String dadosCidade[] = cc.listarTodos().split(";");
		int c = 0;
		while (c < dadosCidade.length) {

			cboxCidade.addItem(dadosCidade[c]);

			c++;
		}

		cboxCidade.setSelectedIndex(-1);
		cboxCidade.setBounds(385, 275, 120, 20);
		cboxCidade.setMaximumRowCount(28);

		// declaração de radio buttons masculino e feminino
		rbtMasculino.setText("Masculino");
		rbtMasculino.setBounds(225, 103, 90, 20);

		rbtFeminino.setText("Feminino");
		rbtFeminino.setBounds(325, 103, 85, 20);

		// adição dos botões ao button group
		grpRadio.add(rbtMasculino);
		grpRadio.add(rbtFeminino);

		cancelar.setBounds(125, 385, 100, 20);
		cancelar.addActionListener(new ActionListener() {

		
			public void actionPerformed(ActionEvent e) {
				janela.setVisible(false);

			}
		});

		salvar.setBounds(259,385,100,20);

		salvar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					String uf = "";
					String sexo = "";
					String cidade = cboxCidade.getSelectedItem().toString().toUpperCase();
					String estado = cboxEstado.getSelectedItem().toString().toUpperCase();

					if (cidade.equals("SÃO PAULO")) {
						uf = "SP";
					} else if (cidade.equals("RIO DE JANEIRO")) {
						uf = "RJ";
					} else if (cidade.equals("DISTRITO FEDERAL")) {
						uf = "DF";
					}

					AlunoController al = new AlunoController();

					if (rbtFeminino.isSelected()) {
						sexo = "F";
					} else if (rbtMasculino.isSelected()) {
						sexo = "M";

					}

					al.consistirDados(txtMatricula.getText(), txtNome.getText(), txtDataNasc.getText(), sexo, cidade,
							estado, txtRG.getText(), txtCPF.getText(), txtTelefone.getText(), jpwSenha.getText(),
							txtNum.getText(), txtCep.getText(), txtComplemento.getText(), txtLogradouro.getText(),
							txtBairro.getText(), uf);
					
					txtMatricula.setText("");
					txtNome.setText("");
					txtDataNasc.setText("");
					txtRG.setText("");
					txtCPF.setText("");
					txtTelefone.setText("");
					jpwSenha.setText("");
					txtNum.setText("");
					txtCep.setText("");
					txtComplemento.setText("");
					txtLogradouro.setText("");
					txtBairro.setText("");
					cboxCidade.setSelectedIndex(-1);
					cboxEstado.setSelectedIndex(-1);
					rbtMasculino.setSelected(false);
					rbtFeminino.setSelected(false);
					

					JOptionPane.showMessageDialog(null, "Cadastro concluido com sucesso!", "Sucesso", 1);
				} catch (NullPointerException n) {
					JOptionPane.showMessageDialog(null, "Campos preenchidos incorretamente");
				} catch (NumberFormatException ne) {
					JOptionPane.showMessageDialog(null, "Formato inváido"); 
				}catch (StringIndexOutOfBoundsException si) {
					JOptionPane.showMessageDialog(null, "Selecione um sexo!");
				}
			}
		});
		
		painelSexo.setBounds(245, 125, 200, 50);
		painelSexo.setLayout(new GridLayout(1, 0, 0, 0));
		painelSexo.setBorder(BorderFactory.createEtchedBorder());
		painelSexo.add(rbtMasculino);
		painelSexo.add(rbtFeminino);

		painel1.setBounds(1, 1, 517, 205);
		painel1.setLayout(null);
		painel1.setBorder(BorderFactory.createEtchedBorder());

		painel2.setBounds(1, 206, 517, 205);
		painel2.setLayout(null);
		painel2.setBorder(BorderFactory.createEtchedBorder());

		painel1.add(lblTitulo);
		painel1.add(lblCPF);
		painel1.add(lblDataNasc);
		painel1.add(lblNome);
		painel1.add(lblRG);
		painel1.add(lblTelefone);
		painel1.add(txtCPF);
		painel1.add(txtDataNasc);
		painel1.add(txtNome);
		painel1.add(txtRG);
		painel1.add(txtTelefone);
		painel1.add(jtfSenha);
		painel1.add(lblSenha);
		painel1.add(jpwSenha);
		painel1.add(lblMatricula);
		painel1.add(txtMatricula);
		painel1.add(painelSexo);
		painel1.add(lblSexo);
		
		painelDaJanela.add(cancelar);
		painelDaJanela.add(salvar);
		painelDaJanela.add(lblCidade);
		painelDaJanela.add(lblEstado);
		painelDaJanela.add(lblTelefone);
		painelDaJanela.add(lblLogradouro);
		painelDaJanela.add(lblNum);
		painelDaJanela.add(lblComplemento);
		painelDaJanela.add(lblCep);
		painelDaJanela.add(lblBairro);
		painelDaJanela.add(txtLogradouro);
		painelDaJanela.add(txtCep);
		painelDaJanela.add(txtNum);
		painelDaJanela.add(txtComplemento);
		painelDaJanela.add(txtBairro);
		painelDaJanela.add(cboxEstado);
		painelDaJanela.add(cboxCidade);
		painelDaJanela.add(lbltituloEnd);

		// configuração do painel da janela
		painelDaJanela.setLayout(null);
		painelDaJanela.add(painel1);
		painelDaJanela.add(painel2);

		// configurações da tela
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setSize(new Dimension(525, 450));
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

	}

	public static void main(String[] args) {

	}

}
