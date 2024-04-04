package model;

import java.util.ArrayList;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="informazioni")
public class ListaIngredienti {


	@XmlElement(name="ingrediente")
	private ArrayList<Ingredienti> ingredienti;

	public ListaIngredienti() {
		
	}

	public ListaIngredienti(ArrayList<Ingredienti> ingredienti) {
		super();
		this.ingredienti= ingredienti;
	}



	public ArrayList<Ingredienti> getIngredienti() {
		return ingredienti;
	}



	public void setIngredienti(ArrayList<Ingredienti> ingredienti) {
		this.ingredienti = ingredienti;
	}

	
	
}
