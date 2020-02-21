package controller;

import model.Professor;

public class ProfessorController {
	
	public void testaProfessor() {
		
		Professor p1= new Professor();
		
		p1.setCpf("471120993-49");
		p1.setMateria("Matematica");
		p1.setNome("Carlos");
		p1.setSalario(2800);
		p1.exibe();
		
		
	}
	

}
