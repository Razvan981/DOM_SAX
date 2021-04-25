package model;

public class Produs {

	int id;
	String numele_produsului;
	String greutate_in_Kg;
	
	public Produs() {
		super();
	}
	/**
	 * @param id
	 * @param numele_produsului
	 * @param greutate_in_Kg
	 */
	public Produs(int id, String numele_produsului, String greutate_in_Kg) {
		this.id = id;
		this.numele_produsului = numele_produsului;
		this.greutate_in_Kg = greutate_in_Kg;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumeProdus() {
		return numele_produsului;
	}
	public void setNumeProdus(String numele_produsului) {
		this.numele_produsului = numele_produsului;
	}
	public String getCantitate() {
		return greutate_in_Kg;
	}
	public void setCantitate(String greutate_in_Kg) {
		this.greutate_in_Kg = greutate_in_Kg;
	}	
	
}
