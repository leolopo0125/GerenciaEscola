package model;
/**
 * Introdu��o a modificadores de restri��o
 * @author llopo
 * @since 20/02/2020
 *@version 0.1
 */
		
public class Data {
	
	private int dia;
	private int mes;
	private int ano;
	
	
	public Data() {
		
		System.out.println("Data criada.");
		
	}
	
	public Data(int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}

	@Override
		public String toString() {

			return dia+"/"+mes+"/"+ano;
		}
}
