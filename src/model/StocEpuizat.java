package model;

public class StocEpuizat {

	int id;
	String nume_produs;
	String cantitate_necesara;
	
	public StocEpuizat() {
		super();
	}
	/**
	 * @param id
	 * @param nume_produs
	 * @param cantitate_necesara
	 */
	public StocEpuizat(int id, String nume_produs, String cantitate_necesara) {
		this.id = id;
		this.nume_produs = nume_produs;
		this.cantitate_necesara = cantitate_necesara;
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
	public String getCantitateNecesara() {
		return cantitate_necesara;
	}
	public void setCantitateNecesara(String cantitate_necesara) {
		this.cantitate_necesara = cantitate_necesara;
	}	
}
