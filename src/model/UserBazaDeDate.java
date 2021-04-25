package model;

public class UserBazaDeDate {
	
	int id;
	String nume;
	String rol;
	
	public UserBazaDeDate() {
		super();
	}
	/**
	 * @param id
	 * @param nume
	 * @param rol
	 */
	public UserBazaDeDate(int id, String nume, String rol) {
		this.id = id;
		this.nume = nume;
		this.rol = rol;
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
	public String getRol() {
		return rol;
	}
	public void setRole(String rol) {
		this.rol = rol;
	}
}
