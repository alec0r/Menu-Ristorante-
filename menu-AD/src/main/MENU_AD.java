package main;

import java.awt.EventQueue;

import control.Controller;
import view.Menu;

public class MENU_AD {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
					Controller controller = new Controller(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
