package Game;

import javax.swing.JLabel;

import Intelligence.InformationRegulateur;
import Intelligence.Regulateur;

public class Player {

	// DONNEES

	private String name = null;;

	private int numberCardsHand = 0;
	private Card[] hand = null;

	private int stack = 0;
	private int bet = 0;

	private int position = -1;

	private boolean fold = false;
	private boolean allIn = false;
	private boolean out = false;
	private boolean hasSpoken = false;

	private int lastDecision = constants.UNDEFINED;

	private boolean intelligence = false;
	private Regulateur reg = null;

	// CONSTRUCTEUR & DESTRUCTEUR

	public Player(String name, boolean intelligence) {
		this.name = name;
		this.hand = new Card[constants.NUMBER_CARDS_HAND];
		hand[0] = null;
		hand[1] = null;

		if (intelligence) {
			this.intelligence = true;
		}

	}

	// ACCESSEURS	

	public String getName() {
		return this.name;

	}

	public Card[] getHand() {
		return this.hand;

	}
	
	public void setRegulateur(Regulateur R)
	{
		this.reg = R;
		this.intelligence = true;
	}

	public void setHand(Card c) {
		try {
			if (this.numberCardsHand == constants.NUMBER_CARDS_HAND)
				throw new Exception(
						"Joueur "
								+ name
								+ ", la main est pleine à la distribution d'une carte, numberCardsHand = "
								+ numberCardsHand);
			if (c == null)
				throw new Exception("Joueur " + name
						+ ", reception d'une carte nulle.");
			this.hand[numberCardsHand++] = c;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

	}

	public int getStack() {
		return this.stack;

	}

	public void setStack(int stack) {
		this.stack = stack;

	}

	public boolean isFolded() {
		return fold;
	}

	public boolean isAllIn() {
		return allIn;
	}

	public boolean isOut() {
		return out;
	}

	public boolean hasSpoken() {
		return hasSpoken;
	}
	
	public int getLastDecision() {
		return lastDecision;
	}

	public void setLastDecision(int lastDecision) // à n'appeller qu'à la fin de
													// la mise et non quand il y
													// a une raise
	{
		this.lastDecision = lastDecision;
	}

	public int getPosition() {
		return this.position;

	}

	public void setPosition(int pos) {
		this.position = pos;

	}

	public int getBet() {
		return bet;

	}

	// METHODES

	// CES DEUX FONCTIONS SONT ETRANGES
	// C'EST LE JOUEUR QUI DEVRAIT PLACER SES JETONS SUR LA CHAISE
	// ET NON LA CHAISE QUI DEVRAIT DEMANDER SA MISE AU JOUEUR
	public void bet(int newBet) {
		try {
			if (newBet <= 0)
				throw new Exception(
						"Joueur "
								+ name
								+ ". Le montant de la nouvelle mise est négatif ou nulle ("
								+ newBet + ").");
			if (newBet < bet)
				throw new Exception("Joueur " + name
						+ ". Le montant de la nouvelle mise (" + newBet
						+ ") est inférieur au montant de l'ancienne (" + bet
						+ ").");

			if (newBet > stack+bet)
				throw new Exception("Joueur " + name + ", le tapis (" + stack
						+ ") ajouté à la mise actuelle (" + bet + ") est inférieur à la mise demandée (" + newBet
						+ ").");
			stack -= (newBet-bet);
			if (stack == 0)
				allIn = true;

			this.bet = newBet;
			if (newBet <= 0)
				throw new Exception("Joueur " + name
						+ ". La nouvelle mise est négative ou nulle (" + newBet
						+ ").");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int takeFromBet(int amount) {
		try {
			if (amount > bet)
				throw new Exception("Le montant soutiré à la mise du joueur "
						+ name + " est trop important. Montant : " + amount
						+ ", mise : " + bet);
			else if (amount <= 0)
				throw new Exception("Le montant soutiré à la mise du joueur "
						+ name + " est négtif ou nul (" + amount + ").");
			else {
				bet -= amount;
			}
			return amount;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public void resetSpoken() {
		this.hasSpoken = false;
	}

	public void fold() {
		this.fold = true;
	}

	public Card[] giveBackHand(Deck d) {
		try {
			if (this.numberCardsHand == 0)
				throw new Exception("Joueur " + name
						+ ", main vide quand on lui demande de la rendre.");
			if (this.numberCardsHand == 1)
				throw new Exception(
						"Joueur "
								+ name
								+ ", la main ne contient qu'une carte quand on lui demande de la rendre.");
			Card[] hand = new Card[numberCardsHand];
			for (int i = 0; i < numberCardsHand; i++) {
				d.putBackCard(this.hand[i]);
				this.hand[i] = null;
			}
			this.numberCardsHand = 0;
			return hand;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public void addChips(int amount) {
		try {
			if (amount <= 0)
				throw new Exception("Joueur " + name
						+ ", gagne une quantité de jetons négative ou nulle : "
						+ amount);
			this.bet += amount;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

	public JLabel[] getHandLabels() {
		JLabel[] labels = new JLabel[constants.NUMBER_CARDS_HAND];
		if (this.hand[0] == null)
			labels[0] = null;
		else
			labels[0] = this.hand[0].getLabel();
		if (this.hand[1] == null)
			labels[1] = null;
		else
			labels[1] = this.hand[1].getLabel();
		return labels;

	}

	// CETTE FONCTION VERIFIE ENTRE AUTRES ACTIONS QUE LE TAPIS DU JOUEUR EST
		// NON NUL
		// DANS LE CAS CONTRAIRE, LE JOUEUR EST MIS HORS JEU
		// C'EST LA FONCTION UPDATE_PLAYERS QUI S'OCCUPE DE DETRUIRE LE JOUEUR EN
		// QUESTION
		// IL EST A NOTER QUE LE PARTAGE DES POTS SE FAIT AVANT L'APPELLE A CETTE
		// FONCTION CLEAR()
		public void clear() {
			if (Main.constants.showClear)
				System.out.println("Mise à jour du joueur " + name + ".");

			this.stack += this.bet;
			this.bet = 0;

			if (this.stack == 0) {
				if (Main.constants.showClear_inside)
					System.out.println("Le joueur " + name + " est out.");

				this.out = true;
			} else {
				this.allIn = false;
				this.fold = false;
				this.lastDecision = constants.UNDEFINED;
			}

			if (Main.constants.showClear)
				System.out.println("Mise à jour du joueur " + name + " terminée.");
		}
		
	// DECISION

	public int decide(InformationRegulateur info, int betMax, int bigBlindAmount, int situation) {
		hasSpoken = true;
		if (intelligence) {
			int decision = this.reg.decide(info);
			this.lastDecision = decision;

			if (decision == constants.RAISE)
				decision = Math.max(Math.min(betMax * 2, stack + bet), Math.min(bigBlindAmount, stack + bet));
			return decision;
		} else {
			if (bet < betMax) {
				this.lastDecision = constants.CALL;
				return constants.CALL;
			} else {
				this.lastDecision = constants.CHECK;
				return constants.CHECK;
			}
		}
	}

	// EQUALS

	public boolean equals(Player p) {
		return this.name == p.name;
	}

	// TOSTRING

	public String toString() {
		String ret = name + "\n";
		ret += "stack = " + Integer.toString(stack) + "\n";
		ret += "hand = ";
		if (hand[0] != null)
			ret += hand[0].toString() + ", ";
		if (hand[1] != null)
			ret += hand[1].toString() + "\n";
		if (fold)
			ret += "FOLDED";
		if (allIn)
			ret += "ALLIN";
		if (out)
			ret += "OUT";
		return ret;

	}

}
