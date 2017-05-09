package Figures;

import Game.Card;

public class FullHouse extends Figure {
	
	// DONNEES
	
			
	// CONSTRUCTEUR
			
	public FullHouse(Card [] board, int numberCards)
	{
		super();
		
		super.type = constants.FULL_HOUSE;

		numberValues = 2;
		values = new int[numberValues];
			
		values[0] = board[super.findGroup(board, numberCards, -1, 3)].getValue();			
		values[1] = board[super.findGroup(board, numberCards, values[0], 2)].getValue();					
			
	}
}
