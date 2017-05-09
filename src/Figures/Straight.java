package Figures;

import Game.Card;

public class Straight extends Figure {
	
	// DONNEES
	
			
	// CONSTRUCTEUR
			
	public Straight(Card []board, int numberCards, int length)
	{
		super();
		
		super.type = constants.STRAIGHT;
			
		values = new int[1];
		numberValues = 1;
		
		values[0] = board[super.findStraight(board, numberCards, length)].getValue();	
		
			
	}
}
