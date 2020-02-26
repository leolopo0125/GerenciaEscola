
import controller.AlunoController;
import controller.ProfessorController;
import view.Base;
import view.MenuView;

/**
 * Classe main para efetuar testes das classes
 * @author llopo
 *@since 19/02/2020
 *@version 0.1
 */
public class Main {
public static void main(String[] args) {
	

	ProfessorController pc = new ProfessorController();
	AlunoController ac = new AlunoController();
	Base av = new Base();
	MenuView menu = new MenuView();
	
	
	menu.iniciaGui();
	
	
//	ac.inserirAluno();
//	ac.listarTodos();
//	ac.listarAniversariantes(12);
//	pc.testaProfessor();
}
}
