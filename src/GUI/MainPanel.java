package GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	// DONNEES		
	private PlayerPanel playerPanels [] = null;	
	private BoardPanel boardPanel = null;	
	private JLabel betLabels [] = null;	
	private JLabel potLabel = null;
	
	
	private int spacesRight[] = {constants.w2Panel, constants.w4Panel/2, constants.w3Panel, constants.w1Panel};
	private int spacesLeft[] = {constants.w1Panel, constants.w3Panel, constants.w4Panel/2, constants.w2Panel};
		
	private int spacesUp[] = {constants.h1Panel, constants.h3Panel, constants.h2Panel};
	private int spacesDown[] = {constants.h2Panel, constants.h3Panel, constants.h1Panel};
		
	private GridBagConstraints c = null;
	
	
	// CONSTRUCTEUR
	
	public MainPanel()
	{
		super(new GridBagLayout());
		c = new GridBagConstraints();
				
		int numberPlayers = Game.constants.NUMBER_PLAYERS;
		playerPanels = new PlayerPanel[Game.constants.NUMBER_PLAYERS];
		betLabels = new JLabel[Game.constants.NUMBER_PLAYERS];
		potLabel = new JLabel(" ");
		
		boardPanel = new BoardPanel();
		
		potLabel.setMinimumSize(new Dimension(60, 20));
		potLabel.setPreferredSize(new Dimension(60, 20));
		potLabel.setMaximumSize(new Dimension(80, 20));

		potLabel.setHorizontalAlignment(JLabel.CENTER);
		potLabel.setVerticalAlignment(JLabel.CENTER);
		
		for (int i = 0 ; i < numberPlayers ; i++)
		{
			playerPanels[i] = new PlayerPanel(i);
			betLabels[i] = new JLabel(" ");
			betLabels[i].setMinimumSize(new Dimension(40, 20));
			betLabels[i].setPreferredSize(new Dimension(50, 20));
			betLabels[i].setMaximumSize(new Dimension(60, 20));
		}	
		
		this.addComponents();
	}
	
	
	public void addComponents()
	{
				
		// PLAYER PANELS
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.weightx = 0.0;
		c.weighty = 0.0;
		c.gridwidth = 1;
		c.ipadx = 0;
		c.ipady = 0;
		
		c.gridx = 1;
		c.gridy = 0;
		c.insets = new Insets(spacesUp[0], spacesLeft[1], spacesDown[0], spacesRight[1]);
		this.add(playerPanels[0], c);
		
		c.gridx = 3;
		c.gridy = 0;
		c.insets = new Insets(spacesUp[0], spacesLeft[2],  spacesDown[0], spacesRight[2]);
		this.add(playerPanels[1], c);
		
		c.gridx = 4;
		c.gridy = 1;
		c.insets = new Insets(spacesUp[1], spacesLeft[3], spacesDown[1], spacesRight[3]);
		this.add(playerPanels[2], c);
		

		c.gridx = 3;
		c.gridy = 2;
		c.insets = new Insets(spacesUp[2], spacesLeft[2], spacesDown[2], spacesRight[2]);
		this.add(playerPanels[3], c);
		
		c.gridx = 1;
		c.gridy = 2;
		c.insets = new Insets(spacesUp[2], spacesLeft[1], spacesDown[2], spacesRight[1]);
		this.add(playerPanels[4], c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(spacesUp[1], spacesLeft[0], spacesDown[1], spacesRight[0]);
		this.add(playerPanels[5], c);
		
		
		
		// BOARD
		
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 3;
		c.insets = new Insets(0, 0, 0, 0);
		this.add(boardPanel, c);
		
		
		
		
		// BETS
		
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.NORTH;
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.insets = new Insets(0, 0, 0, 0);
		this.add(betLabels[0], c);

		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.NORTH;
		c.gridx = 3;
		c.gridy = 1;
		c.insets = new Insets(0, 0, 0, 0);
		this.add(betLabels[1], c);

		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 3;
		c.gridy = 1;
		c.insets = new Insets(0, 0, 0, 0);
		this.add(betLabels[2], c);

		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.SOUTH;
		c.gridx = 3;
		c.gridy = 1;
		c.insets = new Insets(0, 0, 0, 0);
		this.add(betLabels[3], c);
		
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.SOUTH;
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(0, 0, 0, 0);
		this.add(betLabels[4], c);
		
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(0, 0, 0, 0);
		this.add(betLabels[5], c);
		
		// POT
		
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.SOUTH;
		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth = 1;
		c.insets = new Insets(0, constants.w4Panel/4, 0, constants.w4Panel/4);
		this.add(potLabel, c);
	}
	
	
	// METHODES
	
	public void update(InformationGUI info)
	{	
		if (Main.constants.showGUI)
			System.out.println("Mise à jour du Main Pannel.");
		
		try {
			
			this.removeAll();			

			// UPDATE BOARD PANEL	
			this.boardPanel.update(info);

			
			int numberPlayers = Game.constants.NUMBER_PLAYERS;
			
			// UPDATE PLAYER PANELS
			for (int i = 0 ; i < numberPlayers ; i++)
			{
				playerPanels[i].update(info);
			}
			
			// UPDATE BETS
			numberPlayers = info.numberPlayers;
			int []positionsPlayers = info.positionsPlayers;
			int []bets = info.bets;
			for (int i = 0 ; i < numberPlayers ; i++)
			{
				int position = positionsPlayers[i];
				if (bets[i] != 0)
					betLabels[position].setText(Integer.toString(bets[i]));
				else if (bets[i] == 0)
					betLabels[position].setText(" ");
				else
				{
					throw new Exception("L'une des mises à négative (" + bets[i] + " à la mise à jour de l'interface.");
				}
			}	

			// UPDATE POTS
			int numberPots = info.numberPots;
			int []pots = info.pots;
			String ret = "<html> ";
			for (int i = 0 ; i < numberPots-1 ; i++)
			{
				ret += Integer.toString(pots[i]) + "<br/>";
			}
			if (numberPots > 0)
				ret += Integer.toString(pots[numberPots-1]);
			
			ret += "</html>";
			potLabel.setText(ret);
			potLabel.setMinimumSize(new Dimension(60, 75));
			
				
			this.addComponents();			
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}	
		

		if (Main.constants.showGUI)
			System.out.println("Mise à jour du Main Pannel terminée.");
	}
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		BufferedImage backgroundImage = null;
		backgroundImage = IO.loadImage(constants.IMAGE_BACKGROUND_PATH);
		
		if (constants.printSizes)
			System.out.println("MainPanel : hauteur = " + this.getHeight() + ", largeur = " + this.getWidth() + ".");
        g.drawImage(backgroundImage, 0, 0, this); // see javadoc for more info on the parameters            
   
	}
}
