package view;

/**classe de visualização de funcionarios
 * @author llopo
 * @version 0.1
 * @since 26/02/2020
 */

import java.awt.Dimension;
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
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.AlunoController;
import controller.CidadeController;
import controller.EstadoController;
import controller.FuncionarioController;

public class FuncionarioView {

	private JFrame janela;
	private JPanel painelDaJanela;
	private JPanel painel1;
	private JPanel painel2;
	private JPanel painelFaxineira;
	private JLabel lblNome;
	private JLabel lblTelefone;
	private JLabel lblSalario;
	private JLabel lblDataNasc;
	private JLabel lblRG;
	private JLabel lblCPF;
	private JLabel lblProfissao;
	private JButton cancelar;
	private JButton salvar;
	private JTextField txtSalario;
	private JTextField txtNome;
	private JTextField txtDataNasc;
	private JTextField txtRG;
	private JTextField txtCPF;
	private JTextField txtTelefone;
	private JComboBox cboxProfissao;
	private JLabel lblSecretaria;
	private JLabel lblProfessor;
	private JTextField txtSecretaria;
	private JTextField txtProfessor;
	private JPanel painelSec;
	private JPanel painelProf;
	private JLabel lblPeriodo;
	private JRadioButton rbtDiurno;
	private JRadioButton rbtNoturno;
	private ButtonGroup grpRadio;
	private JTextField txtLogradouro;
	private JTextField txtCep;
	private JTextField txtNum;
	private JTextField txtComplemento;
	private JTextField txtBairro;
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

	private JLabel lblTitulo;
	
	CidadeController cc = new CidadeController();

	String dadosCidade[] = cc.listarTodos().split(",");

	String profissao[] = { "Professor", "Secretaria", "Faxineira" };


//	String cidadeSP[] = { "Araraquara", "Carapicuiba", "Lagoinha", "Osasco" };

	public void iniciaGui() {

		// criar instancias
		janela = new JFrame("Cadastro de funcionario");
		painelDaJanela = (JPanel) janela.getContentPane();
		painel1 = new JPanel();
		painel2 = new JPanel();

		lblTitulo = new JLabel("Dados do Funcionario");
		lblNome = new JLabel();
		lblCPF = new JLabel();
		lblRG = new JLabel();
		lblDataNasc = new JLabel();
		lblSalario = new JLabel();
		lblProfissao = new JLabel();
		lblTelefone = new JLabel();
		cancelar = new JButton("Cancelar");
		salvar = new JButton("Salvar");

		txtSalario = new JTextField();
		txtNome = new JTextField();
		txtDataNasc = new JTextField();
		txtRG = new JTextField();
		txtCPF = new JTextField();
		txtTelefone = new JTextField();
		cboxProfissao = new JComboBox(profissao);

		lblPeriodo = new JLabel("Período");
		rbtDiurno = new JRadioButton();
		rbtNoturno = new JRadioButton();
		grpRadio = new ButtonGroup();

		lbltituloEnd = new JLabel("Dados de endereço");
		lblCidade = new JLabel();
		lblEstado = new JLabel();
		lblTelefone = new JLabel();
		lblLogradouro = new JLabel();
		lblProfissao = new JLabel();
		lblNum = new JLabel();
		lblCep = new JLabel();
		lblComplemento = new JLabel();
		lblBairro = new JLabel();
		lblProfissao = new JLabel();
		txtLogradouro = new JTextField();
		txtNum = new JTextField();
		txtCep = new JTextField();
		txtComplemento = new JTextField();
		txtBairro = new JTextField();
		cboxEstado = new JComboBox();
		cboxCidade = new JComboBox();

		painelFaxineira = new JPanel();

		lblTitulo.setBounds(180, -20, 250, 80);
		lbltituloEnd.setBounds(180, 180, 250, 80);

		// DEFININDO LABELS DO PAINEL FUNCIONARIO
		lblNome.setText("Nome:");
		lblNome.setBounds(5, 40, 70, 20);

		lblTelefone.setText("Telefone");
		lblTelefone.setBounds(337, 40, 100, 20);

		lblSalario.setText("Salario:");
		lblSalario.setBounds(175, 103, 80, 20);

		lblDataNasc.setText("Data de Nasc:");
		lblDataNasc.setBounds(5, 72, 80, 20);

		lblRG.setText("RG:");
		lblRG.setBounds(197, 72, 85, 20);

		lblCPF.setText("CPF:");
		lblCPF.setBounds(337, 72, 80, 20);

		lblProfissao.setText("Profissao");
		lblProfissao.setBounds(5, 103, 80, 20);

		// definindo textfields com mascara

		txtSalario.setBounds(225, 105, 100, 20);

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

		// definindo propriedades da combobox
		// configuração da combobox Profissao

		cboxProfissao.setSelectedIndex(-1);
		cboxProfissao.setBounds(65, 103, 100, 20);
		cboxProfissao.setMaximumRowCount(3);
		cboxProfissao.addActionListener(cbActionListener);

		// adicionando componentes ao painel da faxineira

		lblPeriodo.setBounds(25, 0, 50, 30);
		painelFaxineira.setBounds(374, 100, 100, 100);
		painelFaxineira.setVisible(false);
		painelFaxineira.setLayout(null);
		painelFaxineira.setBorder(BorderFactory.createEtchedBorder());
		painelFaxineira.add(lblPeriodo);
		painelFaxineira.add(rbtNoturno);
		painelFaxineira.add(rbtDiurno);

		// paineis de secretaria e professor
		lblSecretaria = new JLabel("Ramal");
		lblProfessor = new JLabel("Materia");
		painelSec = new JPanel();
		painelProf = new JPanel();

		txtSecretaria = new JTextField();
		txtProfessor = new JTextField();

		lblSecretaria.setBounds(65, -20, 100, 80);
		lblProfessor.setBounds(65, -20, 100, 80);

		txtProfessor.setBounds(10, 45, 153, 30);
		txtSecretaria.setBounds(30, 45, 125, 30);

		// painel do ramal
		painelSec.setBounds(330, 100, 170, 100);
		painelSec.setLayout(null);
		painelSec.setBorder(BorderFactory.createEtchedBorder());
		painelSec.setVisible(false);

		painelSec.add(txtSecretaria);
		painelSec.add(lblSecretaria);

		painelProf.setBounds(330, 100, 170, 100);
		painelProf.setLayout(null);
		painelProf.setBorder(BorderFactory.createEtchedBorder());
		painelProf.setVisible(false);

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

		// declação dos radio buttons
		rbtDiurno.setText("Diurno   ");
		rbtDiurno.setBounds(10, 30, 80, 20);

		rbtNoturno.setText("Noturno");
		rbtNoturno.setBounds(10, 60, 80, 20);

		// adicionando botões ao button group
		grpRadio.add(rbtDiurno);
		grpRadio.add(rbtNoturno);

		cancelar.setBounds(125, 385, 100, 20);
		cancelar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				janela.setVisible(false);

			}
		});

		salvar.setBounds(259, 385, 100, 20);

		salvar.addActionListener(svActionListener);

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
		painel1.add(lblProfissao);
		painel1.add(lblRG);
		painel1.add(lblSalario);
		painel1.add(lblTelefone);
		painel1.add(txtCPF);
		painel1.add(txtDataNasc);
		painel1.add(txtNome);
		painel1.add(txtRG);
		painel1.add(txtSalario);
		painel1.add(txtTelefone);
		painel1.add(cboxProfissao);

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
		painelDaJanela.add(lblProfissao);
		painelDaJanela.add(txtLogradouro);
		painelDaJanela.add(txtCep);
		painelDaJanela.add(txtNum);
		painelDaJanela.add(txtComplemento);
		painelDaJanela.add(txtBairro);
		painelDaJanela.add(cboxEstado);
		painelDaJanela.add(cboxCidade);
		painelDaJanela.add(lbltituloEnd);

		// adicionando paineis auxiliares
		painelDaJanela.add(painelFaxineira);
		painelProf.add(txtProfessor);
		painelProf.add(lblProfessor);
		painelDaJanela.add(painelSec);
		painelDaJanela.add(painelProf);

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

	ActionListener cbActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			String r = cboxProfissao.getSelectedItem().toString().toUpperCase();
			if (r.equals("PROFESSOR")) {

				painelProf.setVisible(true);
				painelFaxineira.setVisible(false);
				painelSec.setVisible(false);
			} else if (r.equals("FAXINEIRA")) {

				painelFaxineira.setVisible(true);
				painelProf.setVisible(false);
				painelSec.setVisible(false);

			} else if (r.equals("SECRETARIA")) {

				painelSec.setVisible(true);
				painelFaxineira.setVisible(false);
				painelProf.setVisible(false);
			}

		}
	};

	ActionListener svActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			try {
				String uf = "";
				String periodo = "";

				String cidade = cboxCidade.getSelectedItem().toString().toUpperCase();
				String estado = cboxEstado.getSelectedItem().toString().toUpperCase();

				if (cidade.equals("SÃO PAULO")) {
					uf = "SP";
				} else if (cidade.equals("RIO DE JANEIRO")) {
					uf = "RJ";
				} else if (cidade.equals("DISTRITO FEDERAL")) {
					uf = "DF";
				}

				if (rbtDiurno.isSelected()) {
					periodo = "Diurno";
				} else if (rbtNoturno.isSelected()) {
					periodo = "Noturno";

				}

				FuncionarioController f = new FuncionarioController();

				f.consistirDados(txtNome.getText(), txtDataNasc.getText(), cidade, estado, txtRG.getText(),
						txtCPF.getText(), txtTelefone.getText(), txtNum.getText(), txtCep.getText(),
						txtComplemento.getText(), txtLogradouro.getText(), txtBairro.getText(), uf,
						cboxProfissao.getSelectedItem().toString().toUpperCase(), periodo,txtProfessor.getText(),txtSecretaria.getText());

				JOptionPane.showMessageDialog(null, "Cadastro efetuado!");
				
				txtSalario.setText("");
				txtNome.setText("");
				txtDataNasc.setText("");
				txtRG.setText("");
				txtCPF.setText("");
				txtTelefone.setText("");
				cboxCidade.setSelectedIndex(-1);
				cboxEstado.setSelectedIndex(-1);
				cboxProfissao.setSelectedIndex(-1);
				txtNum.setText("");
				txtCep.setText("");
				txtComplemento.setText("");
				txtLogradouro.setText("");
				txtBairro.setText("");
				txtSecretaria.setText("");
				txtProfessor.setText("");
				rbtDiurno.setSelected(false);
				rbtNoturno.setSelected(false);
				

			} catch (NullPointerException n) {
				JOptionPane.showMessageDialog(null, "Campos preenchidos incorretamente");
			} 

		}
	};

}
