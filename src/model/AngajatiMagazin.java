package model;

public class AngajatiMagazin {

	int id;
	String nume;
	String prenume;
	
	public AngajatiMagazin() {
		super();
	}
	/**
	 * @param id
	 * @param nume
	 * @param prenume
	 */
	public AngajatiMagazin(int id, String nume, String prenume) {
		this.id = id;
		this.nume = nume;
		this.prenume = prenume;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getPrenume() {
		return prenume;
	}
	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
}
