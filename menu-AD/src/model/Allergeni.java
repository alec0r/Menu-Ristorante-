package model;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlRootElement(name = "allergene")
	@XmlType(propOrder = {"nome"})
	
	public class Allergeni {

	    @XmlElement(name = "nome")
	    private String nome;

	    public Allergeni() {
			
		}
		public Allergeni(String nomea) {
			this.nome = nome;
		}

		public String toString() {
			 return  nome + " ";
		}
	    
		
	}
