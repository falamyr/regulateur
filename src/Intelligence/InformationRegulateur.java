package Intelligence;

public class InformationRegulateur {

	
	// DONNEES
	protected int situation = -1;
	protected boolean playerOut = false;

	protected int []handValues = null;
	protected int []handColors = null;
	
	protected int stack = -1;
	protected int bet = -1;
	protected int betMax = -1;
	
	protected int bigBlindAmount = -1;
	
	// CONSTRUCTEUR	
	public InformationRegulateur(int situation, 
			boolean isOut,
			int []handValues,
			int []handColors,
			int stack,
			int bet,
			int betMax,
			int bigBlindAmount)
	{
		this.situation = situation;
		this.playerOut = isOut;
		this.handValues = handValues;
		this.handColors = handColors;
		this.stack = stack;
		this.bet = bet;
		this.betMax = betMax;
		this.bigBlindAmount = bigBlindAmount;
	}
}
