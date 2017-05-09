package Intelligence;

import Intelligence.Decisions.Decision;
import Intelligence.Decisions.decisionClasses;
import Intelligence.Environment.Environment;
import Intelligence.Events.EventSequence;
import Intelligence.Experience.Experience;
import Intelligence.Mechanics.Mechanics;
import Intelligence.Meteo.Meteo;
import Intelligence.Time.Time;
import Intelligence.Weights.Weights;
import Intelligence.IO.LoaderWeights;
import Intelligence.IO.SaverWeights;

public class Regulateur {

	// DONNEES

	protected String playerName = null;
	protected boolean playerOut = false;

	protected Meteo meteo = null;
	protected Environment env = null;
	protected Mechanics mechs = null;
	protected Time time = null;
	protected EventSequence events = null;
	protected Weights weights = null;


	protected int turn = -1;
	protected int situation = Game.constants.SITUATION_UNDEFINED;

	// EXPERIENCE
	protected boolean learn = false;
	protected int numberExperiencesStart = 0;
	protected int numberExperiencesEnd = 0;
	protected int sizeStack = Intelligence.constants.SIZE_EXPERIENCES_STACK_INITIAL;
	protected Experience[] stackExperiences = null;

	// IO
	protected boolean save = false;
	protected SaverWeights saver = null;
	protected boolean load = false;
	protected LoaderWeights loader = null;

	// CONSTRUCTEUR

	public Regulateur(String playerName, boolean learn, boolean save,
			boolean load) {
		this.playerName = playerName;

		String savePath = "Saves/" + playerName + ".sav";

		meteo = new Meteo();
		env = new Environment();
		mechs = new Mechanics();
		time = new Time();
		events = new EventSequence(meteo, env, mechs);
		weights = new Weights();


		this.learn = learn;
		if (learn)
			this.stackExperiences = new Experience[this.sizeStack];

		this.save = save;
		if (save) {
			saver = new SaverWeights(weights);
			this.saver.setFilePath(savePath);
			this.load = load;
		}
		if (load) {
			loader = new LoaderWeights(weights);
			this.loader.setFilePath(savePath);
			loader.loadWeights();
		}
	}

	// ACCESSEURS

	public boolean playerIsOut() {
		return playerOut;
	}

	public String getPlayerName() {
		return this.playerName;
	}

	public boolean isLearning() {
		return this.learn;
	}

	public boolean saving() {
		return this.save;
	}

	// METHODES

	public int decide(InformationRegulateur info) {
		synchronized (this) {

			this.meteo.update(info.handValues, info.handColors);
			this.env.update(info.stack, info.bigBlindAmount, info.numberPlayers);
			this.mechs.update(info.stack, info.bet, info.betMax);
			this.time.update(info.situation);
			this.events.update(info.situation);

			int decisionClass = Decision.decide(meteo.getClasse(),
					env.getClasse(), mechs.getClasse(), time.getClasse(), events.getClasse(),
					weights);
			this.events.addPersonalDecision(decisionClass);

			if (learn)
				addExperience(new Experience(playerName, meteo, env,  mechs,time,
						events, decisionClass));

			switch (decisionClass) {
			case decisionClasses.CALL_CLASS:
				return Game.constants.CALL;
			case decisionClasses.CHECK_CLASS:
				return Game.constants.CHECK;
			case decisionClasses.FOLD_CLASS:
				return Game.constants.FOLD;
			case decisionClasses.RAISE_CLASS:
				return Game.constants.RAISE;
			default:
				return Game.constants.UNDEFINED;
			}
		}
	}

	public void update(InformationRegulateur info) {
		synchronized (this) {

			// EN FAIT, SEULS LES EVENEMENTS SONT MIS A JOURS
			// SI UN EVEMENT EST DETECTE, LES STRUCTURES SONT MISES A JOUR
			// SI L'EVENEMENT EST DE TYPE DECISIONS_PERSONNELLES, ALORS TOUTES
			// LES
			// CLASSES ACTUELLES SONT SAUVEGARDEES
			// ET REFERENCEES PAR LE NUMERO DE TOUT
			// SI L'EVENEMENT EST DE TYPE FIN_DE_TOUR ALORS SEUL L'ENVIRONNEMENT
			// EST
			// SAUVEGARDE AFIN DE LE COMPARER A CELUI DE DEBUT DE TOUR

			if (Main.constants.showRegulateur) {
				if (info.situation != this.situation) {
					// System.out.println(situationToString(info.situation));
				}
			}
			this.events.update(info.situation);

			// SI LA SITUATION VIENT DE CHANGER A FIN_DE_TOUR ALORS ON MET A
			// JOUR
			// LES EXPERIENCES
			// C'EST A DIRE QU'ON CALCULE LES SUCCESS
			if (learn && this.situation != info.situation
					&& info.situation == Game.constants.SITUATION_TURN_OVER) {
				env.update(info.stack, info.bigBlindAmount, info.numberPlayers);
				updateExperiences();
				events.clear();
			}
			this.situation = info.situation;
			this.playerOut = info.playerOut;

		}
	}

	// EXPERIENCE

	public void updateExperiences() {

		synchronized (this) {
			for (int i = numberExperiencesStart; i < numberExperiencesEnd; i++)
				stackExperiences[i].evaluateSuccess(env);
			numberExperiencesStart = numberExperiencesEnd;

		}

	}

	private void addExperience(Experience E) {

		synchronized (this) {
			if (numberExperiencesEnd == sizeStack)
				resizeStack();
			this.stackExperiences[numberExperiencesEnd++] = E;
		}
	}

	private void resizeStack() {

		synchronized (this) {
			Experience[] stack = new Experience[2 * sizeStack];
			for (int i = 0; i < numberExperiencesEnd; i++)
				stack[i] = this.stackExperiences[i];
			this.stackExperiences = stack;
			this.sizeStack = 2 * sizeStack;
		}
	}

	// LEARNING
	public void learn() {

		if (Main.constants.showRegulateur)
			System.out.println("Learning.");

		if (Main.constants.showRegulateur)
			System.out.println("Nombre d'expériences du joueur " + playerName
					+ " : " + numberExperiencesEnd + ".");
		synchronized (this) {
			weights.update(stackExperiences, numberExperiencesEnd);
		}

		if (Main.constants.showRegulateur)
			System.out.println("Learning terminé.");
	}

	// SAVE
	public void save() {
		if (Main.constants.showRegulateur)
			System.out.println("Sauvegarde des poids.");

		synchronized (this) {
			saver.saveWeights();
			if (Main.constants.saveWeightLabels)
				saver.saveWeightsLabels();
			if (Main.constants.saveExperiencesLabels)
				saver.saveExperiencesLabels(stackExperiences,
						numberExperiencesEnd);
		}

		if (Main.constants.showRegulateur)
			System.out.println("Sauvegarde des poids terminée.");
	}

	// TOSTRING
	private String situationToString(int situation) {
		switch (situation) {

		case Game.constants.SITUATION_UNDEFINED:
			return "SITUATION INDEFINIE";
		case Game.constants.SITUATION_PREBLINDS:
			return "SITUATION AVANT BLINDS";
		case Game.constants.SITUATION_PREHANDS:
			return "SITUATION AVANT MAINS";
		case Game.constants.SITUATION_PREFLOP:
			return "SITUATION AVANT FLOP";
		case Game.constants.SITUATION_POSTFLOP:
			return "SITUATION APRES FLOP";
		case Game.constants.SITUATION_POSTTURN:
			return "SITUATION APRES TURN";
		case Game.constants.SITUATION_POSTRIVER:
			return "SITUATION APRES RIVER";
		case Game.constants.SITUATION_BETTING_OVER:
			return "SITUATION TOUR DE MISE TERMINE";
		case Game.constants.SITUATION_AFTER_SPLITTING_POTS:
			return "SITUATION DISTRIBUTION POTS TERMINEE";
		case Game.constants.SITUATION_TURN_OVER:
			return "SITUATION TOUR TERMINE";
		default:
			return null;
		}
	}

}
