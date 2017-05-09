package Intelligence.Events;

import Game.Table.Table;
import Intelligence.Environment.Environment;
import Intelligence.Mechanics.Mechanics;
import Intelligence.Meteo.Meteo;

public class EventSequence {
	
	
	// DONNEES
	
	protected int numberEvents = 0;
	protected int sizeStack = Intelligence.constants.SIZE_EVENT_STACK_INITIAL;
	protected Event []stackEvents = null;
	
	protected int classe = eventSequenceClasses.UNDEFINED_CLASS;
	
	protected Meteo meteo = null;
	protected Environment env = null;
	protected Mechanics mechs = null;
	
	protected int situation;
		
	
	
	public EventSequence(Meteo meteo, Environment env, Mechanics mechs)
	{
		this.stackEvents = new Event[sizeStack];		
		
		this.meteo = meteo;
		this.env = env;
		this.mechs = mechs;
	}
	
	// ACCESSEURS
	
	public int getClasse()
	{
		return this.classe;
	}
		
	public static int getIndiceFromClass(int classEventSequence)
	{
		switch(classEventSequence)
		{
		case eventSequenceClasses.RAISE_CLASS:
			return 0;
		case eventSequenceClasses.NO_RAISE_CLASS:
			return 1;
		default:
			return -1;
		}
	}
	
	public static int getClassFromIndice(int indice)
	{
		switch(indice)
		{
		case 0:
			return eventSequenceClasses.RAISE_CLASS;
		case 1:
			return eventSequenceClasses.NO_RAISE_CLASS;
		default:
			return eventSequenceClasses.UNDEFINED_CLASS;
		}
	}
	
	// METHODES
	
	public void clear()
	{
		clearStack();
	}
	
	public void classify()
	{
		boolean raise = false;
		for (int i = 0 ; i < numberEvents ; i++)
		{
			raise = raise || stackEvents[i].getClasse() == eventClasses.PLAYER_RAISES_CLASS;
				
		}
		if (raise)
			this.classe = eventSequenceClasses.RAISE_CLASS;
		else
			this.classe = eventSequenceClasses.NO_RAISE_CLASS;
			
	}
	
	public void update(int newSituation)
	{
				
		switch(newSituation)
		{
		case Game.constants.SITUATION_PREHANDS:
			if (newSituation != situation)
				addEvent(new Event(eventClasses.PUT_BLINDS_CLASS));
			break;
		case Game.constants.SITUATION_PREFLOP:
			if (newSituation != situation)
				addEvent(new Event(eventClasses.DEAL_HANDS_CLASS));
			break;
		case Game.constants.SITUATION_POSTFLOP:
			
			// GESTION DE LA RAISE
			break;
		case Game.constants.SITUATION_TURN_OVER:			
			break;
		default:
			break;
		}
		this.situation = newSituation;
			
	}
	
	public void addPersonalDecision(int decisionClass)
	{
		Event personalDecision = new PersonalDecisionEvent(eventClasses.PERSONAL_DECISION_CLASS, meteo.getClasse(), env.getClasse(), mechs.getClasse(), decisionClass);
		this.addEvent(personalDecision);
	}
	
	// GESTION DE LA PILE
	
	private void addEvent(Event E)
	{
		if (numberEvents == sizeStack)
			resizeStack();
		this.stackEvents[numberEvents++] = E;
		this.classify();
	}
	
	private void resizeStack()
	{
		Event []stack = new Event[2*sizeStack];
		for (int i = 0 ; i < numberEvents ; i++)
			stack[i] = this.stackEvents[i];
		this.stackEvents = stack;
		this.sizeStack = 2*sizeStack;
	}
	
	private void clearStack()
	{
		this.numberEvents = 0;
	}
	
	// TOSTRING
	
	public String toString()
	{
		String ret = "EventSequence\n";
		
		
		for (int i = 0 ; i < numberEvents ; i++)
			ret += stackEvents[i].toString() + "\n";
		
		return ret;
	}
	
	public static String toString(int eventsClass)
	{
		switch(eventsClass)
		{
		case eventSequenceClasses.RAISE_CLASS:
			return "EVENTS_RAISE";
		case eventSequenceClasses.NO_RAISE_CLASS:
			return "EVENTS_NO_RAISE";
		default:
			return "EVENTS_UNDEFINED";
		}
	}

}
