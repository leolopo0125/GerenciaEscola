package view;
/**view para exibição dos dados dos funcionarios
 * @author leonardo
 * @since 25/02/2020
 * @version 0.1
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.FaxineiraController;
import controller.ProfessorController;
import controller.SecretariaController;

public class RelatorioFuncionario {
	private JFrame janela;
	private JTabbedPane painelComAbas;
	private JPanel painelDaJanela;
	private JPanel primeiraAba;
	private JPanel segundaAba;
	private JPanel terceiraAba;
	private JTable tabelaPf;
	private JTable tabelaSec;
	private JTable tabelaFax;
	private String[] colunas = new String[] { "telefone", "Nome", "Data de nascimento" };
	private JButton botaoConfirmar;
	private JScrollPane painelDeScroll;
	private JScrollPane painelDeScrollS;
	private JScrollPane painelDeScrollF;
	
	
	public void iniciaGui() {
		//declaração da janela e do painel com abas
		janela = new JFrame("Relatorio de funcionarios");
		painelDaJanela= (JPanel) janela.getContentPane();
		painelComAbas= new JTabbedPane();
		primeiraAba = new JPanel();
		segundaAba = new JPanel();
		terceiraAba = new JPanel();
		
	///////////////////////////////////////////////Relatorio Professor///////////////////////////////////////////////
		
		//inicio da passagem de dados para impressao
		ProfessorController pc = new ProfessorController();
		
		janela.setLocationRelativeTo(null);
		
		tabelaPf = new JTable();
		botaoConfirmar = new JButton("Confirmar");

		painelDaJanela = (JPanel) janela.getContentPane();
		
		DefaultTableModel tabelaProfessor = new DefaultTableModel(colunas, 0);
		tabelaPf = new JTable(tabelaProfessor);
		
		String dadosProfessor[] = pc.listarTodos().split(",");
        int i=0;
        while(i<dadosProfessor.length) {

                String nomeProfessor[] = dadosProfessor[i].split(";");


                tabelaProfessor.addRow(nomeProfessor);

                i++;
        }
		//final da passagem de dados
        
     
        
        
		tabelaPf.setEnabled(false);

	
		
		// instanciando e inserindo a tabela no scroll
		painelDeScroll = new JScrollPane(tabelaPf);
		painelDeScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		// configuração dos componentes da tela
		painelDeScroll.setBounds(1, 5, 381, 200);
		tabelaPf.setBounds(-10, 30, 300, 200);
		botaoConfirmar.setBounds(195, 270, 100, 30);
		botaoConfirmar.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				janela.dispose();
				
			}
		});
		////////////////////////////////////////////////Secretaria////////////////////////////////////////////////////////
		
		//inicio da passagem de dados para impressao
		   SecretariaController sc = new SecretariaController();
			
			
			tabelaSec = new JTable();
			
			DefaultTableModel tabelaSecretaria = new DefaultTableModel(colunas, 0);
			tabelaSec = new JTable(tabelaSecretaria);
			
			String dadosSecretaria[] = sc.listarTodos().split(",");
	        int j=0;
	        while(j<dadosSecretaria.length) {

	                String nomeSecretaria[] = dadosSecretaria[j].split(";");


	                tabelaSecretaria.addRow(nomeSecretaria);

	                j++;
	        }
			//final da passagem de dados
		        
		        
				tabelaSec.setEnabled(false);

			
				
				// instanciando e inserindo a tabela no scroll
				painelDeScrollS = new JScrollPane(tabelaSec);
				painelDeScrollS.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

				// configuração dos componentes da tela
				painelDeScrollS.setBounds(1, 5, 381, 200);
				tabelaSec.setBounds(-10, 30, 300, 200);
		
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
				
				//inicio da passagem de dados para impressao
				   FaxineiraController fc = new FaxineiraController();
					
					
					tabelaFax = new JTable();
					
					DefaultTableModel tabelaFaxineira = new DefaultTableModel(colunas, 0);
					tabelaFax = new JTable(tabelaFaxineira);
					
					String faxineiraDados[] = fc.listarTodos().split(",");
			        int k=0;
			        while(k<faxineiraDados.length) {

			                String nomeFaxineira[] = faxineiraDados[k].split(";");


			                tabelaFaxineira.addRow(nomeFaxineira);

			                k++;
			        }
					//final da passagem de dados
				        
				        
						tabelaFax.setEnabled(false);

					
						
						// instanciando e inserindo a tabela no scroll
						painelDeScrollF = new JScrollPane(tabelaFax);
						painelDeScrollF.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

						// configuração dos componentes da tela
						painelDeScrollF.setBounds(1, 5, 381, 200);
						tabelaSec.setBounds(-10, 30, 300, 200);
						
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
						
		//configurar e adicionar as abas
		painelComAbas.addTab("Professor",primeiraAba);
		painelComAbas.addTab("Secretária",segundaAba);
		painelComAbas.addTab("Faxineira",terceiraAba);
		painelComAbas.setBounds(2,2,500,257);
		
		//insere texto nas abas
		
		//configurações do painel da janela
		painelDaJanela.setLayout(null);
		painelDaJanela.add(painelComAbas);

		painelDaJanela.setLayout(null);
		primeiraAba.add(painelDeScroll);
		segundaAba.add(painelDeScrollS);
		terceiraAba.add(painelDeScrollF);
		painelDaJanela.add(botaoConfirmar);
		
		//configurações da janela
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setSize(525, 350);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

	}
	
	public static void main(String[] args) {

	}
}



