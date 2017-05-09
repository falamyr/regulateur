package Game;

import Figures.Figure;

public class Pot {

	// DONNEES

	private volatile int chips = 0;

	private volatile int numberPlayers = 0;
	private volatile Player[] players = null;

	private volatile Board board = null;

	private volatile Figure[] figures = null;
	private volatile Figure figureMax = null;

	// CONSTRCUTEUR & DESTRUCTEUR

	public Pot(final Player players[], int numberPlayers, Board board) {

		this.players = new Player[constants.NUMBER_PLAYERS];
		for (int i = 0; i < numberPlayers; i++) {
			this.players[i] = players[i];
		}
		this.numberPlayers = numberPlayers;
		this.board = board;

	}

	// ACCESSEURS

	public int getChips() {

		return chips;

	}

	// METHODES

	public void addChips(int chips) {
		this.chips += chips;

	}

	private void removePlayersOut() {
		try {
			int i = 0;
			while (i < numberPlayers) {
				if (players[i] == null)
					throw new Exception("Le joueur d'indice " + i
							+ " est nul à la distribution du pot.");
				if (players[i].isFolded() || players[i].isOut()) {
					for (int j = i; j < numberPlayers - 1; j++)
						players[j] = players[j + 1];
					numberPlayers--;
				} else
					i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void evaluateFigures() {
		if (Main.constants.showEvaluateFigures)
			System.out.println("Evaluation des figures.");

		this.figures = new Figure[numberPlayers];
		for (int i = 0; i < numberPlayers; i++) {
			this.figures[i] = Figure.detect(players[i].getHand(), board);

			if (Main.constants.showEvaluateFigures_inside)
				System.out.println(players[i].getName() + " a "
						+ figures[i].toString());

		}

		if (Main.constants.showEvaluateFigures)
			System.out.println("Evaluation des figures terminée.");
	}

	private void evaluateFigureMax() {
		if (Main.constants.showEvaluateFigures)
			System.out.println("Evaluation de la figure la plus forte.");

		figureMax = figures[0];
		for (int i = 1; i < numberPlayers; i++) {
			if (figures[i].isHigher(figureMax))
				figureMax = figures[i];
		}

		if (Main.constants.showEvaluateFigures_inside)
			System.out.println("La figure la plus forte est "
					+ figureMax.toString());

		if (Main.constants.showEvaluateFigures)
			System.out
					.println("Evaluation de la figure la plus forte terminée.");
	}

	private void removeWeakHands() {
		if (Main.constants.showEvaluateFigures)
			System.out
					.println("Selection des joueurs possédant la figure la plus forte.");

		try {
			int i = 0;
			while (i < numberPlayers) {
				if (players[i] == null)
					throw new Exception("Le joueur d'indice " + i
							+ "est nul à la distribution du pot.");
				if (figureMax.isHigher(figures[i])) {
					for (int j = i; j < numberPlayers - 1; j++) {
						players[j] = players[j + 1];
						figures[j] = figures[j + 1];
					}
					players[numberPlayers - 1] = null;
					figures[numberPlayers - 1] = null;
					numberPlayers--;
				} else
					i++;
			}

			if (Main.constants.showEvaluateFigures_inside)
				System.out
						.println("Le nombre de joueurs possédant la figure la plus forte est de "
								+ numberPlayers + ".");

			if (Main.constants.showEvaluateFigures)
				System.out
						.println("Selection des joueurs possédant la figure la plus forte terminée.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void shareBetweenWinners() {

		if (Main.constants.showEvaluateFigures)
			System.out.println("Distribution des parts.");

		int shareBase = chips / numberPlayers;
		int shares[] = new int[numberPlayers];

		for (int i = 0; i < numberPlayers; i++) {
			shares[i] = shareBase;
			chips -= shareBase;
		}
		int starter = (int) (Math.random() * numberPlayers);
		while (chips > 0) {
			shares[starter]++;
			chips -= 1;
			starter = (starter + 1) % numberPlayers;
		}

		for (int i = 0; i < numberPlayers; i++) {

			if (Main.constants.showEvaluateFigures_inside)
				System.out.println("Le joueur " + players[i].getName()
						+ " gagne " + shares[i] + " jetons.");

			players[i].addChips(shares[i]);
		}

		if (Main.constants.showEvaluateFigures)
			System.out.println("Distribution des parts terminée.");
	}

	public void split() {
		if (Main.constants.showSplittingPots)
			System.out.println("Partage du pot.");

		removePlayersOut();
		if (numberPlayers != 1) {
			evaluateFigures();
			evaluateFigureMax();
			removeWeakHands();
		}
		shareBetweenWinners();

		if (Main.constants.showSplittingPots)
			System.out.println("Partage du pot terminé.");
	}

	// TOSTRING
	public String toString() {
		synchronized (this) {
			String ret = "Pot : " + chips + "\n";
			ret += "Joueurs : ";
			for (int i = 0; i < numberPlayers - 1; i++) {
				ret += players[i].getName() + ", ";
			}
			ret += players[numberPlayers - 1].getName() + ".";
			return ret;
		}

	}
}
