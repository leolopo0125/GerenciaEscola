package view;
/**
 * classe responsavel pea janela do menu
 * @author llopo
 * @since 26/02/2020
 * @version 0.1
 * 
 */
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


public class CidadeView {
	
	
	private JFrame janela;
	private JPanel painelDaJanela;
	private JPanel painelTit;
	private JTextField txtCad;
	private JLabel lblcad;
	private JButton btcad;
	private JButton btcanc;

	public void iniciaGui() {
		
		//criando instancias
		janela = new JFrame("Cadastro de Cidade");
		painelDaJanela = (JPanel) janela.getContentPane();
		painelTit= new JPanel();
		txtCad = new JTextField();
		btcad = new JButton("Cadastrar");
		btcanc = new JButton("Cancelar");
		
		lblcad = new JLabel("Cadastrar Cidade");
//		lblcad.setBounds(-303,-30, 10, 20);
		
		//definindo valores dos componentes
		
		txtCad.setBounds(30,55, 300, 30);
		btcad.setBounds(200,110, 100, 30);
		btcanc.setBounds(50,110, 100, 30);
		
		btcanc.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				janela.dispose();
				
			}
		});

		btcad.addActionListener(confirmarListenner);
		
		
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setSize(375, 200);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		
		painelDaJanela.setBorder(BorderFactory.createEtchedBorder());
		painelDaJanela.add(btcad);		
		painelDaJanela.add(btcanc);		
		painelDaJanela.add(txtCad);
		painelTit.add(lblcad);	
		painelDaJanela.add(painelTit);


	}
	
	ActionListener confirmarListenner = new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			
			
			char[] letras = null;
			String palavra = txtCad.getText().toUpperCase();
			
			boolean registra = true;

			letras = palavra.toCharArray();


			for (int i = 0; i < letras.length; i++) {
				if (letras[i] == '0' || letras[i] == '1' || letras[i] == '2' || letras[i] == '3' || letras[i] == '4'
						|| letras[i] == '5' || letras[i] == '6' || letras[i] == '7' || letras[i] == '8'
						|| letras[i] == '9') {
					registra = false;
					break;
				}
			}if (registra) {
				CidadeController cct= new CidadeController();
				cct.recebeCidade(txtCad.getText().toUpperCase());
				txtCad.setText("");
				txtCad.setText("");
				
			}else {JOptionPane.showMessageDialog(null, "Nome inválido");}
		}

	};
	
	
	public static void main(String[] args) {
	
	}
}
