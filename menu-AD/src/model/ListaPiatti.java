package model;

import java.util.ArrayList;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="piatti")
@XmlType(propOrder= {"piatti"})
public class ListaPiatti {

	@XmlElement(name="piatto")
	private ArrayList<Piatto> piatti;

	public ListaPiatti() {
	}
	
	public ListaPiatti(ArrayList<Piatto> piatti) {
		super();
		this.piatti= piatti;
	}

	public ArrayList<Piatto> getPiatti() {
		return piatti;
	}

	public void setPiatti(ArrayList<Piatto> piatti) {
		this.piatti = piatti;
	}
	
}
