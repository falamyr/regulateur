package Figures;

import Game.Board;
import Game.Card;


public class Figure {
	
	// DONNEES 
	
	protected int type = constants.UNDEFINED;
	
	protected int values [] = null;
	protected int numberValues = 0;
	
	// CONSTRUCTEUR
	
	public Figure()
	{
		
	}
	
	
	// METHODES
	
	public static void sort(Card []cards, int numberCards)
	{
		for (int i = 0 ; i < numberCards -1 ; i++)
		{
			for (int j = i ; j < numberCards ; j++)
			{
				if (cards[j].isHigher(cards[i]))
				{
					Card tmp = cards[i];
					cards[i]= cards[j];
					cards[j] = tmp;
				}
			}
		}
	}
	
	public static Figure detect(final Card []hand, final Board board)
	{

		int numberCards = Game.constants.NUMBER_CARDS_HAND + Game.constants.NUMBER_CARDS_BOARD;
		Card []cards = new Card[numberCards];
		
		cards[0] = hand[0];
		cards[1] = hand[1];
		
		Card []finalBoard = board.getFinalBoard();
		for (int i = 2 ; i < numberCards ; i++)
			cards[i] = finalBoard[i-2];
			
		
		sort(cards, numberCards);
		
		
		int length = 5;
		if (numberCards == 2)
			length = 2;
		
		if (detectStraightFlush(cards, numberCards, length))
			return new StraightFlush(cards, numberCards, length);
		
		else if (detectFourOfAKind(cards, numberCards))
			return new FourOfAKind(cards, numberCards);
		
		else if (detectFullHouse(cards, numberCards))
			return new FullHouse(cards, numberCards);
		
		else if (detectFlush(cards, numberCards, length))
			return new Flush(cards, numberCards, length);
		
		else if (detectStraight(cards, numberCards, length))
			return new Straight(cards, numberCards, length);
		
		else if (detectThreeOfAKind(cards, numberCards))
			return new ThreeOfAKind(cards, numberCards);
		
		else if (detectTwoPairs(cards, numberCards))		
			return new TwoPairs(cards, numberCards);
		
		else if (detectPair(cards, numberCards))
			return new Pair(cards, numberCards);
		else
			return new HighCard(cards, numberCards);
	}
	
	public static int classify(Card []cards, int numberCards)
	{
		int length = 5;
		if (numberCards == 2)
			length = 2;
		
		if (detectStraightFlush(cards, numberCards, length))
			return constants.STRAIGHT_FLUSH;
		
		else if (detectFourOfAKind(cards, numberCards))
			return constants.FOUR_OF_A_KIND;
		
		else if (detectFullHouse(cards, numberCards))
			return constants.FULL_HOUSE;
		
		else if (detectFlush(cards, numberCards, length))
			return constants.FLUSH;
		
		else if (detectStraight(cards, numberCards, length))
			return constants.STRAIGHT;
		
		else if (detectThreeOfAKind(cards, numberCards))
			return constants.THREE_OF_A_KIND;
		
		else if (detectTwoPairs(cards, numberCards))	
			return constants.TWO_PAIRS;
		
		else if (detectPair(cards, numberCards))
			return constants.PAIR;
		else
			return constants.HIGH_CARD;
	}
	
	private static boolean detectPair(Card []board, int numberCards)
	{
		 return (findGroup(board, numberCards, -1, 2) != -1);
	}

	private static boolean detectTwoPairs(Card []board, int numberCards)
	{
		int pair1 = findGroup(board, numberCards, -1, 2);
		if (pair1 != -1)
		{
			int avoid = board[pair1].getValue();
			int pair2 = findGroup(board, numberCards, avoid, 2);
			return pair2 != -1;
		}
		return false;
	}
	
	private static boolean detectThreeOfAKind(Card []board, int numberCards)
	{
		return findGroup(board, numberCards, -1, 3) != -1;
	}
	
	private static boolean detectStraight(Card []board, int numberCards, int length)
	{
		return findStraight(board, numberCards, length) != -1;
	}
	
	private static boolean detectFlush(Card []board, int numberCards, int length)
	{
		return findFlush(board, numberCards, length) != -1;
	}
	
	private static boolean detectFullHouse(Card []board, int numberCards)
	{
		int three = findGroup(board, numberCards, -1, 3);
		if (three != -1)
		{
			int avoid = board[three].getValue();
			int pair = findGroup(board, numberCards, avoid, 2);
			return pair != -1;
		}
		return false;
	}
	
	private static boolean detectFourOfAKind(Card []board, int numberCards)
	{
		return findGroup(board, numberCards, -1, 4) != -1;
	}
	
	private static boolean detectStraightFlush(Card []board, int numberCards, int length)
	{
		return findStraightFlush(board, numberCards, length) != -1;
	}
	
	protected static int findHighCard(Card []board, int numberCards, int avoidValues[], int numberAvoid)
	{
		try {
			int indice = 0;
			while (indice < numberCards)
			{
				boolean found = true;
				for (int j = 0 ; j < numberAvoid ; j++)
				{
					found = found && board[indice].getValue() != avoidValues[j];
				}
				if (found)
					return indice;
				indice++;
			}
			throw new Exception("Carte haute non trouvée dans le tableau suivant\n" + board.toString());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		return -1;		
	}
	
	protected static int findGroup(Card []board, int numberCards, int avoidValue, int number)
	{
		boolean found = true;
		int indice = 0;
		while (indice < numberCards - (number-1))
		{
			found = true;
			if (board[indice].getValue() != avoidValue)
			{
				for (int i = 1 ; i < number ; i++)
				{
					found = found && board[indice + i].getValue() == board[indice].getValue();
						
				}
				if (found)
				{
					return indice;
				}
			}
			indice++;
		}
		return -1;
	}
	
	protected static int findFlush(Card []board, int numberCards, int lengthFlush)
	{
		for (int c = 0 ; c < 4 ; c++)
		{
			int nb = 0;
			for (int j = 0 ; j < numberCards ; j++)
			{
				if (board[j].getColor() == c)
					nb++;
			}
			if (nb >= lengthFlush)
				return c;
		}
		return -1;
	}
	
	protected static int findStraight(Card []board, int numberCards, int lengthStraight)
	{
		boolean found = true;
		for (int i = 0 ; i < numberCards - lengthStraight + 1 ; i++)
		{
			found = true;
			
			for (int j = 0 ; j < lengthStraight - 1 ; j++)
			{
				found = found && Figure.contains(board, numberCards, board[i].getValue() - j);
			}
			
			if ((lengthStraight == 5 && board[i].getValue() == Game.constants.FIVE)
				||  (lengthStraight == 2 && board[i].getValue() == Game.constants.TWO))
				found = found & Figure.contains(board, numberCards, Game.constants.ACE);
			else
				found = found & Figure.contains(board, numberCards, board[i].getValue() - (lengthStraight - 1));
				
			
			if (found)
			{
				return i;
			}
		}
		return -1;
	}
	
	protected static int findStraightFlush(Card []board, int numberCards, int lengthStraightFlush)
	{
		boolean found = true;
		for (int i = 0 ; i < numberCards - lengthStraightFlush + 1  ; i++)
		{
			found = true;
			
			for (int j = 0 ; j < lengthStraightFlush - 1 ; j++)
			{
				found = found && Figure.contains(board, numberCards, board[i].getValue() - j, board[i].getColor());
			}
			
			if ((lengthStraightFlush == 5 && board[i].getValue() == Game.constants.FIVE)
				||  (lengthStraightFlush == 2 && board[i].getValue() == Game.constants.TWO))
				found = found & Figure.contains(board, numberCards, Game.constants.ACE, board[i].getColor());
			else
				found = found & Figure.contains(board, numberCards, board[i].getValue() - (lengthStraightFlush - 1), board[i].getColor());
				
			
			if (found)
				return i;
		}
		return -1;
	}
	
	private static boolean contains(Card []board, int numberCards, int value)
	{
		for (int i = 0 ; i < numberCards ; i++)
		{
			if (board[i].getValue() == value)
				return true;
		}
		return false;
	}
	
	private static boolean contains(Card []board, int numberCards, int value, int color)
	{
		for (int i = 0 ; i < numberCards ; i++)
		{
			if (board[i].getValue() == value && board[i].getColor() == color)
				return true;
		}
		return false;
	}
	
	// TOSTRING
	
	public String toString() 
	{
		String ret = "";
		
		switch(this.type)
		{
		case constants.HIGH_CARD:
			ret += "Carte haute, hauteur " + Card.valueToString(this.values[0]);
			break;
		case constants.PAIR:
			ret += "Paire de " + Card.valueToString(this.values[0]);
			break;
		case constants.TWO_PAIRS:
			ret += "Double paire " + Card.valueToString(this.values[0]) + " et " + Card.valueToString(this.values[1]);
			break;
		case constants.THREE_OF_A_KIND:
			ret += "Brelan de " + Card.valueToString(this.values[0]);
			break;
		case constants.STRAIGHT:
			ret += "Suite, hauteur " + Card.valueToString(this.values[0]);
			break;
		case constants.FLUSH:
			ret += "Couleur, hauteur " + Card.valueToString(this.values[0]);
			break;
		case constants.FULL_HOUSE:
			ret += "Full " + Card.valueToString(this.values[0]) + " par " + Card.valueToString(values[1]);
			break;
		case constants.FOUR_OF_A_KIND:
			ret += "Carré de " + Card.valueToString(values[0]);
			break;
		case constants.STRAIGHT_FLUSH:
			ret += "Quinte flush, hauteur " + Card.valueToString(values[0]);
			break;
		default:
			ret += "ERREUR. Type de figure non défini";
			break;
		}
		return ret;
	}
	
	// COMPARE
	
	public boolean isEquivalent(Figure F)
	{
		if (this.type != F.type)
			return false;
		else
		{
			boolean ret = true;
			for (int i = 0 ; i < numberValues ; i++)
			{
				ret = ret && this.values[i] == F.values[i];
			}
			return ret;
		}
	}
	
	public boolean isHigher(Figure F)
	{
		if (this.type > F.type)
			return true;
		else if (this.type == F.type)
		{
			for (int i = 0 ; i < numberValues ; i++)
			{
				if (this.values[i] > F.values[i])
					return true;
				else if (this.values[i] < F.values[i])
					return false;
			}
		}
		return false;
	}
}
