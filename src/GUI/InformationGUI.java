package GUI;

import javax.swing.JLabel;


public class InformationGUI {
	
	
	protected int numberCardsBoard = 0;
	protected JLabel []cardsBoardLabels = null;
	
	protected int numberPlayers = 0;
	protected int []positionsPlayers = null;
	protected boolean []isFolded = null;
	protected String []namesPlayers = null;
	protected int []stacksPlayers = null;
	protected int []lastDecisions = null;
	protected JLabel [][]handsPlayers = null;
	
	protected int dealerPosition = -1;
	protected int smallBlindPosition = -1;
	protected int bigBlindPosition = -1;
	
	
	protected int []bets = null;
	
	protected int numberPots = 0;
	protected int []pots = null;
	
	public InformationGUI(
			int numberCardsBoard, 
			JLabel []cardsBoardLabels,
			int numberPlayers,
			int []positionsPlayers,
			boolean []isFolded,
			String []namesPlayers,
			int []stacksPlayers,
			int []lastDecisions,
			JLabel [][]handsPlayers,
			int dealerPosition,
			int smallBlindPosition,
			int bigBlindPosition,
			int []bets,
			int numberPots,
			int []pots)
	{
		this.numberCardsBoard = numberCardsBoard;
		this.cardsBoardLabels = cardsBoardLabels;
		
		this.numberPlayers = numberPlayers;
		this.positionsPlayers = positionsPlayers;
		this.isFolded = isFolded;
		this.namesPlayers = namesPlayers;
		this.stacksPlayers = stacksPlayers;
		this.lastDecisions = lastDecisions;
		this.handsPlayers = handsPlayers;
		
		this.dealerPosition = dealerPosition;
		this.smallBlindPosition = smallBlindPosition;
		this.bigBlindPosition = bigBlindPosition;
		
		this.bets = bets;
		
		this.numberPots = numberPots;
		this.pots = pots;
	}

}
