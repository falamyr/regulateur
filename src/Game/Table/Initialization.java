package Game.Table;

import Game.constants;

public abstract class Initialization {

	// MELANGE LE DECK
	// DISTRIBUE LES TAPIS
	// PLACE LES JOUEURS
	protected static void initializeGame(Table table) {
		if (Main.constants.showInitialization)
			System.out.println("Initialisation de la table.");
		
		table.deck.shuffle();

		giveStacks(table);

		table.chairs.placePlayers(table.deck);

		table.turnNumber = 1;
		table.gameInitialized = true;

		if (Main.constants.showInitialization)
			System.out.println("Initialisation de la table terminée.");
	}
	
	// MET A JOUR LES BLINDS
	// TOUS LES 15 TOURS, ELLES AUGMENTENT SELON LE TABLEAU
	private static void updateBlinds(Table table)
	{
		table.smallBlindAmount = Game.constants.SMALL_BLIND_AMOUNTS[Math.min(table.turnNumber/15, Game.constants.LAST_BLIND_AMOUNT)];
		table.bigBlindAmount = Game.constants.BIG_BLIND_AMOUNTS[Math.min(table.turnNumber/15, Game.constants.LAST_BLIND_AMOUNT)];
	}

	// DISTRIBUE LES TAPIS AUX JOUEURS
	protected static void giveStacks(Table table) {
		if (Main.constants.showInitialization)
			System.out.println("Distribution des tapis.");

		for (int i = 0; i < Game.constants.NUMBER_PLAYERS; i++) {
			table.players[i].setStack(constants.STARTING_STACK);
		}

		if (Main.constants.showInitialization)
			System.out.println("Disitribution des tapis terminée.");
	}

	// MELANGE LE DECK
	// CREE UN POT DE DEPART (VIDE)
	protected static void initializeTurn(Table table) {
		if (Main.constants.showInitialization)
			System.out.println("Initialisation du tour.");

		table.deck.shuffle();

		table.speaker = table.chairs.getDealer();
		table.speaker = table.chairs.nextPlayer(table.speaker);
		table.speaker = table.chairs.nextPlayer(table.speaker);
		table.speaker = table.chairs.nextPlayer(table.speaker);

		ChipsManagement.createPot(table);
		
		updateBlinds(table);

		table.turnSituation = constants.SITUATION_PREBLINDS;

		if (Main.constants.showInitialization)
			System.out.println("Initialisation du tour terminée.");

	}

}
