package GUI;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class BoardPanel extends JPanel {
	
	// DONNEES
	
	
	private static final long serialVersionUID = 1L;

	private GridBagConstraints c = null;
			
	private JLabel cardsLabels[] = null;
	private JLabel cardsVoid []= null;

	
	// CONSTRUCTEUR
	
	public BoardPanel()
	{
		super(new GridBagLayout());
		
		cardsVoid = new JLabel[5];
		cardsLabels = new JLabel[5];
					
		for (int i = 0 ; i < 5 ; i++)
		{
			cardsVoid[i] = new JLabel(new ImageIcon(IO.loadImage((GUI.constants.IMAGE_CARDS_PATH + "void.png"))));
			cardsLabels[i] = cardsVoid[i];
		}
		
		c = new GridBagConstraints();
		this.addComponents();
		
	}

	// METHODES
	
	public void update(InformationGUI info)
	{

		if (Main.constants.showGUI)
			System.out.println("Mise à jour du BoardPannel.");
		
		this.removeAll();
		
		int numberCardsBoard = info.numberCardsBoard;
		JLabel []cardsBoardLabels = info.cardsBoardLabels;
		
		for (int i = 0 ; i < numberCardsBoard ; i++)
		{
			this.cardsLabels[i] = cardsBoardLabels[i];
		}
		for (int i = numberCardsBoard ; i < Game.constants.NUMBER_CARDS_BOARD ; i++)
		{
			this.cardsLabels[i] = cardsVoid[i];
		}
		
		this.addComponents();

		if (Main.constants.showGUI)
			System.out.println("Mise à jour du BoardPannel terminée.");
	}
	
	public void addComponents()
	{
		constraintsInitialize(c);
		
		c.insets = new Insets(constants.h1Board, constants.w1Board, constants.h1Board, constants.w2Board/2);
		c.gridx = 0;
		this.add(cardsLabels[0], c);		

		c.insets = new Insets(constants.h1Board, constants.w2Board/2, constants.h1Board, constants.w2Board/2);
		c.gridx = 1;
		this.add(cardsLabels[1], c);		

		c.insets = new Insets(constants.h1Board, constants.w2Board/2, constants.h1Board, constants.w2Board/2);
		c.gridx = 2;
		this.add(cardsLabels[2], c);

		c.insets = new Insets(constants.h1Board, constants.w2Board/2, constants.h1Board, constants.w2Board/2);
		c.gridx = 3;
		this.add(cardsLabels[3], c);

		c.insets = new Insets(constants.h1Board, constants.w2Board/2, constants.h1Board, constants.w1Board);
		c.gridx = 4;
		this.add(cardsLabels[4], c);
	}
	
	public void constraintsInitialize(GridBagConstraints c)
	{
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0, 0, 0, 0);
		c.gridwidth = 1;
		c.ipadx = 0;
		c.ipady = 0;
		
	}
	
	public void paintComponent(Graphics g)
	{
		//super.paintComponent(g);
		BufferedImage backgroundImage = null;		
		
		backgroundImage = IO.loadImage(constants.IMAGE_BOARD_PANEL_PATH);		
		g.drawImage(backgroundImage, 0, 0, this);
		if (constants.printSizes)
			System.out.println("PanelBoard : hauteur = " + this.getHeight() + ", largeur = " + this.getWidth() + ".");
      
	}

}
