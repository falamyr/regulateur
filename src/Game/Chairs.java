package Game;


public class Chairs {

	// DONNEES

	private int numberChairs = 0;
	private Player[] players = null;
	private boolean[] empty = null;

	private int dealer = -1;

	// CONSTRUCTEUR
	public Chairs(Player[] players) {
		this.numberChairs = constants.NUMBER_PLAYERS;
		this.players = new Player[numberChairs];
		this.empty = new boolean[numberChairs];
		for (int i = 0; i < numberChairs; i++) {
			this.players[i] = players[i];
			this.empty[i] = false;
		}
	}

	// ACCESSEURS
	public Player getDealer() {
		try {
			if (empty[dealer])
				throw new Exception(
						"La chaise portant le jeton dealer est vide.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.players[dealer];
	}
	
	public Player nextPlayer(Player P)
	{
		int pos = findPlayer(P);
		return players[nextPosition(pos)];
	}  
	
	private int findPlayer(Player P)
	{
		int pos = -1;
		for (int i = 0 ; i < numberChairs ; i++)
		{
			if (P.equals(players[i]))
				pos = i;
		}
		
		try {
			if (pos == -1)
				throw new Exception("Le joueur " + P.getName() + " n'a pas été trouvé.");
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return pos;
	}
	
	private int nextPosition(int pos)
	{		
		int next = (pos+1)%numberChairs;
		while(empty[next] && next != pos)
			next = (next+1)%numberChairs;
		
		try {
			if (next == pos)
				throw new Exception("Toutes les chaises sont vides.");
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return next;
	}
	
	// METHODES
	public void update()
	{
		for (int i = 0 ; i < numberChairs ; i++)
		{
			if (!empty[i] && players[i].getStack() == 0)
				empty[i] = true;
		}
		if (!(getNumberPlayersInGame() == 1))
			dealer = nextPosition(dealer);
	}
	
	public int getNumberPlayersInGame()
	{
		int number = 0;
		for (int i = 0 ; i < numberChairs ; i++)
		{
			if (!empty[i])
				number++;
		}
		return number;
	}
	
	public int getNumberPlayersNotFolded()
	{
		int number = 0;
		for (int i = 0 ; i < numberChairs ; i++)
		{
			if (!empty[i]  && !players[i].isFolded())
				number++;
		}
		return number;
		
	}
	
	public int getNumberPlayersNotFoldedNotAllin()
	{
		int number = 0;
		for (int i = 0 ; i < numberChairs ; i++)
		{
			if (!empty[i] && !players[i].isFolded() && !players[i].isAllIn())
				number++;
		}
		return number;
	}
	
	public int getNumberPlayersWhoHaventSpoken()
	{
		int number = 0;
		for (int i = 0 ; i < numberChairs ; i++)
		{
			if (!empty[i] && !players[i].isFolded() && !players[i].isAllIn() && !players[i].hasSpoken())
				number++;
		}
		return number;
	}
	
	// PLACE LES JOUEURS
	// TIRE UNE CARTE PAR JOUEUR
	// LA CARTE LA PLUS FORTE EST PLACEE EN POSITION 0
	// PUIS DANS L'ORDRE DECROISSANT
	// REPLACE LES CARTES TIREES DANS LE DECK
	public void placePlayers(Deck deck)
	{
		if (Main.constants.showInitialization)
			System.out.println("Placement des joueurs.");
		
				
		Card [] placingCards = new Card[numberChairs];
		for (int i = 0 ; i < numberChairs ; i++)
		{
			placingCards[i] = deck.drawCard();
		}
		
		for (int i = 0 ; i < numberChairs - 1; i++)
		{
			for (int j = i ; j < numberChairs ; j++)
			{
				if (placingCards[j].isHigher(placingCards[i]) || 
						(placingCards[j].isEquivalent(placingCards[i]) && placingCards[j].getColor() > placingCards[i].getColor()))					
					{
						
						Player P = players[i];
						players[i] = players[j];
						players[j] = P;
					}				
			}
		}
		
		for (int i = 0 ; i < numberChairs ; i++)
			players[i].setPosition(i);
		
		if (Main.constants.showPlacePlayers)
		{
			for (int i = 0 ; i < numberChairs ; i++)
				System.out.println("Chaise " + i + " : " + players[i].getName() + "\n");			
		}
		
		this.dealer = 0;
		
		for (int i = 0 ; i < numberChairs ; i++)
			deck.putBackCard(placingCards[i]);
		deck.rebuild();

		
		if (Main.constants.showInitialization)
			System.out.println("Placement des joueurs terminé.");		
	}
	
	

}
