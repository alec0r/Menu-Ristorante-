package model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlRootElement(name = "ingrediente")
	@XmlType(propOrder = {"nome", "quantita"})
	
	public class Ingredienti {

	    @XmlElement(name = "nome")
	    private String nome;

	    @XmlElement(name = "quantita")
	    private int quantita;

	    public Ingredienti() {
			
		}
		public Ingredienti(String nome, int quantita) {
			this.nome = nome;
			this.quantita = quantita;
		}

		public String toString() {
			 return  nome + ", quantita=" + quantita + "";
		}
	    
		
	}

