package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import model.ListaPiatti;
import model.Piatto;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JLabel titolo;
	private JLabel lblNewLabel;

	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(0, 0);
		this.setExtendedState(this.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		titolo = new JLabel("MENU");
		titolo.setFont(new Font("Noto Sans", Font.BOLD, 40));
		titolo.setBounds(27, 11, 375, 71);
		contentPane.add(titolo);
		
		lblNewLabel = new JLabel();
		lblNewLabel.setText("<html>"+this.stampa_menu()+"</html>");
		lblNewLabel.setFont(new Font("Noto Sans", Font.PLAIN, 17));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(27, 93, 823, 381);
		contentPane.add(lblNewLabel);
	}

	public JLabel getTitolo() {
		return titolo;
	}

	public void setTitolo(JLabel titolo) {
		this.titolo = titolo;
	}

	
	public String stampa_menu() {
		String url= "http://localhost/prova/php/api.php";
		
		URL webServiceUrl = null;	
		ListaPiatti utenti = null;	
		JAXBContext context =null;
		Menu frame= null;
		String menu= null;
		
		try {
						
			webServiceUrl = new URL(url); 
	
			context = JAXBContext.newInstance(ListaPiatti.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			utenti = (ListaPiatti) unmarshaller.unmarshal(webServiceUrl);
			
			for(Piatto u: utenti.getPiatti()) 
					menu+=u.toString();
		 
		}
		catch(IOException | JAXBException e) {
			System.out.println(e.getMessage());
		}
		return menu;
	}
}
