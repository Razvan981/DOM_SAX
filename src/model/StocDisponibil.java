package model;

public class StocDisponibil {

	int id;
	String nume_produs;
	String cantitate;
	
	public StocDisponibil() {
		super();
	}
	/**
	 * @param id
	 * @param nume_produs
	 * @param cantitate
	 */
	public StocDisponibil(int id, String nume_produs, String cantitate) {
		this.id = id;
		this.nume_produs = nume_produs;
		this.cantitate = cantitate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumeProdus() {
		return nume_produs;
	}
	public void setNumeProdus(String nume_produs) {
		this.nume_produs = nume_produs;
	}
	public String getCantitate() {
		return cantitate;
	}
	public void setCantitate(String cantitate) {
		this.cantitate = cantitate;
	}	
	
}
