package Intelligence.Decisions;

import Intelligence.Environment.Environment;
import Intelligence.Events.EventSequence;
import Intelligence.Mechanics.Mechanics;
import Intelligence.Mechanics.mechanicsClasses;
import Intelligence.Meteo.Meteo;
import Intelligence.Weights.Weights;

public abstract class Decision {

	// PRIVATE

	private static int findMax(int[] weights, int mechanicsClass) {
		int numberWeights = getNumberClasses(mechanicsClass);

		double[] tmp = new double[numberWeights];
		for (int i = 0; i < numberWeights; i++)
			tmp[i] = weights[i];

		int i = 0;
		for (int j = 0; j < numberWeights; j++) {
			if (tmp[j] > tmp[i])
				i = j;
			else if (tmp[j] == tmp[i]) {
				double rand = Math.random();
				if (rand > 0.5)
					i = j;
			}
		}
		return i;

	}

	private static int getDecision(int indice, int mechanicsClass) {
		switch (mechanicsClass) {
		case mechanicsClasses.UNDER_BET_CLASS:
			if (indice == 0)
				return decisionClasses.CALL_CLASS;
		case mechanicsClasses.EQUALS_BET_CLASS:
			if (indice == 0)
				return decisionClasses.CHECK_CLASS;
			else
				return decisionClasses.RAISE_CLASS;
		case mechanicsClasses.OVER_BET_CLASS:
			if (indice == 0)
				return decisionClasses.CALL_CLASS;
			else
				return decisionClasses.RAISE_CLASS;
		default:
			return -1;
		}
	}

	// METHODES

	public static int decide(int meteoClass, int envClass, int mechsClass,
			int timeClass, int eventsClass, Weights weights) {
		int[] decisionWeights = weights.getDecisionWeights(meteoClass,
				envClass, mechsClass, timeClass, eventsClass);

		int indiceMax = findMax(decisionWeights, mechsClass);

		return getDecision(indiceMax, mechsClass);

	}

	public static int getIndiceFromClass(int decisionClass, int mechanicsClass) {
		switch (mechanicsClass) {
		case mechanicsClasses.UNDER_BET_CLASS:
			switch (decisionClass) {
			case decisionClasses.CALL_CLASS:
				return 0;
			case decisionClasses.FOLD_CLASS:
				return 1;
			default:
				return -1;
			}
		case mechanicsClasses.EQUALS_BET_CLASS:
			switch (decisionClass) {
			case decisionClasses.CHECK_CLASS:
				return 0;
			case decisionClasses.FOLD_CLASS:
				return 1;
			case decisionClasses.RAISE_CLASS:
				return 2;
			default:
				return -1;
			}
		case mechanicsClasses.OVER_BET_CLASS:
			switch (decisionClass) {
			case decisionClasses.CALL_CLASS:
				return 0;
			case decisionClasses.FOLD_CLASS:
				return 1;
			case decisionClasses.RAISE_CLASS:
				return 2;
			default:
				return -1;
			}
		default:
			return -1;
		}
	}

	public static int getClassFromIndice(int indice, int mechanicsClass) {
		switch (mechanicsClass) {
		case mechanicsClasses.UNDER_BET_CLASS:
			switch (indice) {
			case 0:
				return decisionClasses.CALL_CLASS;
			case 1:
				return decisionClasses.FOLD_CLASS;
			default:
				return -1;
			}
		case mechanicsClasses.EQUALS_BET_CLASS:
			switch (indice) {
			case 0:
				return decisionClasses.CHECK_CLASS;
			case 1:
				return decisionClasses.FOLD_CLASS;
			case 2:
				return decisionClasses.RAISE_CLASS;
			default:
				return -1;
			}
		case mechanicsClasses.OVER_BET_CLASS:
			switch (indice) {
			case 0:
				return decisionClasses.CALL_CLASS;
			case 1:
				return decisionClasses.FOLD_CLASS;
			case 2:
				return decisionClasses.RAISE_CLASS;
			default:
				return -1;
			}
		default:
			return -1;
		}
	}

	public static int getNumberClasses(int mechanicsClass) {
		switch (mechanicsClass) {
		case mechanicsClasses.UNDER_BET_CLASS:
			return 2;
		case mechanicsClasses.EQUALS_BET_CLASS:
			return 3;
		case mechanicsClasses.OVER_BET_CLASS:
			return 3;
		case mechanicsClasses.ZERO_STACK_CLASS:
			return 0;
		default:
			return -1;
		}
	}

	// TOSTRING
	public static String toString(int decisionClass, int mechanicsClass) {
		switch (mechanicsClass) {
		case mechanicsClasses.UNDER_BET_CLASS:
			switch (decisionClass) {
			case decisionClasses.CALL_CLASS:
				return "DECISION_CALL";
			case decisionClasses.FOLD_CLASS:
				return "DECISION_FOLD";
			default:
				return "DECISION_UNDEFINED";
			}
		case mechanicsClasses.EQUALS_BET_CLASS:
			switch (decisionClass) {
			case decisionClasses.CHECK_CLASS:
				return "DECISION_CHECK";
			case decisionClasses.FOLD_CLASS:
				return "DECISION_FOLD";
			case decisionClasses.RAISE_CLASS:
				return "DECISION_RAISE";
			default:
				return "DECISION_UNDEFINED";
			}
		case mechanicsClasses.OVER_BET_CLASS:
			switch (decisionClass) {
			case decisionClasses.CALL_CLASS:
				return "DECISION_CALL";
			case decisionClasses.FOLD_CLASS:
				return "DECISION_FOLD";
			case decisionClasses.RAISE_CLASS:
				return "DECISION_RAISE";
			default:
				return "DECISION_UNDEFINED";
			}
		default:
			return "DECISION_UNDEFINED";
		}
	}

}
