package Figures;

import Game.Card;

public class TwoPairs extends Figure {
	
	// DONNEES
	
		
	// CONSTRUCTEUR
		
	public TwoPairs(Card []board, int numberCards)
	{
		super();
		
		super.type = constants.TWO_PAIRS;

		numberValues = 3;
		values = new int[numberValues];
		
		values[0] = board[super.findGroup(board, numberCards, -1, 2)].getValue();			
		values[1] = board[super.findGroup(board, numberCards, values[0], 2)].getValue();		
		values[2] = board[super.findHighCard(board, numberCards, values, 2)].getValue();					
		
	}
}
