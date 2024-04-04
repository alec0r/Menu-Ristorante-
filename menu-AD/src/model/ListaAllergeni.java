package model;

import java.util.ArrayList;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="informazioni")
public class ListaAllergeni {


	@XmlElement(name="allergene")
	private ArrayList<Allergeni> Allergeni;

	public ListaAllergeni() {
		
	}

	public ListaAllergeni(ArrayList<Ingredienti> ingredienti) {
		super();
		this.Allergeni= Allergeni;
	}

	public ArrayList<Allergeni> getAllergeni() {
		return Allergeni;
	}

	public void setAllergeni(ArrayList<Allergeni> allergeni) {
		Allergeni = allergeni;
	}




	
	
}