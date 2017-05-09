package Game;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.IO;

public class Card {
	
	// DONNEES
	
	private volatile int color;
	private volatile int value;
	
	private volatile JLabel cardLabel;
	
	// CONSTRCUTEUR & DESTRUCTEUR
	
	public Card(int c, int v)
	{
		synchronized(this)
		{
			this.color = c;
			this.value = v;			
		}
	}
	
	// ACCESSEURS
	
	public int getColor()
	{
		synchronized(this)
		{
			return this.color;
		}
	}
	
	public int getValue()
	{	
		synchronized(this)
		{
			return this.value;
		}
	}

	public JLabel getLabel()
	{
		synchronized(this)
		{
			return cardLabel;
		}
	}
	
	// METHODES
	
	public void initializeLabel()
	{
		this.cardLabel = new JLabel(new ImageIcon(IO.loadImage((GUI.constants.IMAGE_CARDS_PATH + this.toString() + ".png"))));
	}
	
	
	public boolean isEquivalent(Card c)
	{
		synchronized(this)
		{
			return this.value == c.value;
		}
	}
	
	public boolean isHigher(Card c)
	{
		synchronized(this)
		{
			return this.value > c.value;
		}
	}
	
	public boolean isSameColor(Card c)
	{
		synchronized(this)
		{
			return this.color == c.color;
		}
	}
	
	public boolean equals(Card c)
	{
		synchronized(this)
		{
			return this.color == c.color && this.value == c.value;
		}
	}
	
	
	// CLONE
	public Object clone()
	{
		Card clone = new Card(this.color, this.value);
		return clone;
	}
	
	
	// TOSTRING
	
	public String toString()
	{
		synchronized(this)
		{
			String ret = "";		
			
			ret += valueToString(value);
			
			ret += colorToString(color);
			
			return ret;	
		}
	}
	
	public static String colorToString(int color)
	{
		String ret = "";
		
		switch(color)
		{
		case constants.HEART:
			ret += "h";
			break;
		case constants.CLOVER :
			ret += "c";
			break;
		case constants.SPADE :
			ret += "s";
			break;
		case constants.DIAMOND :
			ret += "d";
			break;
		}
		return ret;
	}
	
	public static String valueToString(int value)
	{
		String ret = "";
		
		switch(value)
		{
		case constants.TWO : 
			ret += "2";
			break;
		case constants.THREE:
			ret += "3";
			break;
		case constants.FOUR:
			ret += "4";
			break;
		case constants.FIVE:
			ret += "5";
			break;
		case constants.SIX:
			ret += "6";
			break;
		case constants.SEVEN:
			ret += "7";
			break;
		case constants.EIGHT:
			ret = "8";
			break;
		case constants.NINE:
			ret = "9";
			break;
		case constants.TEN:
			ret = "T";
			break;
		case constants.JACK:
			ret = "J";
			break;
		case constants.QUEEN:
			ret = "Q";
			break;
		case constants.KING:
			ret = "K";
			break;
		case constants.ACE:
			ret = "A";
			break;
		}
		return ret;
	}
}
