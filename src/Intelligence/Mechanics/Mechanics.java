package Intelligence.Mechanics;


public class Mechanics {

	// DONNEES		
	protected int stack = -1;
	protected int bet = -1;
	protected int betMax = -1;
	
	protected int classe = mechanicsClasses.UNDEFINED_CLASS;
	
	protected int numberDecisionsAvailable = 0;
	
		
	// CONSTRUCTEUR
		
	public Mechanics()
	{
		
	}
	
	// ACCESSEURS
	
	public int getClasse()
	{
		try {
			if(this.classe == mechanicsClasses.UNDEFINED_CLASS)
				throw new Exception("La classe de la Mécanique est indéfénie.");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return this.classe;
	}
	
	public int getNumberDecisionsAvailable()
	{
		return this.numberDecisionsAvailable;
	}
	
	public static int getIndiceFromClass(int mechanicsClass)
	{
		switch(mechanicsClass)
		{
		case mechanicsClasses.UNDER_BET_CLASS:
			return 0;
		case mechanicsClasses.EQUALS_BET_CLASS:
			return 1;
		case mechanicsClasses.OVER_BET_CLASS:
			return 2;
		case mechanicsClasses.ZERO_STACK_CLASS:
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
			return mechanicsClasses.UNDER_BET_CLASS;
		case 1:
			return mechanicsClasses.EQUALS_BET_CLASS;
		case 2:
			return mechanicsClasses.OVER_BET_CLASS;
		case 3:
			return mechanicsClasses.ZERO_STACK_CLASS;
		default:
			return mechanicsClasses.UNDEFINED_CLASS;			
		}
	}
		
	// METHODES
		
	public void classify()
	{
		//System.out.println("stack = " + stack + ", bet = " + bet + "betMax = " + betMax);
		if (stack == -1)
			this.classe = mechanicsClasses.UNDEFINED_CLASS;
		else if (stack == 0)
		{
			this.numberDecisionsAvailable = 0;
			this.classe =  mechanicsClasses.UNDEFINED_CLASS;
		}
		else
		{
			if (bet == betMax)
			{
				this.numberDecisionsAvailable = 3;
				this.classe =  mechanicsClasses.EQUALS_BET_CLASS;
			}
			else
			{
				if (bet + stack <= betMax)
				{
					this.numberDecisionsAvailable = 2;
					this.classe =  mechanicsClasses.UNDER_BET_CLASS;
				}
				else
				{
					this.numberDecisionsAvailable = 3;
					this.classe =  mechanicsClasses.OVER_BET_CLASS;
				}
			}
		}
	}
	
	public void update(int stack, int bet, int betMax)
	{
		this.stack = stack;
		this.bet = bet;
		this.betMax = betMax;			
		classify();
	}
	
	// TOSTRING
	public static String toString(int mechsClass)
	{
		switch(mechsClass)
		{
		case mechanicsClasses.UNDER_BET_CLASS:
			return "MECHS_UNDER_BET";
		case mechanicsClasses.EQUALS_BET_CLASS:
			return "MECHS_EQUALS_BET";
		case mechanicsClasses.OVER_BET_CLASS:
			return "MECHS_OVER_BET";
		case mechanicsClasses.ZERO_STACK_CLASS:
			return "MECHS_ZERO_STACK";
		default:
			return "MECHS_UNDEFINED";			
		}
	}
}
