package main;

import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;

import jakarta.xml.bind.JAXBException;
import model.ListaPiatti;
import model.Piatto;
import view.Menu;

public class LeggiUtenti {

	public static void main(String[] args) {
		
		String url= "http://localhost/prova/php/api.php";
		
		URL webServiceUrl = null;	
		ListaPiatti utenti = null;	
		JAXBContext context =null;
		Menu frame= null;
		
		try {
						
			webServiceUrl = new URL(url); 
	
			context = JAXBContext.newInstance(ListaPiatti.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			utenti = (ListaPiatti) unmarshaller.unmarshal(webServiceUrl);
			
			for(Piatto u: utenti.getPiatti())
				System.out.println(u.toString());
		 
		}
		catch(IOException | JAXBException e) {
			System.out.println(e.getMessage());
		}

	}

}
