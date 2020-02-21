package view;

/**
 * Pacote de interface grafica do Funcionario
 * @author llopo
 * @since 19/02/2020
 * @version 0.1
 * 
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextField;


import controller.AlunoController;

public class FuncionarioView {

//declaração dos componentes da interface	
	private JFrame janela;
	private JPanel painelDaJanela;
	private JButton salvar;
	private JButton cancelar;
	private JTextField txtSalario;
	private JTextField txtNome;
	private JTextField txtDataNasc;
	private JTextField txtRG;
	private JTextField txtCPF;
	private JTextField txtLogradouro;
	private JTextField txtCep;
	private JTextField txtNum;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField txtTelefone;
	private JLabel titulo;
	private JLabel tituloEnd;
	private JLabel lblSalario;
	private JLabel lblNome;
	private JLabel lblDataNasc;
	private JLabel lblRG;
	private JLabel lblCPF;
	private JLabel lblCidade;
	private JLabel lblEstado;
	private JLabel lblTelefone;
	private JLabel lblLogradouro;
	private JLabel lblNum;
	private JLabel lblCep;
	private JLabel lblComplemento;
	private JLabel lblBairro;
	private JLabel lblProfissao;
	private JComboBox cboxEstado;
	private JComboBox cboxCidade;
	private JComboBox cboxProfissao;

//declaração de vetores auxiliares
	String estados[] = { "São Paulo", "Rio de Janeiro", "Distrito Federal" };

	String cidadeSP[] = { "Araraquara", "Carapicuiba", "Lagoinha", "Osasco" };
	
	String profissao[]= {"Professor","Secretaria","Faxineira"};

	public void iniciaGui() {

		// criar as instancias
		janela = new JFrame("Cadastro de alunos");
		salvar = new JButton();
		cancelar = new JButton();
		titulo = new JLabel();
		tituloEnd = new JLabel();
		lblSalario = new JLabel();
		lblNome = new JLabel();
		lblDataNasc = new JLabel();
		lblRG = new JLabel();
		lblCPF = new JLabel();
		lblCidade = new JLabel();
		lblEstado = new JLabel();
		lblTelefone = new JLabel();
		lblLogradouro = new JLabel();
		lblNum = new JLabel();
		lblCep = new JLabel();
		lblComplemento = new JLabel();
		lblBairro = new JLabel();
		lblProfissao = new JLabel();
		txtSalario = new JTextField();
		txtNome = new JTextField();
		txtDataNasc = new JTextField();
		txtRG = new JTextField();
		txtCPF = new JTextField();
		txtLogradouro = new JTextField();
		txtNum = new JTextField();
		txtCep = new JTextField();
		txtComplemento = new JTextField();
		txtBairro = new JTextField();
		txtTelefone = new JTextField();
		cboxEstado = new JComboBox(estados);
		cboxCidade = new JComboBox(cidadeSP);
		cboxProfissao = new JComboBox(profissao);

		painelDaJanela = (JPanel) janela.getContentPane();

		// Declaração dos botoes
		salvar.setText("Salvar");
		salvar.setBounds(125, 400, 100, 20);

		salvar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
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

			}
		});

		// Adicionando Listener
		cancelar.setText("Cancelar");
		cancelar.setBounds(240, 400, 100, 20);

		cancelar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null, "Cadastro finalizado!","Fim cadastro!",0);
				janela.dispose();

			}
		});

		// Declaração das labels

		titulo.setText("______________________Informações de endereço______________________________________");
		titulo.setBounds(0, 175, 525, 60);

		tituloEnd.setText("_______________________Informações do Funcionario________________________________");
		tituloEnd.setBounds(0, 5, 525, 20);

		lblNome.setText("Nome:");
		lblNome.setBounds(5, 40, 70, 20);

		lblTelefone.setText("Telefone");
		lblTelefone.setBounds(337, 40, 100, 20);
		
		lblSalario.setText("Salario:");
		lblSalario.setBounds(5, 104, 80, 20);
//		lblMatricula.setForeground(new Color(244, 82, 10));

		lblDataNasc.setText("Data de Nasc:");
		lblDataNasc.setBounds(5, 72, 80, 20);
//		lblDataNasc.setForeground(new Color(244, 82, 10));

		lblRG.setText("RG:");
		lblRG.setBounds(197, 72, 85, 20);
//		lblRG.setForeground(new Color(244, 82, 10));

		lblCPF.setText("CPF:");
		lblCPF.setBounds(337, 72, 80, 20);
//		lblCPF.setForeground(new Color(244, 82, 10));
//
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

		// Declaração dos textfields
		

		txtSalario.setBounds(60, 105, 100, 20);

		try {
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("(##)#####-####");
			txtTelefone = new javax.swing.JFormattedTextField(dt);
		} catch (Exception e) {
		}
		txtTelefone.setBounds(390, 43, 110, 20);

		txtNome.setBounds(50, 43, 275, 20);

		try {
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("##/##/####");
			txtDataNasc = new javax.swing.JFormattedTextField(dt);
		} catch (Exception e) {
		}
		txtDataNasc.setBounds(100, 73, 75, 20);

		// formatação do campo rg
		try {
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("##.###.###-A");
			txtRG = new javax.swing.JFormattedTextField(dt);
		} catch (Exception e) {
		}
		txtRG.setBounds(227, 73, 85, 20);

		// formatação do campo CPF
		try {
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("###.###.###-##");
			txtCPF = new javax.swing.JFormattedTextField(dt);
		} catch (Exception e) {
		}
		txtCPF.setBounds(377, 73, 95, 20);

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

		cboxEstado.setSelectedIndex(-1);
		cboxEstado.setBounds(385, 250, 120, 20);
		cboxEstado.setMaximumRowCount(28);

		// configuração da combobox Cidades

		cboxCidade.setSelectedIndex(-1);
		cboxCidade.setBounds(385, 275, 120, 20);
		cboxCidade.setMaximumRowCount(28);

		// configuração da combobox Profissao
		
		cboxProfissao.setSelectedIndex(-1);
		cboxProfissao.setBounds(200, 115, 100, 20);
		cboxProfissao.setMaximumRowCount(3);

		// adicionando componentes no painel da tela

		painelDaJanela.add(lblSalario);
		painelDaJanela.add(titulo);
		painelDaJanela.add(tituloEnd);
		painelDaJanela.add(lblNome);
		painelDaJanela.add(lblDataNasc);
		painelDaJanela.add(lblRG);
		painelDaJanela.add(lblCPF);
		painelDaJanela.add(lblCidade);
		painelDaJanela.add(lblEstado);
		painelDaJanela.add(lblTelefone);
		painelDaJanela.add(lblLogradouro);
		painelDaJanela.add(lblNum);
		painelDaJanela.add(lblComplemento);
		painelDaJanela.add(lblCep);
		painelDaJanela.add(lblBairro);
		painelDaJanela.add(txtSalario);
		painelDaJanela.add(txtNome);
		painelDaJanela.add(txtDataNasc);
		painelDaJanela.add(txtRG);
		painelDaJanela.add(txtCPF);
		painelDaJanela.add(txtLogradouro);
		painelDaJanela.add(txtCep);
		painelDaJanela.add(txtNum);
		painelDaJanela.add(txtComplemento);
		painelDaJanela.add(txtTelefone);
		painelDaJanela.add(txtBairro);
		painelDaJanela.add(salvar);
		painelDaJanela.add(cancelar);
		painelDaJanela.add(cboxEstado);
		painelDaJanela.add(cboxCidade);
		painelDaJanela.add(cboxProfissao);

		// configurações do painel da tela
		painelDaJanela.setLayout(null);

		// configurações da tela

		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setSize(525, 500);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);

		janela = new JFrame("Cadastro de Aluno");
		janela.getContentPane().setLayout(null);
		janela.setLocationRelativeTo(null);

	
	
	}// fim do inicia gui
public static void main(String[] args) {
	
	new FuncionarioView().iniciaGui();
	
}
	
}
