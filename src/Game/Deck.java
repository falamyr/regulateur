package Game;

public class Deck {

	// DONNEES

	private volatile int mainNumberCards = constants.NUMBER_CARDS;
	private volatile int sideNumberCards = 0;

	private volatile Card[] mainDeck = null;
	private volatile Card[] sideDeck = null;

	// CONSTRCUTEUR & DESTRUCTEUR

	public Deck() {
		this.mainDeck = new Card[constants.NUMBER_CARDS];
		this.sideDeck = new Card[constants.NUMBER_CARDS];
		for (int i = 0; i < constants.NUMBER_COLORS; i++) {
			for (int j = 0; j < constants.NUMBER_VALUES; j++) {
				mainDeck[constants.NUMBER_VALUES * i + j] = new Card(i, j);
				mainDeck[constants.NUMBER_VALUES * i + j].initializeLabel();
				sideDeck[constants.NUMBER_VALUES * i + j] = null;
			}
		}

	}

	// ACCESSEURS

	// METHODES

	public void shuffle() {
		try {
			for (int i = 0; i < mainNumberCards; i++) {
				int j = (int) (Math.random() * (mainNumberCards - i));

				if (mainDeck[i] == null)
					throw new Exception("La carte d'indice " + i
							+ " est nulle lors du mélange du paquet.");
				if (mainDeck[j] == null)
					throw new Exception("La carte d'indice " + j
							+ " est nulle lors du mélange du paquet.");

				Card tmp = mainDeck[constants.NUMBER_CARDS - 1 - i];
				mainDeck[mainNumberCards - 1 - i] = mainDeck[j];
				mainDeck[j] = tmp;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

	}

	public void burn() {
		putBackCard(drawCard());
	}

	public Card drawCard() {
		Card ret = null;

		try {
			if (mainNumberCards == 0)
				throw new Exception("Erreur. Le paquet de carte est vide.");
			ret = mainDeck[0];
			for (int i = 0; i < mainNumberCards - 1; i++)
				mainDeck[i] = mainDeck[i + 1];
			mainDeck[mainNumberCards - 1] = null;
			mainNumberCards--;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		try {
			if (ret == null)
				throw new Exception("Erreur. La carte tirée est nulle.");
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;

	}

	public void putBackCard(Card c) {
		try {
			if (c == null)
				throw new Exception(
						"Erreur. La carte qu'on remet dans le paquet est nulle. Indice = "
								+ this.sideNumberCards);
			if (sideNumberCards == constants.NUMBER_CARDS)
				throw new Exception("Erreur. La défausse est pleine. Carte : "
						+ c.toString());
			sideDeck[sideNumberCards++] = c;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

	}

	public void rebuild() {
		try {
			for (int i = 0; i < sideNumberCards; i++) {
				if (sideDeck[i] == null)
					throw new Exception(
							"La carte d'indice "
									+ i
									+ " est nulle dans la défausse au moment de rassembler les cartes.");
				if (mainNumberCards == constants.NUMBER_CARDS)
					throw new Exception("Erreur. Le deck est plein. Carte : "
							+ sideDeck[i].toString());
				mainDeck[mainNumberCards++] = sideDeck[i];
				sideDeck[i] = null;
			}
			sideNumberCards = 0;
			if (mainNumberCards != constants.NUMBER_CARDS)
				throw new Exception(
						"Erreur. Le jeu n'est pas complet. Il ne contient que "
								+ mainNumberCards + " cartes.");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

	}

	// PRINT

	public String toString() {
		synchronized (this) {
			String ret = "--- DECK ---\n";
			for (int i = 0; i < mainNumberCards; i++)
				ret = ret + mainDeck[i].toString() + "\n";
			return ret;
		}
	}

}
