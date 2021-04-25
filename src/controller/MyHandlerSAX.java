package controller;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import model.AngajatiMagazin;
import model.Produs;
import model.StocDisponibil;
import model.StocEpuizat;
import model.UserBazaDeDate;

public class MyHandlerSAX extends DefaultHandler {

	private List<Produs> lista_produse = null;
	private Produs m_produs = null;	
	private List<UserBazaDeDate> lista_users = null;
	private UserBazaDeDate m_user = null;	
	private List<StocDisponibil> lista_stockD = null;
	private StocDisponibil m_stockD = null;		
	private List<StocEpuizat> lista_stockE = null;
	private StocEpuizat m_stockE = null;	
	private List<AngajatiMagazin> lista_angajati = null;
	private AngajatiMagazin m_angajat = null;	
	private StringBuilder data = null;
	
	
	public List<Produs> getListaProduse() {
		return lista_produse;
	}
	public List<UserBazaDeDate> getListaUsers() {
		return lista_users;
	}
	public List<StocDisponibil> getListaStocD() {
		return lista_stockD;
	}
	public List<StocEpuizat> getListaStocE() {
		return lista_stockE;
	}
	public List<AngajatiMagazin> getListaAngajati() {
		return lista_angajati;
	}
	

	boolean b_nume_produs = false;
	boolean b_greutate_produs = false;
	boolean b_nume_user = false;
	boolean b_functie_user = false;
	boolean b_nume_produsD = false;
	boolean b_cantitateD = false;
	boolean b_nume_produsE = false;
	boolean b_cantitateN = false;
	boolean b_nume_angajat = false;
	boolean b_prenume_angajat = false;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("Produs")) {
	
			String id = attributes.getValue("id");
			m_produs = new Produs();
			m_produs.setId(Integer.parseInt(id));
			if (lista_produse == null)
				lista_produse = new ArrayList<>();
			
		} else if (qName.equalsIgnoreCase("User")) {
	
			String id = attributes.getValue("id");
			m_user = new UserBazaDeDate();
			m_user.setId(Integer.parseInt(id));
			if (lista_users == null)
				lista_users = new ArrayList<>();
			
		} else if (qName.equalsIgnoreCase("StocDisponibil")) {
	
			String id = attributes.getValue("id");
			m_stockD = new StocDisponibil();
			m_stockD.setId(Integer.parseInt(id));
			if (lista_stockD == null)
				lista_stockD = new ArrayList<>();
			
		} else if (qName.equalsIgnoreCase("StockEpuizat")) {
	
			String id = attributes.getValue("id");
			m_stockE = new StocEpuizat();
			m_stockE.setId(Integer.parseInt(id));
			if (lista_stockE == null)
				lista_stockE = new ArrayList<>();
			
		} else if (qName.equalsIgnoreCase("Angajat")) {
	
			String id = attributes.getValue("id");
			m_angajat = new AngajatiMagazin();
			m_angajat.setId(Integer.parseInt(id));
			if (lista_angajati == null)
				lista_angajati = new ArrayList<>();
		} 
		
		else if (qName.equalsIgnoreCase("NumeProdus")) {
			b_nume_produs = true;
		} else if (qName.equalsIgnoreCase("GreutateProdus")) {
			b_greutate_produs = true;
		} else if (qName.equalsIgnoreCase("UserNume")) {
			b_nume_user = true;
		} else if (qName.equalsIgnoreCase("UserRol")) {
			b_functie_user = true;
		} else if (qName.equalsIgnoreCase("NumeProdusD")) {
			b_nume_produsD = true;
		} else if (qName.equalsIgnoreCase("CantitateProdus")) {
			b_cantitateD = true;
		} else if (qName.equalsIgnoreCase("NumeProdusE")) {
			b_nume_produsE = true;
		} else if (qName.equalsIgnoreCase("CantitateNecesara")) {
			b_cantitateN = true;
		} else if (qName.equalsIgnoreCase("NumeAngajat")) {
			b_nume_angajat = true;
		} else if (qName.equalsIgnoreCase("PrenumeAngajat")) {
			b_prenume_angajat = true;
		}

		data = new StringBuilder();
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		if (b_nume_produs) {		
			m_produs.setNumeProdus(data.toString());
			b_nume_produs = false;
			
		} else if (b_greutate_produs) {		
			m_produs.setCantitate(data.toString());
			b_greutate_produs = false;
			
		} else if (b_nume_user) {			
			m_user.setNume(data.toString());
			b_nume_user = false;
			
		} else if (b_functie_user) {		
			m_user.setRole(data.toString());
			b_functie_user = false;
			
		} else if (b_nume_produsD) {		
			m_stockD.setNumeProdus(data.toString());
			b_nume_produsD = false;
			
		} else if (b_cantitateD) {			
			m_stockD.setCantitate(data.toString());
			b_cantitateD = false;
			
		} else if (b_nume_produsE) {			
			m_stockE.setNumeProdus(data.toString());
			b_nume_produsE = false;
			
		} else if (b_cantitateN) {		
			m_stockE.setCantitateNecesara(data.toString());
			b_cantitateN = false;
			
		} else if (b_nume_angajat) {		
			m_angajat.setNume(data.toString());
			b_nume_angajat = false;
			
		} else if (b_prenume_angajat) {		
			m_angajat.setPrenume(data.toString());
			b_prenume_angajat = false;
		}
		
		if (qName.equalsIgnoreCase("Produs")) {
			lista_produse.add(m_produs);
		}
		if (qName.equalsIgnoreCase("User")) {
			lista_users.add(m_user);
		}
		if (qName.equalsIgnoreCase("StocDisponibil")) {
			lista_stockD.add(m_stockD);
		}
		if (qName.equalsIgnoreCase("StockEpuizat")) {
			lista_stockE.add(m_stockE);
		}
		if (qName.equalsIgnoreCase("Angajat")) {
			lista_angajati.add(m_angajat);
		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		data.append(new String(ch, start, length));
	}
	
}
