package Game.Table;

import Game.Player;

public abstract class Resetting {

	// REPLACE LES CARTES DANS LE DECK
	// DETRUIT LES POTS
	// RESET LA MISE MAX
	// RESET CHAQUE JOUEUR
	protected static void resetTurn(Table table) {
		if (Main.constants.showReset)
			System.out.println("Mise à jour après le tour.");

		resetCards(table);
		resetPots(table);
		resetBetMax(table);
		resetPlayers(table);
		table.chairs.update();

		table.turnNumber = table.turnNumber + 1;
		table.turnSituation = Game.constants.SITUATION_TURN_OVER;

		if (Main.constants.showReset)
			System.out.println("Mise à jour après le tour terminée.");
	}

	// REMET TOUTES LES CARTES JOUEES DANS LE DECK
	// C'EST A DIRE :
	// LES MAINS
	// LE BOARD
	protected static void resetCards(Table table) {
		if (Main.constants.showReset)
			System.out.println("Rassemblage des cartes.");

		Player D = table.chairs.getDealer();
		Player P = D;
		do {
			P.giveBackHand(table.deck);
			P = table.chairs.nextPlayer(P);
		} while (!P.equals(D));

		table.board.putBackCards(table.deck);
		table.deck.rebuild();

		if (Main.constants.showReset)
			System.out.println("Rassemblage des cartes terminé.");
	}

	// DETRUIT TOUS LES POTS
	protected static void resetPots(Table table) {
		if (Main.constants.showReset)
			System.out.println("Mise à jour des pots.");

		for (int i = 0; i < table.numberPots; i++)
			table.pots[i] = null;
		table.numberPots = 0;

		if (Main.constants.showReset)
			System.out.println("Mise à jour des pots terminée.");
	}

	// REMET LA VARIABLE BETMAX A 0
	protected static void resetBetMax(Table table) {
		table.betMax = 0;
	}

	// APPELLE LA FONCTION PLAYER.CLEAR() POUR CHAQUE JOUEUR
	protected static void resetPlayers(Table table) {
		if (Main.constants.showReset)
			System.out.println("Mise à jour des joueurs.");

		Player D = table.chairs.getDealer();
		Player P = D;
		do {
			P.clear();
			P = table.chairs.nextPlayer(P);
		} while (!P.equals(D));

		if (Main.constants.showReset)
			System.out.println("Mise à jour des joueurs terminée.");
	}

	// RESET LA MISE MAX
	// RESET LA VARIABLE HAS_SPOKEN DE CHAQUE JOUEUR
	// RESET LA VARIABLE LAST_DECISION DE CHAQUE JOUEUR
	protected static void resetAfterBettingTurn(Table table) {
		if (Main.constants.showReset)
			System.out.println("Remise à zéro après le tour de mise.");

		ChipsManagement.clearBets(table);
		resetBetMax(table);
		
		Player D = table.chairs.getDealer();
		Player P = D;
		do {
			P.resetSpoken();
			P.setLastDecision(Game.constants.UNDEFINED);
			P = table.chairs.nextPlayer(P);
		} while (!P.equals(D));

		if (Main.constants.showReset)
			System.out.println("Remise à zéro après le tour de mise terminée.");
	}

	// RESET LA VARIABLE HAS_SPOKEN POUR CHAQUE JOUEUR ENCORE PRESENT
	protected static void resetSpoken(Table table, Player raiser) {

		Player P = table.chairs.nextPlayer(raiser);
		do {
			P.resetSpoken();
			P = table.chairs.nextPlayer(P);
		} while (!P.equals(raiser));

	}

}
