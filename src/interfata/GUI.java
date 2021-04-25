package interfata;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;


public class GUI{
			
			JButton b_order_1;
			JButton b_order_2;
			JButton b_order_3;
			JButton b_order_4;
			JButton b_cancel;
			
			JFrame f = new JFrame();
			
			public GUI() {
				
				b_order_1 = new JButton("Generare_XML");
				b_order_2 = new JButton("Generare_PDF_SAX");
				b_order_3 = new JButton("Generare_PDF_DOM");
				b_order_4 = new JButton("Deschidere_Folder");
				b_cancel = new JButton("Iesire");
				
				Cmd Generare_XML = new Cmd(this);
				Cmd Generare_PDF_SAX = new Cmd(this);
				Cmd Generare_PDF_DOM = new Cmd(this);
				Cmd Deschidere_Folder = new Cmd(this);
				Cmd Iesire = new Cmd(this);
					
				b_order_1.addActionListener(Generare_XML);
				b_order_2.addActionListener(Generare_PDF_SAX);
				b_order_3.addActionListener(Generare_PDF_DOM);
				b_order_4.addActionListener(Deschidere_Folder);
				b_cancel.addActionListener(Iesire);
			
				Container c_panel = f.getContentPane();
				c_panel.setLayout(null);
				
				b_order_1.setBounds(220,140,200,50);
				b_order_1.setBackground(Color.GREEN);
				c_panel.add(b_order_1);
				
				b_order_2.setBounds(220,240,200,50);
				b_order_2.setBackground(Color.RED);
				c_panel.add(b_order_2);
				
				b_order_3.setBounds(220,340,200,50);
				b_order_3.setBackground(Color.BLUE);
				c_panel.add(b_order_3);
				
				b_order_4.setBounds(220,440,200,50);
				b_order_4.setBackground(Color.CYAN);
				c_panel.add(b_order_4);

		
				b_cancel.setBounds(220,650,200,50);
				b_cancel.setBackground(Color.GRAY);
				c_panel.add(b_cancel);
		    		 
				f.setSize(700,900);
				f.setVisible(true);
			}

		
}