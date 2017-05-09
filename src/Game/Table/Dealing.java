package Game.Table;

import Game.Card;
import Game.Player;
import Game.constants;

public abstract class Dealing {

	// DISTRIBUE LES CARTES A TOUS LES JOUEURS ENCORE PRESENTS
	protected static void dealHands(Table table) {

		for (int i = 0; i < 2; i++) {

			Player D = table.chairs.getDealer();
			Player first = table.chairs.nextPlayer(D);
			Player P = first;
			do {
				Card card = table.deck.drawCard();
				P.setHand(card);

				if (Main.constants.showDealingHands_inside)
					System.out.println(P.getName() + " reçoit "
							+ card.toString());

				P = table.chairs.nextPlayer(P);
			} while (!P.equals(first));
		}
		table.turnSituation = constants.SITUATION_PREFLOP;

		if (Main.constants.showDealingHands)
			System.out.println("Distribution des mains terminée.");
	}

	// DISTRIBUE LE FLOP
	protected static void dealFlop(Table table) {
		if (Main.constants.showDealingBoard)
			System.out.println("Distribution du flop.");

		table.board.addFlop(table.deck);
		table.turnSituation = constants.SITUATION_POSTFLOP;

		if (Main.constants.showFlop)
			System.out.println(table.board.toString());

		if (Main.constants.showDealingBoard)
			System.out.println("Distribution du flop terminée.");
	}

	// DISTRIBUE LA TURN
	protected static void dealTurn(Table table) {
		if (Main.constants.showDealingBoard)
			System.out.println("Distribution de la turn.");

		table.board.addTurn(table.deck);
		table.turnSituation = constants.SITUATION_POSTTURN;

		if (Main.constants.showTurn)
			System.out.println(table.board.toString());

		if (Main.constants.showDealingBoard)
			System.out.println("Distribution de la turn terminée.");
	}

	// DISTRIBUE LA RIVER
	protected static void dealRiver(Table table) {
		if (Main.constants.showDealingBoard)
			System.out.println("Distribution de la river.");

		table.board.addRiver(table.deck);
		table.turnSituation = constants.SITUATION_POSTRIVER;

		if (Main.constants.showRiver)
			System.out.println(table.board.toString());

		if (Main.constants.showDealingBoard)
			System.out.println("Distribution de la river terminée.");
	}

}
