package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Menu;

public class Controller implements ActionListener {

	Menu finestra;

	public Controller(Menu finestra) {
		super();
		this.finestra = finestra;
		finestra.registraEvento(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
			//finestra.stampa_menu();
		//if(e.getSource() == finestra.getIngredienti())
			//finestra.stampa_ingredienti();
		if(e.getSource() == finestra.getSecondi()) {
			finestra.stampa_menu(finestra.getSecondi().getName());
			
		}
		if(e.getSource() == finestra.getDessert()) {
			finestra.stampa_menu(finestra.getDessert().getName());
		}
		if(e.getSource() == finestra.getPrimi())
			finestra.stampa_menu(finestra.getPrimi().getName());
		if(e.getSource() == finestra.getAntipasti())
			finestra.stampa_menu(finestra.getAntipasti().getName());
			//finestra.stampa_menu(finestra.getSecondi().getName());
		/*if(e.getSource() == finestra.getDessert())
			finestra.FinestraDessert();*/
		
	}
	
	
	
}
