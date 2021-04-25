package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import model.AngajatiMagazin;
import model.Produs;
import model.StocDisponibil;
import model.StocEpuizat;
import model.UserBazaDeDate;

public class GeneratorPDFusingDOM {   
	
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD, BaseColor.BLUE);
	
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
	
	public void ParsareDOM() {

	    try {
	       File inputFile = new File("D:\\Generare XML si PDF\\ProiectPractica.xml");
	       DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	       DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	       Document doc = dBuilder.parse(inputFile);
	       doc.getDocumentElement().normalize();
	       	     	       
	       
	       NodeList nList1 = doc.getElementsByTagName("Produs");
	       
	       for (int temp = 0; temp < nList1.getLength(); temp++) {
	          Node nNode = nList1.item(temp);
	          
	          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		         m_produs = new Produs();
	             Element eElement = (Element) nNode;
	             

	             m_produs.setId(Integer.parseInt(eElement.getAttribute("id")));
	             m_produs.setNumeProdus(eElement.getElementsByTagName("NumeProdus").item(0).getTextContent());
	             m_produs.setCantitate(eElement.getElementsByTagName("GreutateProdus").item(0) .getTextContent());
	             
	 			if (lista_produse == null)
					lista_produse = new ArrayList<>();
	 			
	 			lista_produse.add(m_produs);

	          }
	       }
	       
	       	       
	       NodeList nList2 = doc.getElementsByTagName("StockEpuizat");
	       
	       for (int temp = 0; temp < nList2.getLength(); temp++) {
	          Node nNode = nList2.item(temp);
	          
	          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	        	  m_stockE = new StocEpuizat();
	             Element eElement = (Element) nNode;
	             

	             m_stockE.setId(Integer.parseInt(eElement.getAttribute("id")));
	             m_stockE.setNumeProdus(eElement.getElementsByTagName("NumeProdusE").item(0).getTextContent());
	             m_stockE.setCantitateNecesara(eElement.getElementsByTagName("CantitateNecesara").item(0) .getTextContent());
	             
	 			if (lista_stockE == null)
	 				lista_stockE = new ArrayList<>();
	 			
	 			lista_stockE.add(m_stockE);

	          }
	       }
	       
	       
	       NodeList nList3 = doc.getElementsByTagName("StocDisponibil");
	       
	       for (int temp = 0; temp < nList3.getLength(); temp++) {
	          Node nNode = nList3.item(temp);
	          
	          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	        	 m_stockD = new StocDisponibil();
	             Element eElement = (Element) nNode;
	             

	             m_stockD.setId(Integer.parseInt(eElement.getAttribute("id")));
	             m_stockD.setNumeProdus(eElement.getElementsByTagName("NumeProdusD").item(0).getTextContent());
	             m_stockD.setCantitate(eElement.getElementsByTagName("CantitateProdus").item(0) .getTextContent());
	             
	 			if (lista_stockD == null)
	 				lista_stockD = new ArrayList<>();
	 			
	 			lista_stockD.add(m_stockD);

	          }
	       }
	       
	       
	       NodeList nList4 = doc.getElementsByTagName("User");
	       
	       for (int temp = 0; temp < nList4.getLength(); temp++) {
	          Node nNode = nList4.item(temp);
	          
	          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	        	  m_user = new UserBazaDeDate();
	             Element eElement = (Element) nNode;
	             

	             m_user.setId(Integer.parseInt(eElement.getAttribute("id")));
	             m_user.setNume(eElement.getElementsByTagName("UserNume").item(0).getTextContent());
	             m_user.setRole(eElement.getElementsByTagName("UserRol").item(0) .getTextContent());
	             
	 			if (lista_users == null)
	 				lista_users = new ArrayList<>();
	 			
	 			lista_users.add(m_user);

	          }
	       }
	       
	       
	       NodeList nList5 = doc.getElementsByTagName("Angajat");
	       
	       for (int temp = 0; temp < nList5.getLength(); temp++) {
	          Node nNode = nList5.item(temp);
	          
	          if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	        	 m_angajat = new AngajatiMagazin();
	             Element eElement = (Element) nNode;
	             

	             m_angajat.setId(Integer.parseInt(eElement.getAttribute("id")));
	             m_angajat.setNume(eElement.getElementsByTagName("NumeAngajat").item(0).getTextContent());
	             m_angajat.setPrenume(eElement.getElementsByTagName("PrenumeAngajat").item(0) .getTextContent());
	             
	 			if (lista_angajati == null)
	 				lista_angajati = new ArrayList<>();
	 			
	 			lista_angajati.add(m_angajat);

	          }
	       }
	       
	    } catch (Exception e) {
	       e.printStackTrace();
	    }
	 }
	
	public void createPdfDOM(String filename)
		    throws DocumentException, IOException {

				com.itextpdf.text.Document document = new com.itextpdf.text.Document();
				
		        PdfWriter.getInstance(document, new FileOutputStream(filename));
		        document.open();
		        
		        document.add(new Paragraph("Tabel Produs", redFont ));
		        
				for(Produs iterator : lista_produse) {
					
					document.add(new Paragraph("\nid= " + iterator.getId()));
					document.add(new Paragraph("numele_produsului= " + iterator.getNumeProdus()));
					document.add(new Paragraph("greutate_in_Kg= "  + iterator.getCantitate()));
					
				}
				
		        document.add(new Paragraph("\nTabel user_baza_de_date", redFont ));
		        
				for(UserBazaDeDate iterator : lista_users) {
					
					document.add(new Paragraph("\nid= " + iterator.getId()));
					document.add(new Paragraph("nume = " + iterator.getNume()));
					document.add(new Paragraph("functie = "  + iterator.getRol()));
					
				}
				
		        document.add(new Paragraph("\nTabel stoc_disponibil", redFont ));
		        
				for(StocDisponibil iterator : lista_stockD) {
					
					document.add(new Paragraph("\nid= " + iterator.getId()));
					document.add(new Paragraph("nume produs= " + iterator.getNumeProdus()));
					document.add(new Paragraph("cantitate= "  + iterator.getCantitate()));
					
				}
				
		        document.add(new Paragraph("\nTabel stoc_epuizat", redFont ));
		        
				for(StocEpuizat iterator : lista_stockE) {
					
					document.add(new Paragraph("\nid= " + iterator.getId()));
					document.add(new Paragraph("nume produs= " + iterator.getNumeProdus()));
					document.add(new Paragraph("cantitate_necesara= "  + iterator.getCantitateNecesara()));
					
				}
				
		        document.add(new Paragraph("\nTabel angajati_magazin", redFont ));
		        
				for(AngajatiMagazin iterator : lista_angajati) {
					
					document.add(new Paragraph("\nid= " + iterator.getId()));
					document.add(new Paragraph("nume = " + iterator.getNume()));
					document.add(new Paragraph("prenume = "  + iterator.getPrenume()));
					
				}			

		        document.close();		    
		    }
	
}
