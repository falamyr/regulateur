package Intelligence.Time;

import Intelligence.Mechanics.mechanicsClasses;

public class Time {

	// DONNEES
	private int turnSituation = -1;
	protected int classe = timeClasses.UNDEFINED_CLASS;

	// CONSTRUCTEUR

	public Time() {

	}

	// ACCESSEURS

	public int getClasse() {
		try {
			if (this.classe == mechanicsClasses.UNDEFINED_CLASS)
				throw new Exception("La classe du Temps est indéfénie.");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		return this.classe;
	}

	public static int getIndiceFromClass(int meteoClass) {
		switch (meteoClass) {
		case timeClasses.HANDS_CLASS:
			return 0;
		case timeClasses.FLOP_CLASS:
			return 1;
		case timeClasses.TURN_CLASS:
			return 2;
		case timeClasses.RIVER_CLASS:
			return 3;
		default:
			return -1;
		}
	}

	public static int getClassFromIndice(int indice) {
		switch (indice) {
		case 0:
			return timeClasses.HANDS_CLASS;
		case 1:
			return timeClasses.FLOP_CLASS;
		case 2:
			return timeClasses.TURN_CLASS;
		case 3:
			return timeClasses.RIVER_CLASS;
		default:
			return timeClasses.UNDEFINED_CLASS;
		}
	}

	// METHODES

	public void classify() {
		this.classe = timeClasses.UNDEFINED_CLASS;
		switch (turnSituation) {
		case Game.constants.SITUATION_PREBLINDS:
			break;
		case Game.constants.SITUATION_PREHANDS:
			break;
		case Game.constants.SITUATION_PREFLOP:
			this.classe = timeClasses.HANDS_CLASS;
			break;
		case Game.constants.SITUATION_POSTFLOP:
			this.classe = timeClasses.FLOP_CLASS;
			break;
		case Game.constants.SITUATION_POSTTURN:
			this.classe = timeClasses.TURN_CLASS;
			break;
		case Game.constants.SITUATION_POSTRIVER:
			this.classe = timeClasses.RIVER_CLASS;
			break;
		case Game.constants.SITUATION_BETTING_OVER:
			break;
		case Game.constants.SITUATION_AFTER_SPLITTING_POTS:
			break;
		case Game.constants.SITUATION_TURN_OVER:
			break;
		default:
			break;
		}
	}

	public void update(int turnSituation) {
		this.turnSituation = turnSituation;
		classify();
	}

	// TOSTRING
	public static String toString(int timeClass) {
		switch (timeClass) {
		case timeClasses.HANDS_CLASS:
			return "TIME_HANDS";
		case timeClasses.FLOP_CLASS:
			return "TIME_FLOP";
		case timeClasses.TURN_CLASS:
			return "TIME_TURN";
		case timeClasses.RIVER_CLASS:
			return "TIME_RIVER";
		default:
			return "TIME_UNDEFINED";
		}
	}

}
