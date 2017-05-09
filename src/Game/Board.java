package Game;

import javax.swing.JLabel;

public class Board {
	
	// DONNEES
	private volatile int numberCards = 0;
	private volatile Card board[] = null;
	
	// CONSTRUCTEUR
	public Board()
	{
		synchronized(this)
		{
			this.board = new Card[constants.NUMBER_CARDS_BOARD];
			for (int i = 0 ; i < constants.NUMBER_CARDS_BOARD ; i++)
				board[i] = null;
		}
	}
	
	
	// METHODES THREAD_GAME
	
	public int getNumberCards()
	{
		synchronized (this) {
			return this.numberCards;
		}
	}
	
	public void putBackCards(Deck D)
	{
		synchronized (this) 
		{			
			for (int i = 0 ; i < numberCards ; i++)
			{
				D.putBackCard(this.board[i]);
				this.board[i] = null;
			}
			this.numberCards = 0;
		}
	}
	
	public void addFlop(Deck deck)
	{
		synchronized (this) 
		{	
			deck.burn();
			for (int i = 0 ; i < constants.NUMBER_CARDS_FLOP ; i++)
			{
				this.board[numberCards] = deck.drawCard();
				numberCards++;
			}
		}
	}
	
	public void addTurn(Deck deck)
	{
		synchronized (this) 
		{	
			deck.burn();
			for (int i = 0 ; i < constants.NUMBER_CARDS_TURN ; i++)
				this.board[numberCards++] = deck.drawCard();
		}
	}
	
	public void addRiver(Deck deck)
	{
		synchronized (this) 
		{	
			deck.burn();
			for (int i = 0 ; i < constants.NUMBER_CARDS_RIVER ; i++)
				this.board[numberCards++] = deck.drawCard();
		}
	}
	
	// RENVOIE LE BOARD EN FIN DE PARTIE, CE BOARD CONTIENT 5 CARTES NON NULLES
	// LE RETOUR EST LA COPIE DU TABLEAU
	public Card []getFinalBoard()
	{
		synchronized (this) 
		{	
			Card []ret = null;
			try {
				if (numberCards != constants.NUMBER_CARDS_BOARD)
					throw new Exception("Le tableau est incomplet quand on lui demande la copie de sa version finale. Nombre de cartes : " + numberCards + ".");
				ret = new Card[constants.NUMBER_CARDS_BOARD];
				for (int i = 0 ; i < numberCards ; i++)
				{
					ret[i] = (Card)(board[i].clone());
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return ret;
		}
	}
	
	// METHODES THREAD_GUI
	
	// RENVOIE UN TABLEAU CONTENANT TOUS LES LABELS DES CARTES
	// LE TABLEAU EST DE TAILLE (NB_CARTES +1), LE DERNIER ELEMENT ETANT NULL
	public JLabel []getCardLabels()
	{
		synchronized(this)
		{
			JLabel []out = new JLabel[numberCards];
			for (int i = 0 ; i < numberCards ; i++)
				out[i] = board[i].getLabel();
			return out;
		}
	}
	
	// TO_STRING
	
	public String toString()
	{
		synchronized(this)
		{
			String ret = "";
			for (int i = 0 ; i < numberCards-1 ; i++)
			{
				ret += board[i].toString() + ", ";
			}
			if (numberCards > 0)
				ret += board[numberCards-1].toString() + ".";
			return ret;
		}
	}

}
