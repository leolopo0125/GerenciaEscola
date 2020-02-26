package model;
/**
 * Classe modelo de faxineira
 * @author llopo
 *@since 26/02/2020
 *@version 0.1
 *
 */

public class Faxineira extends Funcionario{
	
	private String turno;
	
	public Faxineira() {

	}

	public Faxineira(String turno) {
		super();
		this.turno = turno;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	

}
