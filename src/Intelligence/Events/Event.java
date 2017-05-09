package Intelligence.Events;


public class Event {
	
	// DONNEES
	
	protected int classe = eventClasses.UNDEFINED_CLASS;
	
	
	// CONSTRUCTEUR
	
	public Event(int classe)
	{
		this.classe = classe;
	}
	
	// ACCESSEURS
	
	public int getClasse()
	{
		return this.classe;
	}
	
	public static int getIndiceFromClass(int classEvent)
	{
		switch(classEvent)
		{
		case eventClasses.PUT_BLINDS_CLASS:
			return 0;
		case eventClasses.DEAL_HANDS_CLASS:
			return 1;
		case eventClasses.PLAYER_RAISES_CLASS:
			return 2;
		case eventClasses.PERSONAL_DECISION_CLASS:
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
			return eventClasses.PUT_BLINDS_CLASS;
		case 1:
			return eventClasses.DEAL_HANDS_CLASS;
		case 2:
			return eventClasses.PLAYER_RAISES_CLASS;
		case 3:
			return eventClasses.PERSONAL_DECISION_CLASS;
		default:
			return eventClasses.UNDEFINED_CLASS;
		}
	}
	
	
	// TOSTRING
	
	public String toString()
	{
		return eventClasses.TOSTRING[Event.getIndiceFromClass(this.classe)];
	}

}
