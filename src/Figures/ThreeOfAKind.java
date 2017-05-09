package Figures;

import Game.Card;

public class ThreeOfAKind extends Figure {

	// DONNEES
	
			
	// CONSTRUCTEUR
			
	public ThreeOfAKind(Card []board, int numberCards)
	{
		super();
		
		super.type = constants.THREE_OF_A_KIND;

		numberValues = 3;
		values = new int[numberValues];
			
		values[0] = board[super.findGroup(board, numberCards, -1, 3)].getValue();			
		values[1] = board[super.findHighCard(board, numberCards, values, 1)].getValue();		
		values[2] = board[super.findHighCard(board, numberCards, values, 2)].getValue();					
			
	}
}
