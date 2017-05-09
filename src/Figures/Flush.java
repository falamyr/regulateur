package Figures;

import Game.Card;

public class Flush extends Figure {
	
	// DONNEES
	
			
	// CONSTRUCTEUR
			
	public Flush(Card []board, int numberCards, int length)
	{
		super();
		
		super.type = constants.FLUSH;
			
		values = new int[1];
		numberValues = 1;
		values[0] = board[super.findFlush(board, numberCards, length)].getValue();								
			
	}
}
