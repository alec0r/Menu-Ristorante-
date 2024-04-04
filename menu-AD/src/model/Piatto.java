package model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "piatto")
@XmlType(propOrder = {"ID_Piatto", "nome", "descrizione", "prezzo"})
public class Piatto {

    @XmlElement(name = "ID_Piatto")
    private int ID_Piatto;

    @XmlElement(name = "nome")
    private String nome;

    @XmlElement(name = "descrizione")
    private String descrizione;

    @XmlElement(name = "prezzo")
    private double prezzo;


    public Piatto() {

    }

    public int getID_Piatto() {
		return ID_Piatto;
	}

	public void setID_Piatto(int iD_Piatto) {
		ID_Piatto = iD_Piatto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public Piatto(int ID_Piatto, String nome, String descrizione, double prezzo) {
        this.ID_Piatto = ID_Piatto;
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return  "<span style='font-weight: bold; font-size: 15px;'>"+nome+"</span><br>" + prezzo + "€<br>" + descrizione + "<br>" ;
    }
}
