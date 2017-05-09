package Intelligence.Events;

import Intelligence.Decisions.decisionClasses;
import Intelligence.Environment.environmentClasses;
import Intelligence.Mechanics.mechanicsClasses;
import Intelligence.Meteo.meteoClasses;

public class PersonalDecisionEvent extends Event{
	
	// DONNEES
		
	protected int classMeteo = meteoClasses.UNDEFINED_CLASS;
	protected int classEnvironment = environmentClasses.UNDEFINED_CLASS;
	protected int classMechanics = mechanicsClasses.UNDEFINED_CLASS;
	protected int classDecision = decisionClasses.UNDEFINED_CLASS;
	
	public PersonalDecisionEvent(int classe, int classMeteo, int classEnvironment, int classMechanics, int decisionClass)
	{
		super(classe);
		this.classMeteo = classMeteo;
		this.classEnvironment = classEnvironment;
		this.classMechanics = classMechanics;
	}

}
