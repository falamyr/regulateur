package Figures;

import Game.Card;

public class Pair extends Figure {
	
	// DONNEES
	
		
	// CONSTRUCTEUR
		
	public Pair(Card []board, int numberCards) 
	{
		super();
		
		
		super.type = constants.PAIR;

		numberValues = 4;
		values = new int[numberValues];
		
		int indicePair = super.findGroup(board, numberCards, -1, 2);
		
		values[0] = board[indicePair].getValue();
		
		int i = 1;
		while(i < numberValues)
		{
			values[i] = board[super.findHighCard(board, numberCards, values, i)].getValue();
			i++;
		}
		
		
	}
}
