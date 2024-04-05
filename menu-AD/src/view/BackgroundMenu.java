package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BackgroundMenu extends JPanel {
	
	private BufferedImage sfondo;
	
	public BackgroundMenu(boolean flag) {
		 try {
				this.sfondo = ImageIO.read(new File("img/ristorantegiardinoblur.png"));
         }
         catch(Exception e) {
             this.setBackground(Color.DARK_GRAY);  
         }
	}

	 public void paintComponent(Graphics g){
	        g.drawImage(sfondo, 0, 0,null);
	}
	
}
