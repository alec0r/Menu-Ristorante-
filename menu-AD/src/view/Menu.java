package view;

import java.awt.BorderLayout;

import java.awt.Dimension;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Controller;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import model.Ingredienti;
import model.Allergeni;
import model.ListaAllergeni;
import model.ListaIngredienti;
import model.ListaPiatti;
import model.Piatto;
import control.Controller;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JLabel titolo;
	private JButton Secondi;
	private JButton Dessert;
	private JPanel panel;
	private JPanel panel_1;
	private JButton Antipasti;
	private JButton Primi;
	private BufferedImage sfondo;
	

	public Menu() {
		super("MENU RISTORANTE GIARDINO");
		inizializzaPannello();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(0, 0);
		this.setExtendedState(this.MAXIMIZED_BOTH);
		this.setBounds(100, 100, 1280, 920);
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		titolo = new JLabel("Ristorante Giardino");
		titolo.setForeground(new Color(255, 255, 255));
		titolo.setBackground(new Color(255, 255, 255));
		titolo.setFont(new Font("Freestyle Script", Font.ITALIC, 90));
		titolo.setBounds(74, 25, 500, 90);
		contentPane.add(titolo, BorderLayout.NORTH);
		
		
		
		panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(1061, 40, 484, 71);
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(null);
		
		Secondi = new JButton("Secondi");
		Secondi.setBounds(249, 23, 102, 23);
		Secondi.setForeground(new Color(255, 255, 255));
		Secondi.setFocusable(false);
		Secondi.setContentAreaFilled(false);
		Secondi.setBorderPainted(false);
		Secondi.setFont(new Font("Arial", Font.PLAIN, 18));
		panel.add(Secondi);
		Secondi.setName("Secondo Piatto");
		Dessert = new JButton("Dessert");
		Dessert.setBounds(361, 23, 102, 23);
		Dessert.setForeground(new Color(255, 255, 255));
		Dessert.setContentAreaFilled(false);
		Dessert.setFocusable(false);
		Dessert.setBorderPainted(false);
		Dessert.setFont(new Font("Arial", Font.PLAIN, 18));
		panel.add(Dessert);
		Dessert.setName("Dessert");
		Antipasti = new JButton("Antipasti");
		Antipasti.setForeground(new Color(255, 255, 255));
		Antipasti.setBounds(25, 23, 102, 23);
		Antipasti.setFocusable(false);
		Antipasti.setContentAreaFilled(false);
		Antipasti.setBorderPainted(false);
		Antipasti.setFont(new Font("Arial", Font.PLAIN, 18));
		panel.add(Antipasti);
		Antipasti.setName("Antipasto");
		Primi = new JButton("Primi");
		Primi.setForeground(new Color(255, 255, 255));
		Primi.setBounds(137, 23, 102, 23);
		Primi.setFocusable(false);
		Primi.setContentAreaFilled(false);
		Primi.setBorderPainted(false);
        Primi.setFont(new Font("Arial", Font.PLAIN, 18));
		panel.add(Primi);
		Primi.setName("Primo Piatto");
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setOpaque(false);
		panel_1.setBounds(30, 128, getWidth()-60, 724);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel = new JLabel("Benvenuti nel nostro Ristorante");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Goudy Old Style", Font.PLAIN, 60));
		lblNewLabel.setBounds(426, 190, 840, 166);
		panel_1.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("<html><div style='text-align: center;'>\"Dove ogni boccone è<br>un viaggio culinario unico\".</div><html>");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(587, 283, 645, 150);
		panel_1.add(lblNewLabel_1);
		this.panel.setVisible(true);
		contentPane.setLayout(new BorderLayout());
		

	}
	
	private void inizializzaPannello() {
		try {
            sfondo = ImageIO.read(new File("img/ristorantegiardino.png"));
        } catch (IOException e) {
            sfondo = null;
        }
		contentPane = new JPanel() {
            public void paintComponent(Graphics g) {
                if (sfondo != null) {
                    g.drawImage(sfondo, 0, 0, null);
                } else {
                    g.setColor(Color.DARK_GRAY);
                    g.fillRect(0, 0, getWidth(), getHeight());
                }
            }
        };
	}

	private void changeBackground(String imagePath) {
        try {
            sfondo = ImageIO.read(new File(imagePath));
            contentPane.repaint();
        } catch (IOException e) {
            System.err.println("Could not read image file: " + e.getMessage());
        }
    }
	
	public void stampa_menu(String c) {
		this.changeBackground("img/ristorantegiardinoblur.png");
		 try {
         c = URLEncoder.encode(c, StandardCharsets.UTF_8.toString());
       } catch (Exception e) {
           e.printStackTrace();
       }
		String url= "http://localhost/Menu-Ristorante-/api/api3.php?categoria=" + c;
		
		URL webServiceUrl = null;	
		ListaPiatti piatti = null;	
		JAXBContext context =null;
		Menu frame= null;
		String menu= "";
		
		try {
						
			webServiceUrl = new URL(url); 
			HttpURLConnection connection = (HttpURLConnection) webServiceUrl.openConnection();
	        connection.setRequestMethod("GET");
	        connection.setRequestProperty("Accept", "application/xml");
			context = JAXBContext.newInstance(ListaPiatti.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			piatti = (ListaPiatti) unmarshaller.unmarshal(webServiceUrl);
			
			 	JLabel temp=null;
			    JButton ingredienti=null;
			    int y=10;
			    this.panel_1.removeAll();
			    ImageIcon info = new ImageIcon("img/info.png");
			    for(Piatto u: piatti.getPiatti()) {
			    	temp = new JLabel("<html>"+u.toString()+"</html>");
			    	temp.setBounds((int) (contentPane.getWidth()/3), y, 400, 80);
			    	temp.setForeground(new Color(255, 255, 255));
			    	
			    	ingredienti = new JButton();
			    	ingredienti.setIcon(info);  
			    	ingredienti.setName(u.getNome());
			    	ingredienti.addActionListener(actionListener);
			    	ingredienti.setBounds((int) (contentPane.getWidth()/1.6), y+20, 35, 35);
			    	ingredienti.setBorderPainted(false);
		            ingredienti.setContentAreaFilled(false);
		            ingredienti.setFocusPainted(false);
		            ingredienti.setForeground(new Color(255, 255, 255));
			    	y+=100;
			        this.panel_1.add(temp);
			        this.panel_1.add(ingredienti);
			        this.panel_1.revalidate(); 
			        this.panel_1.repaint(); 
			    }
			    
		 
		}
		catch(IOException | JAXBException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void stampa_ingredienti(String nome) {
		
		
		String ingredienti= "<h1>Ingredienti</h1><br/>";
		 try {
			 nome = URLEncoder.encode(nome, StandardCharsets.UTF_8.toString());
	       } catch (Exception e) {
	           e.printStackTrace();
	       }
        String urlString = "http://localhost/Menu-Ristorante-/api/api.php?nomePiatto=" + nome;

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/xml");

         
            JAXBContext context = JAXBContext.newInstance(ListaIngredienti.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ListaIngredienti utenti = (ListaIngredienti) unmarshaller.unmarshal(connection.getInputStream());

           
            for (Ingredienti u : utenti.getIngredienti()) {
            	ingredienti+=u.toString()+"<br/>";
            }

            connection.disconnect();
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        
        
       
		String allergeni= "<br/><h1>Allergeni</h1> <br/>";
        
         urlString = "http://localhost/Menu-Ristorante-/api/api2.php?nomePiatto=" + nome;

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/xml");

            
            JAXBContext context = JAXBContext.newInstance(ListaAllergeni.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ListaAllergeni utenti = (ListaAllergeni) unmarshaller.unmarshal(connection.getInputStream());

            
            int c = 0;
            for (Allergeni u : utenti.getAllergeni()) {
                allergeni += u.toString();
                if (c < utenti.getAllergeni().size() - 1) { 
                    allergeni += ", ";
                }
                c++; 
            }

            connection.disconnect();
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        ingredienti+=allergeni;
        String imgnome = nome.trim();
        System.out.println(imgnome);
        ImageIcon immaginepiatto = new ImageIcon("img/"+imgnome+".png");
        Image image = immaginepiatto.getImage().getScaledInstance(600, 400, Image.SCALE_SMOOTH);
        ImageIcon imgpiatto = new ImageIcon(image);
        UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("Panel.background", Color.WHITE);
        JOptionPane.showOptionDialog(null, "<html>"+ingredienti+"</html>", "INGREDIENTI E ALLERGENI", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, imgpiatto, new Object[]{},null);
		
	}
	
	public void registraEvento(Controller controller) {
		//this.ingredienti.addActionListener(controller);
		this.Secondi.addActionListener(controller);
		this.Dessert.addActionListener(controller);
		this.Primi.addActionListener(controller);
		this.Antipasti.addActionListener(controller);
	}

	 ActionListener actionListener = new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Ottieni il pulsante che ha generato l'evento
	            JButton button = (JButton) e.getSource();
	            
	           String nome=button.getName();
	           System.out.println(nome);
	           stampa_ingredienti(nome);
	           
	        }
	    };
	 private JLabel lblNewLabel;
	 private JLabel lblNewLabel_1;



		public JButton getAntipasti() {
			return Antipasti;
		}


		public void setAntipasti(JButton antipasti) {
			Antipasti = antipasti;
		}


		public JButton getPrimi() {
			return Primi;
		}


		public void setPrimi(JButton primi) {
			Primi = primi;
		}

		public JButton getSecondi() {
			return Secondi;
		}


		public void setSecondi(JButton secondi) {
			Secondi = secondi;
		}


		public JButton getDessert() {
			return Dessert;
		}


		public void setDessert(JButton dessert) {
			Dessert = dessert;
		}

		public JLabel getTitolo() {
			return titolo;
		}

		public void setTitolo(JLabel titolo) {
			this.titolo = titolo;
		}    
	}
