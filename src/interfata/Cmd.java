package interfata;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import com.itextpdf.text.DocumentException;

import controller.GeneratorPDFusingDOM;
import controller.GeneratorPDFusingSAX;
import controller.GeneratorXML;

class Cmd implements ActionListener {
	
	
	public static final String RESULT1 = "D:\\Generare XML si PDF\\ProiectPracticaSAX.pdf";
	public static final String RESULT2 = "D:\\Generare XML si PDF\\ProiectPracticaDOM.pdf";
	
	private GUI gui;

	public Cmd (GUI gui) {
		this.gui = gui;
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Generare_XML")) {				
			GeneratorXML xml = new GeneratorXML();
			xml.GenerareXML();
		}
		
		if(e.getActionCommand().equals("Generare_PDF_SAX")) {				
			GeneratorPDFusingSAX PdfSAX = new GeneratorPDFusingSAX();
			PdfSAX.StocareDate();
			try {
				PdfSAX.createPdfSAX(RESULT1);
			} catch (DocumentException | IOException e1) {

				e1.printStackTrace();
			}
		}
		
		if(e.getActionCommand().equals("Generare_PDF_DOM")) {				
			GeneratorPDFusingDOM PdfDOM = new GeneratorPDFusingDOM();
			PdfDOM.ParsareDOM();
			try {
				PdfDOM.createPdfDOM(RESULT2);
			} catch (DocumentException | IOException e1) {

				e1.printStackTrace();
			}
		}
		
		if(e.getActionCommand().equals("Deschidere_Folder")) {				
			try {
				Desktop.getDesktop().open(new File("D:\\Generare XML si PDF"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		if(e.getActionCommand().equals("Iesire")) {				
			System.exit(0);
		}			
	
	}

}