package Game.Table;

import Game.Player;
import Game.Pot;
import Game.constants;

public abstract class ChipsManagement {

	// DEMANDE A LES BLINDS AUX JOUEURS CONCERNES
	// MET A JOUR LA VALEUR DE BET MAX
	protected static void putBlinds(Table table) {
		if (Main.constants.showInitialization)
			System.out.println("Pose des blinds.");

		int smallBlindAmount = table.smallBlindAmount;
		int bigBlindAmount = table.bigBlindAmount;

		Player D = table.chairs.getDealer();
		Player SB = table.chairs.nextPlayer(D);
		Player BB = table.chairs.nextPlayer(SB);

		int betSmall = Math.min(smallBlindAmount, SB.getStack());
		SB.bet(betSmall);

		int betBig = Math.min(bigBlindAmount, BB.getStack());
		BB.bet(betBig);
		updateBetMax(table);

		table.turnSituation = constants.SITUATION_PREHANDS;

		if (Main.constants.showPutBlinds)
			System.out.println("Dealer : " + D.getName() + ", SB : "
					+ SB.getName() + ", BB : " + BB.getName());

		if (Main.constants.showInitialization)
			System.out.println("Pose des blinds terminée.");
	}

	// MET A JOUR LA VALEUR DE BET MAX
	protected static void updateBetMax(Table table) {
		int betMax = 0;

		Player D = table.chairs.getDealer();
		Player P = D;
		do {
			if (P.getBet() > betMax)
				betMax = P.getBet();
			P = table.chairs.nextPlayer(P);
		} while (!P.equals(D));
		table.betMax = betMax;
	}

	// CREE UN NOUVEAU POT CONTENANT TOUS LES JOUEURS PRESENTS A LA TABLE
	// LE POT COURANT DEVIENT LE NOUVEAU POT
	protected static void createPot(Table table) {
		if (Main.constants.showCreationPot)
			System.out.println("Création d'un pot.");

		Player listPlayers[] = new Player[table.chairs.getNumberPlayersInGame()];

		Player D = table.chairs.getDealer();
		Player P = D;
		int i = 0;
		do {
			listPlayers[i] = P;
			P = table.chairs.nextPlayer(P);
			i++;
		} while (!P.equals(D));

		// A CHANGER LE POT NE DOIT PAS RECEVOIR LE BOARD EN PARAMETRE
		// PLUTOT IL EN RECOIT UNE COPIE LORS DE LA DIStRIBUTION
		Pot newPot = new Pot(listPlayers,
				table.chairs.getNumberPlayersInGame(), table.board);
		table.pots[table.numberPots++] = newPot;
		table.currentPot = newPot;

		if (Main.constants.showCreationPot)
			System.out.println("Création du pot terminée.");
	}

	// APPELLE LA FONCTION POT.SPLIT POUR CHAQUE POT
	protected static void splitPots(Table table) {

		if (Main.constants.showSplittingPots)
			System.out.println("Partage des pots.");

		int numberPots = table.numberPots;

		for (int i = 0; i < numberPots; i++)
			table.pots[i].split();
		
		table.turnSituation = Game.constants.SITUATION_AFTER_SPLITTING_POTS;

		if (Main.constants.showSplittingPots)
			System.out.println("Partage des pots terminé.");
	}

	// PREND LES MISES DE CHAQUE JOUEUR
	// CREE UN NOUVEAU POT POUR CHAQUE JOUEUR ALLIN DONT LA MISE EST INFERIEURE
	// A LA MISE MAX
	// IDEE FAIRE UNE FONCTION RECURSIVE

	// A CHANGER : le cas : if turnOver() ne semble pas necessaire
	protected static void clearBets(Table table) {
		if (Main.constants.showClearBets)
			System.out.println("Mise à jour du pot.");

		while (!allBetsCleared(table)) {
			int betMin = getBetMin(table);

			takeFromBets(table, betMin);

			if (!allBetsCleared(table))
				createPot(table);
		}

		if (Main.constants.showClearBets)
			System.out.println("Mise à jour du pot terminée.");
	}

	// RENVOIE TRUE SI TOUTES LES MISES DES JOUEURS PRESENTS SONT NULLES
	protected static boolean allBetsCleared(Table table) {
		Player D = table.chairs.getDealer();
		Player P = D;
		do {
			if (P.getBet() > 0) {
				return false;
			}
			P = table.chairs.nextPlayer(P);
		} while (!P.equals(D));

		return true;
	}

	// RENVOIE LA VALEUR DE LA MISE MINIMUM DES JOUEURS PRESENTS
	// la mise min est la plus petite mise de tous les joueurs qui ne sont pas
	// couchés
	protected static int getBetMin(Table table) {
		int betMin = Game.constants.INF;
		Player D = table.chairs.getDealer();
		Player P = D;
		do {
			if (!P.isFolded() && P.getBet() > 0) {
				betMin = Math.min(betMin, P.getBet());
			}
			P = table.chairs.nextPlayer(P);
		} while (!P.equals(D));

		return betMin;
	}

	// DEMANDE LA QUANTITE PASSEE EN PARAMETRE A TOUS LES JOUEURS DONT LA MISE
	// EST NON NULLE ET QUI NE SONT PAS COUCHES
	// DEMANDE LA VALEUR MINIMUM ENTRE LA MISE MIN ET LEUR MISE TOTALE
	// A TOUS LES JOUEURS COUCHES
	protected static void takeFromBets(Table table, int amount) {
		Player D = table.chairs.getDealer();
		Player P = D;
		do {
			if (P.getBet() > 0) {
				if (!P.isFolded())
					table.currentPot.addChips(P.takeFromBet(amount));
				else
					table.currentPot.addChips(P.takeFromBet(Math.min(
							P.getBet(), amount)));
			}
			P = table.chairs.nextPlayer(P);
		} while (!P.equals(D));

	}

}
