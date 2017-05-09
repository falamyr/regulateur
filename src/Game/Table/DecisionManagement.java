package Game.Table;

import Game.Player;
import Game.constants;

public abstract class DecisionManagement {

	// PROCEDE AU TOUR DE MISE
	// FAIT LE TOUR DES JOUEURS
	// PREND LEUR DECISION
	// VERIFIE QUE LA DECISION EST VALIDE
	// APPLIQUE LA DECISION
	// LE TOUR S'ARRETE QUAND TOUS LES JOUEURS ONT PARLE OU QU'IL NE RESTE QU'UN
	// JOUEUR NON COUCHE ET NON TAPIS
	protected static void askDecision(Table table) {
		int decision = table.speaker.decide(
				table.getInformationRegulateur(table.speaker.getName()),
				table.betMax, table.bigBlindAmount, table.turnSituation);

		checkDecision(table, table.speaker, decision);
		applyDecision(table, table.speaker, decision);

		if (Main.constants.showGetBets_inside)
			System.out.println(ToString.decisionToString(decision,
					table.speaker));

		do {
			table.speaker = table.chairs.nextPlayer(table.speaker);
		} while (table.speaker.isFolded() || table.speaker.isAllIn());

	}

	// VERIFIE QUE LES REGLES SONT RESPECTEES, A SAVOIR
	// UN JOUEUR NE PEUT CHECK SI SA MISE EST INFERIEURE STRICTEMENT A LA MISE
	// MAX
	// UN JOUEUR NE PEUT SUIVRE SI SA MISE EST EGALE A LA MISE MAX
	// UN JOUEUR NE PEUT RELANCER SI SON TAPIS AJOUTE A SA MISE SONT INFERIEURS
	// A LA MISE MAX
	protected static boolean checkDecision(Table table, Player P, int decision) {
		if (decision > 0)
			decision = constants.RAISE;

		try {
			switch (decision) {
			case constants.CHECK:
				if (P.getBet() == table.betMax)
					return true;
				else
					throw new Exception("CHECK. La mise du joueur "
							+ P.getName() + "(" + P.getBet()
							+ ") n'est pas égale à la mise max ("
							+ table.betMax + ")");

			case constants.FOLD:
				return true;
			case constants.RAISE:
				if (P.getStack() + P.getBet() > table.betMax)
					return true;
				else
					throw new Exception(
							"Erreur. RAISE. Le tapis du joueur "
									+ P.getName()
									+ "("
									+ P.getStack()
									+ ") n'est pas suffisant pour relancer la mise max ("
									+ table.betMax + ").");

			case constants.CALL:
				if (P.getStack() == 0)
					throw new Exception("Erreur. CALL. Le tapis du joueur "
							+ P.getName() + " est 0.");
				else if (P.getBet() >= table.betMax)
					throw new Exception("Erreur. CALL. La mise du joueur "
							+ P.getName() + " (" + P.getBet()
							+ ") est supérieure ou égale à la mise max ("
							+ table.betMax + ")");
				else
					return true;
			default:
				throw new Exception("La décision n'a pas été reconnue ("
						+ decision + ").");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// APPLIQUE LA DECISION
	// CHECK : RIEN A FAIRE
	// FOLD : APPELLE LA FONCTION PLAYER.FOLD()
	// CALL : DEMANDE AU JOUEUR LA MISE MAX (OU LE CAS ECHEANT SON TAPIS)
	// RAISE : DEMANDE AU JOUEUR LA VALEUR DE LA RELANCE (A LAQUELLE ON
	// RETRANCHE SA MISE ACTUELLE)
	protected static void applyDecision(Table table, Player P, int decision) {
		int raiseAmount = decision;
		if (raiseAmount > 0)
			decision = constants.RAISE;

		switch (decision) {
		case constants.CHECK:
			break;
		case constants.FOLD:
			P.fold();
			break;
		case constants.RAISE:
			P.bet(raiseAmount);
			ChipsManagement.updateBetMax(table);
			Resetting.resetSpoken(table, P);
			break;
		case constants.CALL:
			P.bet(Math.min(table.betMax, P.getStack() + P.getBet()));
			ChipsManagement.updateBetMax(table);
			break;
		}
	}

}
