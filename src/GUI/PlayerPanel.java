package GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PlayerPanel extends JPanel {

	private static final long serialVersionUID = 7614553637707014837L;
	
	// DONNEES

	private int size = -1;
	
	private int position = -1;
	private int playerType = -1;
	private boolean dealer = false;
	private boolean SB = false;
	private boolean BB = false;

	private GridBagConstraints constraintsName = null;
	private GridBagConstraints constraintsStack = null;
	private GridBagConstraints constraintsDecision = null;
	private GridBagConstraints constraintsCard1 = null;
	private GridBagConstraints constraintsCard2 = null;
	private GridBagConstraints constraintsButton = null;

	private JLabel nameLabel = null;
	private JLabel stackLabel = null;
	private JLabel decisionLabel = null;
	private JLabel cardLabel1 = null;
	private JLabel cardLabel2 = null;
	private JLabel cardsVoid[] = null;

	private JLabel button = null;
	private JLabel buttonDealer = null;
	private JLabel buttonSB = null;
	private JLabel buttonBB = null;

	// CONSTRUCTEUR
	public PlayerPanel(int position) {
		super(new GridBagLayout());

		
		if (Main.constants.GUI_big)
			this.size = constants.BIG_GUI_INDICE;
		else
			this.size = constants.SMALL_GUI_INDICE;

		this.position = position;
		
		constraintsName = new GridBagConstraints();
		constraintsStack = new GridBagConstraints();
		constraintsDecision = new GridBagConstraints();
		constraintsCard1 = new GridBagConstraints();
		constraintsCard2 = new GridBagConstraints();
		constraintsButton = new GridBagConstraints();

		nameLabel = new JLabel(" ");
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		nameLabel.setVerticalAlignment(JLabel.CENTER);
		nameLabel.setMinimumSize(new Dimension(constants.WIDTH_LABEL_MIN[size],
				constants.HEIGHT_LABEL_MIN[size]));
		nameLabel.setPreferredSize(new Dimension(constants.WIDTH_LABEL_PREFERRED[size], constants.HEIGHT_LABEL_PREFERRED[size]));
		nameLabel.setMaximumSize(new Dimension(constants.WIDTH_LABEL_MAX[size], constants.HEIGHT_LABEL_MAX[size]));

		stackLabel = new JLabel(" ");
		stackLabel.setHorizontalAlignment(JLabel.CENTER);
		stackLabel.setVerticalAlignment(JLabel.CENTER);
		stackLabel.setMinimumSize(new Dimension(constants.WIDTH_LABEL_MIN[size],
				constants.HEIGHT_LABEL_MIN[size]));
		stackLabel.setPreferredSize(new Dimension(constants.WIDTH_LABEL_PREFERRED[size], constants.HEIGHT_LABEL_PREFERRED[size]));
		stackLabel.setMaximumSize(new Dimension(constants.WIDTH_LABEL_MAX[size], constants.HEIGHT_LABEL_MAX[size]));

		decisionLabel = new JLabel(" ");
		decisionLabel.setHorizontalAlignment(JLabel.CENTER);
		decisionLabel.setVerticalAlignment(JLabel.CENTER);
		decisionLabel.setMinimumSize(new Dimension(
				constants.WIDTH_LABELDECISION_MIN[size],
				constants.HEIGHT_LABELDECISION_MIN[size]));
		decisionLabel.setPreferredSize(new Dimension(constants.WIDTH_LABELDECISION_PREFERRED[size], constants.HEIGHT_LABELDECISION_PREFERRED[size]));
		decisionLabel.setMaximumSize(new Dimension(constants.WIDTH_LABELDECISION_MAX[size], constants.HEIGHT_LABELDECISION_MAX[size]));

		cardsVoid = new JLabel[2];
		cardsVoid[0] = new JLabel(new ImageIcon(
				IO.loadImage((GUI.constants.IMAGE_CARDS_PATH[size] + "void.png"))));
		cardsVoid[1] = new JLabel(new ImageIcon(
				IO.loadImage((GUI.constants.IMAGE_CARDS_PATH[size] + "void.png"))));
		cardLabel1 = cardsVoid[0];
		cardLabel2 = cardsVoid[1];

		buttonDealer = new JLabel(new ImageIcon(
				IO.loadImage((GUI.constants.IMAGE_BUTTON_DEALER_PATH[size] + ".png"))));
		buttonSB = new JLabel(new ImageIcon(
				IO.loadImage((GUI.constants.IMAGE_BUTTON_SB_PATH[size] + ".png"))));
		buttonBB = new JLabel(new ImageIcon(
				IO.loadImage((GUI.constants.IMAGE_BUTTON_BB_PATH[size] + ".png"))));

		addComponents();

	}

	public void addComponents() {
		setConstraints();
		this.add(nameLabel, constraintsName);
		this.add(stackLabel, constraintsStack);
		this.add(decisionLabel, constraintsDecision);
		this.add(cardLabel1, constraintsCard1);
		this.add(cardLabel2, constraintsCard2);
		if (this.button != null)
			this.add(button, constraintsButton);
	}

	public void constraintsInitialize(GridBagConstraints c) {
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

	public void setConstraints() {
		constraintsInitialize(constraintsName);
		constraintsName.insets = new Insets(constants.h1Player[size],
				constants.w1Player[size], constants.h2Player[size] / 2, constants.w1Player[size]);
		constraintsName.gridwidth = 2;
		constraintsName.gridx = 0;
		constraintsName.gridy = 0;

		constraintsInitialize(constraintsStack);
		constraintsStack.gridx = 0;
		constraintsStack.gridy = 1;
		constraintsStack.insets = new Insets(constants.h2Player[size] / 2,
				constants.w3Player[size], constants.h3Player[size] / 2, constants.w3Player[size]);
		constraintsStack.gridwidth = 2;

		constraintsInitialize(constraintsDecision);
		constraintsDecision.gridx = 0;
		constraintsDecision.gridy = 2;
		constraintsDecision.insets = new Insets(constants.h3Player[size] / 2,
				constants.w4Player[size], constants.h4Player[size] / 2, constants.w4Player[size]);
		constraintsDecision.gridwidth = 2;

		constraintsInitialize(constraintsCard1);
		constraintsCard1.insets = new Insets(constants.h4Player[size] / 2,
				constants.w5Player[size], constants.h5Player[size], constants.w6Player[size] / 2);
		constraintsCard1.gridwidth = 1;
		constraintsCard1.gridx = 0;
		constraintsCard1.gridy = 3;

		constraintsInitialize(constraintsCard2);
		constraintsCard2.insets = new Insets(constants.h4Player[size] / 2,
				constants.w6Player[size] / 2, constants.h5Player[size], constants.w5Player[size]);
		constraintsCard2.gridwidth = 1;
		constraintsCard2.gridx = 1;
		constraintsCard2.gridy = 3;

		constraintsInitialize(constraintsButton);
		constraintsButton.fill = GridBagConstraints.NONE;
		constraintsButton.anchor = GridBagConstraints.FIRST_LINE_END;
		constraintsButton.gridx = 1;
		constraintsButton.gridy = 0;
		constraintsButton.insets = new Insets(constants.h6Player[size], 0, 0,
				constants.w2Player[size]);
		constraintsButton.gridwidth = 1;
	}

	public boolean stillInGame(InformationGUI info) {
		for (int i = 0; i < info.numberPlayers; i++) {
			if (info.positionsPlayers[i] == this.position)
				return true;
		}
		return false;
	}
	
	public int getIndicePlayer(InformationGUI info) {
		for (int i = 0; i < info.numberPlayers; i++) {
			if (info.positionsPlayers[i] == this.position)
				return i;
		}
		return -1;
	}

	
	public void update(InformationGUI info) {

		if (Main.constants.showGUI)
			System.out.println("Mise à jour du Chair Pannel, position : "
					+ position + ".");

		this.removeAll();

		if (stillInGame(info)) {

			int indice = getIndicePlayer(info);
			
			if (!info.isFolded[indice])
			{
			this.dealer = info.dealerPosition == this.position;
			this.SB = info.smallBlindPosition == this.position;
			this.BB = info.bigBlindPosition == this.position;

			
			String name = info.namesPlayers[indice];
			this.nameLabel.setText(name);
			if (name.equals("Candice"))
				this.playerType = constants.CANDICE;
			else if (name.equals("Olaia"))
				this.playerType = constants.OLAIA;
			else if (name.equals("Hasan"))
				this.playerType = constants.HASAN;
			else if (name.equals("Pierre"))
				this.playerType = constants.PIERRE;
			else if (name.equals("Raphaël"))
				this.playerType = constants.RAPHAEL;
			else if (name.equals("Bence"))
				this.playerType = constants.BENCE;
			
			this.stackLabel.setText(Integer.toString(info.stacksPlayers[indice]));

			String decisionString = null;
			switch (info.lastDecisions[indice]) {
			case Game.constants.CHECK:
				decisionString = "CHECK";
				break;
			case Game.constants.CALL:
				decisionString = "CALL";
				break;
			case Game.constants.FOLD:
				decisionString = "FOLD";
				break;
			case Game.constants.RAISE:
				decisionString = "RAISE";
				break;
			default:
				decisionString = " ";
			}
			this.decisionLabel.setText(decisionString);
			
			JLabel []handLabels = info.handsPlayers[indice];

			if (handLabels[0] == null) {
				this.cardLabel1 = cardsVoid[0];
			} 
			else {
				this.cardLabel1 = handLabels[0];
			}
			
			if (handLabels[1] == null) {
				this.cardLabel2 = cardsVoid[1];
			} 
			else {
				this.cardLabel2 = handLabels[1];
			}
			
			if (this.dealer) {
				this.button = this.buttonDealer;
			} else if (this.SB) {
				this.button = this.buttonSB;
			} else if (this.BB) {
				this.button = this.buttonBB;
			} else
				this.button = null;

			this.addComponents();
			if (Main.constants.showGUI)
				System.out.println("Mise à jour du Chair Pannel, position : "
						+ this.position + " terminée.");

			}
			else
			{
				this.decisionLabel.setText("FOLD");
				this.cardLabel1 = cardsVoid[0];
				this.cardLabel2 = cardsVoid[1];
				this.addComponents();
			}
		} else {

			this.playerType = -1;
			this.setMinimumSize(new Dimension(constants.DIMENSIONS_PLAYER_PANEL_VOID[size][0], constants.DIMENSIONS_PLAYER_PANEL_VOID[size][1]));
			this.setPreferredSize(new Dimension(constants.DIMENSIONS_PLAYER_PANEL_VOID[size][0], constants.DIMENSIONS_PLAYER_PANEL_VOID[size][1]));
			this.setMaximumSize(new Dimension(constants.DIMENSIONS_PLAYER_PANEL_VOID[size][0], constants.DIMENSIONS_PLAYER_PANEL_VOID[size][1]));

		}
	}

	public void paintComponent(Graphics g) {
		BufferedImage backgroundImage = null;

		
		if (playerType == -1)
			backgroundImage = IO.loadImage(constants.IMAGE_PLAYER_PANEL_PATH[size]
				+ ".png");
		else
			backgroundImage = IO.loadImage(constants.IMAGE_PLAYER_PANEL_PATH[size]
					+ constants.IMAGE_PLAYER_PANEL_PERSO_PATH[playerType] + ".png");

		
		if (constants.printSizes)
			System.out.println("PlayerPanel : hauteur = " + this.getHeight()
					+ ", largeur = " + this.getWidth() + ".");
		g.drawImage(backgroundImage, 0, 0, this);
	}

}
