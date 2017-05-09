package Figures;

import Game.Card;

public class FourOfAKind extends Figure {
	
	// DONNEES
	
			
	// CONSTRUCTEUR
			
	public FourOfAKind(Card []board, int numberCards)
	{
		super();
		
		super.type = constants.FOUR_OF_A_KIND;

		numberValues = 2;
		values = new int[numberValues];
			
		values[0] = board[super.findGroup(board, numberCards, -1, 4)].getValue();			
		values[1] = board[super.findHighCard(board, numberCards, values, 1)].getValue();					
			
	}
}
