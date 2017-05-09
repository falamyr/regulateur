package Figures;

import Game.Card;

public class StraightFlush extends Figure {
	
	// DONNEES
	
			
	// CONSTRUCTEUR
			
	public StraightFlush(Card []board, int numberCards, int length)
	{
		super();
		
		super.type = constants.STRAIGHT_FLUSH;

		numberValues = 1;
		values = new int[numberValues];
		
		values[0] = board[super.findStraightFlush(board, numberCards, length)].getValue();
					
	}
}
