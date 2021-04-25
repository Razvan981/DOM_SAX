package controller;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import model.AngajatiMagazin;
import model.Produs;
import model.StocDisponibil;
import model.StocEpuizat;
import model.UserBazaDeDate;

public class GeneratorXML {
	
public void GenerareXML()
  {
    try
    {

      String myDriver = "org.gjt.mm.mysql.Driver";
      String myUrl = "jdbc:mysql://localhost:3306/practica_facultate";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "");
      //PreparedStatement preparedStatement = null;
      DocumentBuilderFactory dbFactory =
      DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.newDocument();
      
      String query1 = "SELECT * FROM produs";

      // create the java statement
      Statement st1 = conn.createStatement();
      
      // execute the query, and get a java resultset
      ResultSet rs1 = st1.executeQuery(query1);
      
      // iterate through the java resultset
      ArrayList<Produs> listProduse = new ArrayList<Produs>();
      
      Element rootElement = doc.createElement("Tabele");
      doc.appendChild(rootElement);
      
     // root element
     Element rootElement0 = doc.createElement("Produse");
     rootElement.appendChild(rootElement0);
      
     int id1;
     String s1,s2;
     while (rs1.next())
     {
    	 
	      Produs p = new Produs();
	      id1 = rs1.getInt("id");
	      p.setId(id1);
	      s1 = rs1.getString("numele_produsului");
	      p.setNumeProdus(s1);
	      s2 = rs1.getString("greutate_in_Kg");
	      p.setCantitate(s2);
	        
	  	  Element e_produs = doc.createElement("Produs");
	  	  rootElement0.appendChild(e_produs);
	        
          Attr attrType = doc.createAttribute("id");
          attrType.setValue(String.valueOf(id1));
          e_produs.setAttributeNode(attrType);
	       
	      Element nume1 = doc.createElement("NumeProdus");
	      nume1.appendChild(doc.createTextNode(s1));
	      e_produs.appendChild(nume1);
	       
	      Element greutate1 = doc.createElement("GreutateProdus");
	      greutate1.appendChild(doc.createTextNode(s2));
	      e_produs.appendChild(greutate1);
	          
	      listProduse.add(p);
                     
      }
     
    System.out.println("\t\tTabel Produs");    
	for(int i = 0; i < listProduse.size(); i++){
		
      System.out.println("\nid= " + listProduse.get(i).getId());
	  System.out.println("numele_produsului= " + listProduse.get(i).getNumeProdus());
	  System.out.println("greutate_in_Kg= "  +listProduse.get(i).getCantitate());
	}
	
	
      String query2 = "SELECT * FROM stoc_disponibil";

      // create the java statement
      Statement st2 = conn.createStatement();
      
      // execute the query, and get a java resultset
      ResultSet rs2 = st2.executeQuery(query2);
      
      // iterate through the java resultset
      ArrayList<StocDisponibil> liststockD = new ArrayList<StocDisponibil>();
      
      Element rootElement1 = doc.createElement("StoculDisponibil");
      rootElement.appendChild(rootElement1);
      
      int id2;
      String s3,s4;
      
      while (rs2.next())
      {
    	  id2 = rs2.getInt("id");
    	  s3 = rs2.getString("nume_produs");
    	  s4 = rs2.getString("cantitate");
    	  
    	  StocDisponibil stockD = new StocDisponibil(id2 , s3 , s4);
    	  
    	  Element e_stockD = doc.createElement("StocDisponibil");
    	  rootElement1.appendChild(e_stockD);
    	  
          Attr attrType = doc.createAttribute("id");
          attrType.setValue(String.valueOf(id2));
          e_stockD.setAttributeNode(attrType);
          
          Element nume2 = doc.createElement("NumeProdusD");
          nume2.appendChild(doc.createTextNode(s3));
          e_stockD.appendChild(nume2);
          
          Element cantitate2 = doc.createElement("CantitateProdus");
          cantitate2.appendChild(doc.createTextNode(s4));
          e_stockD.appendChild(cantitate2);
       
    	  liststockD.add(stockD);
      }
      
      System.out.println("\n\t\tTabel stoc_disponibil");    
  	  for(int i = 0; i < liststockD.size(); i++){
  		
        System.out.println("\nid= " + liststockD.get(i).getId());
  	    System.out.println("nume produs= " + liststockD.get(i).getNumeProdus());
  	    System.out.println("cantitate= "  +liststockD.get(i).getCantitate());
  	}
  	  
 
      String query3 = "SELECT * FROM stoc_epuizat";

      // create the java statement
      Statement st3 = conn.createStatement();
      
      // execute the query, and get a java resultset
      ResultSet rs3 = st3.executeQuery(query3);
      
      // iterate through the java resultset
      ArrayList<StocEpuizat> liststockE = new ArrayList<StocEpuizat>();
      
      Element rootElement2 = doc.createElement("StoculEpuizat");
      rootElement.appendChild(rootElement2);
      
      int id3;
      String s5,s6;
      
      while (rs3.next())
      {
    	  id3 = rs3.getInt("id");
    	  s5 = rs3.getString("nume_produs");
    	  s6 = rs3.getString("cantitate_necesara");
    	  
    	  StocEpuizat stockE = new StocEpuizat(id3 , s5 , s6);
    	  
    	  Element e_stockE = doc.createElement("StockEpuizat");
    	  rootElement2.appendChild(e_stockE);
    	  
          Attr attrType = doc.createAttribute("id");
          attrType.setValue(String.valueOf(id3));
          e_stockE.setAttributeNode(attrType);
          
          Element nume3 = doc.createElement("NumeProdusE");
          nume3.appendChild(doc.createTextNode(s5));
          e_stockE.appendChild(nume3);
          
          Element cantitate3 = doc.createElement("CantitateNecesara");
          cantitate3.appendChild(doc.createTextNode(s6));
          e_stockE.appendChild(cantitate3);
       
    	  liststockE.add(stockE);
      }
      
      System.out.println("\n\t\tTabel stoc_epuizat");    
  	  for(int i = 0; i < liststockE.size(); i++){
  		
        System.out.println("\nid= " + liststockE.get(i).getId());
  	    System.out.println("nume produs= " + liststockE.get(i).getNumeProdus());
  	    System.out.println("cantitate_necesara= "  +liststockE.get(i).getCantitateNecesara());
  	}
      

      String query4 = "SELECT * FROM user_baza_de_date";

      // create the java statement
      Statement st4 = conn.createStatement();
      
      // execute the query, and get a java resultset
      ResultSet rs4 = st4.executeQuery(query4);
      
      // iterate through the java resultset
      ArrayList<UserBazaDeDate> listUser = new ArrayList<UserBazaDeDate>();
      
      Element rootElement3 = doc.createElement("UserBD");
      rootElement.appendChild(rootElement3);
      
      int id4;
      String s7,s8;
      
      while (rs4.next())
      {
    	  id4 = rs4.getInt("id");
    	  s7 = rs4.getString("nume");
    	  s8 = rs4.getString("rol");
    	  
    	  UserBazaDeDate user = new UserBazaDeDate(id4 , s7 , s8);
    	  
    	  Element e_user = doc.createElement("User");
    	  rootElement3.appendChild(e_user);
    	  
          Attr attrType = doc.createAttribute("id");
          attrType.setValue(String.valueOf(id4));
          e_user.setAttributeNode(attrType);
          
          Element nume4 = doc.createElement("UserNume");;
          nume4.appendChild(doc.createTextNode(s7));
          e_user.appendChild(nume4);
          
          Element rol4 = doc.createElement("UserRol");
          rol4.appendChild(doc.createTextNode(s8));
          e_user.appendChild(rol4);
       
    	  listUser.add(user);
      }
      
      System.out.println("\n\t\tTabel user_baza_de_date");    
  	  for(int i = 0; i < listUser.size(); i++){
  		
        System.out.println("\nid= " + listUser.get(i).getId());
  	    System.out.println("nume = " + listUser.get(i).getNume());
  	    System.out.println("functie = "  +listUser.get(i).getRol());
  	}	  
  	  

      String query5 = "SELECT * FROM angajati_magazin";

      // create the java statement
      Statement st5 = conn.createStatement();
      
      // execute the query, and get a java resultset
      ResultSet rs5 = st5.executeQuery(query5);
      
      // iterate through the java resultset
      ArrayList<AngajatiMagazin> listAngajati = new ArrayList<AngajatiMagazin>();
      
      Element rootElement4 = doc.createElement("AngajatiMagazin");
      rootElement.appendChild(rootElement4);
      
      int id5;
      String s9,s0;
      
      while (rs5.next())
      {
    	  id5 = rs5.getInt("id");
    	  s9 = rs5.getString("nume");
    	  s0 = rs5.getString("prenume");
    	  
    	  AngajatiMagazin angajat = new AngajatiMagazin(id5 ,s9 ,s0);
    	  
    	  Element e_angajat = doc.createElement("Angajat");
    	  rootElement4.appendChild(e_angajat);
    	  
          Attr attrType = doc.createAttribute("id");
          attrType.setValue(String.valueOf(id5));
          e_angajat.setAttributeNode(attrType);
          
          
          Element nume5 = doc.createElement("NumeAngajat");
          nume5.appendChild(doc.createTextNode(s9));
          e_angajat.appendChild(nume5);
          
          Element prenume5 = doc.createElement("PrenumeAngajat");
          prenume5.appendChild(doc.createTextNode(s0));
          e_angajat.appendChild(prenume5);
    	  
    	  listAngajati.add(angajat);
      }
      
      System.out.println("\n\t\tTabel angajati_magazin");    
  	  for(int i = 0; i < listAngajati.size(); i++){
  		
        System.out.println("\nid= " + listAngajati.get(i).getId());
  	    System.out.println("nume = " + listAngajati.get(i).getNume());
  	    System.out.println("prenume = "  +listAngajati.get(i).getPrenume());
  	} 	  
  	  
  	  

  	  // Modificarea unei inregistrari
  	  
//      String query = "update angajati_magazin set nume = ? where prenume = 'Andrei' ";
//      PreparedStatement preparedStmt = conn.prepareStatement(query);
//      preparedStmt.setString(1, "Zeve");
//
//      preparedStmt.executeUpdate();
//      System.out.println("Am modificat o inregistare!");
  	  
      
  	  
  	 // Adaugarea unei inregistrari
  	  
//      preparedStatement = conn.prepareStatement("insert into  produs values (?, ?, ?)");
//      preparedStatement.setString(1, "6");
//      preparedStatement.setString(2, "banane");
//      preparedStatement.setString(3, "7.9");
//      preparedStatement.executeUpdate();
//      System.out.println("Am facut insert!");

  	  
      
      //Stergerea unei inregistrari    
      
//      preparedStatement = conn.prepareStatement("delete from produs where numele_produsului = 'banane' ");
//      preparedStatement.executeUpdate();
//      System.out.println("Stergere inregistrata cu succes!");   	  
  	  

  	    // write the content into xml file
  	    TransformerFactory transformerFactory = TransformerFactory.newInstance();
  	    Transformer transformer = transformerFactory.newTransformer();
  	    DOMSource source = new DOMSource(doc);
  	    StreamResult result = new StreamResult(new File("D:\\Generare XML si PDF\\ProiectPractica.xml"));
  	    transformer.transform(source, result);
  	  
    }
    
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }
    
  }

}
