package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.CidadeController;
import controller.EstadoController;


public class EstadoView {
	
	
	private JFrame janela;
	private JPanel painelDaJanela;
	private JPanel painelTit;
	private JTextField txtEstado;
	private JTextField txtUf;
	private JLabel lblEstado;
	private JLabel lblUf;
	private JLabel lblNome;
	private JButton btcad;
	private JButton btcanc;

	public void iniciaGui() {
		
		//criando instancias
		janela = new JFrame("Cadastro de Estado");
		painelDaJanela = (JPanel) janela.getContentPane();
		painelTit= new JPanel();
		txtUf = new JTextField();
		txtEstado = new JTextField();
		btcad = new JButton("Cadastrar");
		btcanc = new JButton("Cancelar");
		
		lblUf = new JLabel("Uf");
		lblUf.setBounds(256, 57, 50, 30);
		lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 57, 50, 30);
		lblEstado = new JLabel("Cadastrar Estado");

		
		//definindo valores dos componentes
		
		txtEstado.setBounds(60,60, 180, 30);
		txtUf.setBounds(287,60, 50, 30);
		btcad.setBounds(200,110, 100, 30);
		btcanc.setBounds(50,110, 100, 30);
		btcanc.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				janela.dispose();
				
			}
		});
		
		btcad.addActionListener(confirmarListenner);
		
		
		//configurações da janela
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setSize(375, 200);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		
		//configuracoes do painel
		painelDaJanela.setBorder(BorderFactory.createEtchedBorder());
		painelTit.add(lblEstado);
		painelDaJanela.add(btcad);		
		painelDaJanela.add(btcanc);		
		painelDaJanela.add(txtEstado);
		painelDaJanela.add(txtUf);
		painelDaJanela.add(lblUf);
		painelDaJanela.add(lblNome);
		painelDaJanela.add(painelTit);


	}
	
	ActionListener confirmarListenner = new ActionListener() {

		public void actionPerformed(ActionEvent e) {
		char[] letras = null;
		char[] letras1 = null;
		String palavra = txtEstado.getText().toUpperCase();
		String palavra1 = txtUf.getText().toUpperCase();
		
		boolean registra = true;

		letras = palavra.toCharArray();
		letras1 = palavra1.toCharArray();


		for (int i = 0; i < letras.length; i++) {
			if (letras[i] == '0' || letras[i] == '1' || letras[i] == '2' || letras[i] == '3' || letras[i] == '4'
					|| letras[i] == '5' || letras[i] == '6' || letras[i] == '7' || letras[i] == '8'
					|| letras[i] == '9') {
					registra = false;
					break;
				}
		}
		for (int j = 0; j < letras1.length; j++) {
			if (letras1[j] == '0' || letras1[j] == '1' || letras1[j] == '2' || letras1[j] == '3' || letras1[j] == '4'
		|| letras1[j] == '5' || letras1[j] == '6' || letras1[j] == '7' || letras1[j] == '8'
		|| letras1[j] == '9') {
				registra = false;
				break;
				
			}
			
		}
			if (registra) {
			EstadoController ect= new EstadoController();
			ect.recebeEstado(txtEstado.getText().toUpperCase(),txtUf.getText().toUpperCase());
			txtEstado.setText("");
			txtUf.setText("");
			}else {
				JOptionPane.showMessageDialog(null, "Formato inválido");
			}
		
		}
		
	

	};
	
	public static void main(String[] args) {

	}
	}
	
