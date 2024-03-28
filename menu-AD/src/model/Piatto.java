package model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "piatto")
@XmlType(propOrder = {"ID_Piatto", "nome", "descrizione", "prezzo", "categoria"})
public class Piatto {

    @XmlElement(name = "ID_Piatto")
    private int ID_Piatto;

    @XmlElement(name = "nome")
    private String nome;

    @XmlElement(name = "descrizione")
    private String descrizione;

    @XmlElement(name = "prezzo")
    private double prezzo;

    @XmlElement(name = "categoria")
    private String categoria;

    public Piatto() {

    }

    public Piatto(int ID_Piatto, String nome, String descrizione, double prezzo, String categoria) {
        this.ID_Piatto = ID_Piatto;
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return  "<b>"+nome+"</b> " + prezzo + "€<br>" + descrizione + "<br><br>" ;
    }
}
