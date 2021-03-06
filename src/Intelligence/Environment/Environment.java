package Intelligence.Environment;

import Game.Player;
import Intelligence.constants;
import Intelligence.Mechanics.mechanicsClasses;

public class Environment {
	
	
	// DONNEES	
	protected int stack = -1;
	
	protected int bigBlindAmount = -1;
	protected int numberPlayers = -1;
	
	protected int classe = environmentClasses.UNDEFINED_CLASS;
	
	// CONSTRUCTEUR
	
	public Environment()
	{
	}
	
	// ACCESSEURS
		
	public int getClasse()
	{
		try {
			if(this.classe == mechanicsClasses.UNDEFINED_CLASS)
				throw new Exception("La classe de l'Environnement est indéfénie.");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return this.classe;
	}
	
	public int getStack()
	{
		return this.stack;
	}
	
	public int getBigBlindAmount()
	{
		return this.bigBlindAmount;
	}
	
	public int getNumberPlayers()
	{
		return this.numberPlayers;
	}
	
	public static int getIndiceFromClass(int environmentClass)
	{
		switch(environmentClass)
		{
		case environmentClasses.LOW_CLASS:
			return 0;
		case environmentClasses.LARGE_CLASS:
			return 1;
		case environmentClasses.MEDIUM_CLASS:
			return 2;
		case environmentClasses.ZERO_CLASS:
			return 3;
		default:
			return -1;			
		}
	}
	
	public static int getClassFromIndice(int indice)
	{
		switch(indice)
		{
		case 0:
			return environmentClasses.LOW_CLASS;
		case 1:
			return environmentClasses.LARGE_CLASS;
		case 2:
			return environmentClasses.MEDIUM_CLASS;
		case 3:
			return environmentClasses.ZERO_CLASS;
		default:
			return environmentClasses.UNDEFINED_CLASS;			
		}
	}
	
	// METHODES
	
	public void classify()
	{
		/*if (this.stack == 0)
			this.classe = environmentClasses.ZERO_CLASS;
		else
		{
			if (this.stack < constants.LOW_STACK)
				this.classe = environmentClasses.LOW_CLASS;
			else
				this.classe = environmentClasses.LARGE_CLASS;
		}
		*/
		this.classe = environmentClasses.LOW_CLASS;
	}
	
	public void update(int stack, int bigBlindAmount, int numberPlayers)
	{
		this.stack = stack;
		this.bigBlindAmount = bigBlindAmount;
		this.numberPlayers = numberPlayers;
		classify();
	}
	
	
	// CLONE
	
	public Object clone()
	{
		Environment clone = new Environment();
		clone.stack = this.stack;
		clone.bigBlindAmount = this.bigBlindAmount;
		clone.numberPlayers = this.numberPlayers;
		clone.classe = this.classe;
		return clone;
	}
	
	// TOSTRING
	
	public static String toString(int envClass)
	{
		switch(envClass)
		{
		case environmentClasses.LOW_CLASS:
			return "ENV_LOW";
		case environmentClasses.MEDIUM_CLASS:
			return "ENV_MEDIUM";
		case environmentClasses.LARGE_CLASS:
			return "ENV_LARGE";
		case environmentClasses.ZERO_CLASS:
			return "ENV_ZERO";
		default:
			return "ENV_UNDEFINED";	
		}
	}

}
