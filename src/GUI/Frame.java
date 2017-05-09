package GUI;

import java.awt.Graphics;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;



public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	
	
	// DONNEES	
	private MainPanel mainPanel = null;
	
	
		
	// CONSTRUCTEUR
	public Frame()
	{
		this.setTitle("Régulateur");
		this.setSize(constants.WIDTH_FRAME, constants.HEIGHT_FRAME);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		this.setResizable(false);
			
		ImageIcon icon = new ImageIcon(IO.loadImage(constants.IMAGE_ICONE_PATH));
		this.setIconImage(icon.getImage());
					
				
		this.mainPanel = new MainPanel();
		this.setContentPane(mainPanel);
		
		this.setVisible(true);
		this.repaint();
			
	}		
	
	// ACCESSEURS
	
	
	// METHODES
	public void paintComponent(Graphics g) throws IOException
	{
		
	}

	public void update(InformationGUI info)
	{
		this.mainPanel.update(info);
	}

	
	

	 
}
