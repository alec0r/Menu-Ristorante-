package main;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import model.Ingredienti;
import model.ListaIngredienti;
import model.Piatto;

public class InviaPiatto {
    public static void main(String[] args) {
        int nomePiatto = 4; // Esempio di nome piatto
        /*try {
            nomePiatto = URLEncoder.encode(nomePiatto, StandardCharsets.UTF_8.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        String urlString = "http://localhost/php/api.php?nomePiatto=" + nomePiatto;

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/xml");

            // Leggi la risposta
            JAXBContext context = JAXBContext.newInstance(ListaIngredienti.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ListaIngredienti utenti = (ListaIngredienti) unmarshaller.unmarshal(connection.getInputStream());

            // Stampa gli ingredienti
            for (Ingredienti u : utenti.getIngredienti()) {
                System.out.println(u.toString());
            }

            connection.disconnect();
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }
}
