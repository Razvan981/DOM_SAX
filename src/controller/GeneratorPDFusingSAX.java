package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import model.AngajatiMagazin;
import model.Produs;
import model.StocDisponibil;
import model.StocEpuizat;
import model.UserBazaDeDate;

import java.io.FileOutputStream;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;


public class GeneratorPDFusingSAX {
	
    
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD, BaseColor.RED);
	private SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
	private List<Produs> lista_produse = null;
	private List<UserBazaDeDate> lista_users = null;
	private List<StocDisponibil> lista_stockD = null;
	private List<StocEpuizat> lista_stockE = null;
	private List<AngajatiMagazin> lista_angajati = null;
	
	public void StocareDate() {
	
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			MyHandlerSAX handler = new MyHandlerSAX();
			saxParser.parse(new File("D:\\Generare XML si PDF\\ProiectPractica.xml"), handler);
			
			lista_produse = handler.getListaProduse();
			lista_users = handler.getListaUsers();
			lista_stockD = handler.getListaStocD();
			lista_stockE = handler.getListaStocE();
			lista_angajati = handler.getListaAngajati();
	
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		  }
	}
	
	
	public void createPdfSAX(String filename)
		    throws DocumentException, IOException {

		        Document document = new Document();
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

