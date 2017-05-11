package Intelligence.Experience;

import Intelligence.Decisions.Decision;
import Intelligence.Decisions.decisionClasses;
import Intelligence.Environment.Environment;
import Intelligence.Environment.environmentClasses;
import Intelligence.Events.EventSequence;
import Intelligence.Events.eventSequenceClasses;
import Intelligence.Mechanics.Mechanics;
import Intelligence.Mechanics.mechanicsClasses;
import Intelligence.Meteo.Meteo;
import Intelligence.Meteo.meteoClasses;
import Intelligence.Success.Success;
import Intelligence.Success.successClasses;

public class Experience {
	
	// DONNEES
	
	// SITUATIONS DECISIONNELLES
	
	protected String name = null;
	
	protected int meteoClass = meteoClasses.UNDEFINED_CLASS;
	protected int envClass = environmentClasses.UNDEFINED_CLASS;
	protected int mechsClass = mechanicsClasses.UNDEFINED_CLASS;
	protected int eventsClass = eventSequenceClasses.UNDEFINED_CLASS;
	protected int decisionClass = decisionClasses.UNDEFINED_CLASS;
	
	protected Environment env = null;
	
	// RESULTAT
	
	protected int successClass = successClasses.UNDEFINED_CLASS;
	
	public Experience(String name, Meteo meteo, Environment env, Mechanics mechs, EventSequence events, int decisionClass)
	{
		this.name = name;
		this.meteoClass = meteo.getClasse();
		this.envClass = env.getClasse();
		this.mechsClass = mechs.getClasse();
		this.eventsClass = events.getClasse();
		this.decisionClass = decisionClass;
		
		this.env = (Environment)(env.clone());
		
	}
	
	// ACCESSEURS
	
	public int getMeteoClass()
	{
		return this.meteoClass;
	}
	
	public int getEnvClass()
	{
		return this.envClass;
	}
	
	public int getMechsClass()
	{
		return this.mechsClass;
	}
	
	public int getEventsClass()
	{
		return this.eventsClass;
	}
	
	public int getDecisionClass()
	{
		return this.decisionClass;
	}
	
	public int getSuccessClass()
	{
		return this.successClass;
	}
	
	// METHODES
	
	public void evaluateSuccess(Environment result)
	{
		this.successClass = Success.classify(env, result);
	}
	
	// TOSTRING
	
	public String toString()
	{
			String out = Meteo.toString(meteoClass)
				+ ", "
				+ Environment.toString(envClass)
				+ ", "
				+ Mechanics.toString(mechsClass)
				+ ", "
				+ EventSequence.toString(eventsClass)
				+ ", "
				+ Decision.toString(decisionClass,
						mechsClass)
				+ ", "
				+ Success.toString(successClass);
			return out;
	}

}
