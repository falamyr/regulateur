package Figures;

import Game.Card;

public class HighCard extends Figure {
	
	// DONNEES
	
	
	// CONSTRUCTEUR
	
	public HighCard(Card []cards, int numberCards)
	{
		super();
		
		super.type = constants.HIGH_CARD;

		numberValues = Math.min(numberCards, 5);
		values = new int[numberValues];
		
		for (int i = 0 ; i < numberValues ; i++)
			values[i] = cards[i].getValue();
	}

}
