package Game.Table;

import javax.swing.JLabel;

import GUI.InformationGUI;
import Game.Board;
import Game.Card;
import Game.Chairs;
import Game.Deck;
import Game.Player;
import Game.Pot;
import Game.constants;
import Intelligence.InformationRegulateur;

public class Table {

	// DONNEES

	// SITUATION
	protected boolean gameInitialized = false;
	protected int turnNumber = 0;
	protected int turnSituation = constants.UNDEFINED;

	// PLAYERS
	protected Player[] players = null;
	protected Chairs chairs;
	protected Player speaker = null;

	// BLINDS
	protected int smallBlindAmount = constants.STARTING_SMALL_BLIND;
	protected int bigBlindAmount = constants.STARTING_BIG_BLIND;

	// DECK
	protected Deck deck = null;

	// POTS
	protected Pot currentPot = null;
	protected Pot pots[] = null;
	protected int numberPots = 0;

	// BET MAX
	protected int betMax = 0;

	// BOARD
	protected Board board = null;

	// GAME OVER
	protected boolean gameOver = false;

	// CONSTRUCTEUR & DESTRUCTEUR

	public Table(Player[] players, int numberPlayers) {
		// PLAYERS
		this.players = new Player[numberPlayers];

		for (int i = 0; i < numberPlayers; i++) {
			this.players[i] = players[i];
			this.players[i].setPosition(i);
		}
		this.chairs = new Chairs(this.players);
		this.deck = new Deck();

		// POTS
		pots = new Pot[numberPlayers];

		// BOARD
		this.board = new Board();

	}

	// METHODES EXTERNES GUI (OPERATIONS ATOMIQUES)

	public InformationGUI getInformationGUI() {
		synchronized (this) {
			int numberCardsBoard = board.getNumberCards();
			JLabel[] cardsBoardLabels = board.getCardLabels();
			int numberPlayers = chairs.getNumberPlayersInGame();

			int[] positionsPlayers = new int[numberPlayers];
			boolean []isFolded = new boolean[numberPlayers];
			String[] namesPlayers = new String[numberPlayers];
			int[] stacksPlayers = new int[numberPlayers];
			int[] decisionsPlayers = new int[numberPlayers];
			JLabel[][] handsPlayers = new JLabel[numberPlayers][];
			int[] bets = new int[numberPlayers];

			int positionDealer = chairs.getDealer().getPosition();
			int positionSB = chairs.nextPlayer(chairs.getDealer()).getPosition();
			int positionBB = chairs.nextPlayer(chairs.nextPlayer(chairs.getDealer())).getPosition();

			Player D = chairs.getDealer();
			Player P = D;
			int i = 0;
			do {
				positionsPlayers[i] = P.getPosition();
				isFolded[i] = P.isFolded();
				namesPlayers[i] = new String(P.getName());
				stacksPlayers[i] = P.getStack();
				decisionsPlayers[i] = P.getLastDecision();
				handsPlayers[i] = P.getHandLabels();
				bets[i] = P.getBet();
				i++;
				P = chairs.nextPlayer(P);

			} while (!P.equals(D));

			int numberPots = this.numberPots;
			int[] pots = new int[numberPots];
			for (int j = 0; j < numberPots; j++) {
				pots[j] = this.pots[j].getChips();
			}
			synchronized (this) {
				InformationGUI info = new InformationGUI(numberCardsBoard,
						cardsBoardLabels, numberPlayers, positionsPlayers,
						isFolded, namesPlayers, stacksPlayers, decisionsPlayers,
						handsPlayers, positionDealer, positionSB, positionBB,
						bets, numberPots, pots);
				return info;
			}
		}
	}

	public InformationRegulateur getInformationRegulateur(String playerName) {
		synchronized (this) {
			Player P = null;
			for (int i = 0; i < Game.constants.NUMBER_PLAYERS; i++) {
				if (players[i].getName().equals(playerName))
					P = players[i];
			}

			try {
				if (P == null)
					throw new Exception("Le joueur " + playerName
							+ " n'a pas été trouvé.");
			} catch (Exception e) {
				e.printStackTrace();
			}

			int situation = this.turnSituation;
			boolean isOut = P.isOut();

			Card[] hand = P.getHand();
			int[] handValues = new int[Game.constants.NUMBER_CARDS_HAND];
			int[] handColors = new int[Game.constants.NUMBER_CARDS_HAND];
			for (int i = 0; i < Game.constants.NUMBER_CARDS_HAND; i++) {
				if (hand[i] != null) {
					handValues[i] = hand[i].getValue();
					handColors[i] = hand[i].getColor();
				} else {
					handValues[i] = Game.constants.VALUE_UNDEFINED;
					handColors[i] = Game.constants.VALUE_UNDEFINED;
				}
			}

			int stack = P.getStack();
			int bet = P.getBet();
			int betMax = this.betMax;

			return new InformationRegulateur(situation, isOut, handValues,
					handColors, stack, bet, betMax, bigBlindAmount, );
		}
	}

	// METHODES EXTERNES GAME (OPERATIONS ATOMIQUES)

	public boolean gameOver() {
		synchronized (this) {
			return chairs.getNumberPlayersInGame() == 1;
		}
	}

	public boolean turnOver() {
		synchronized (this) {
			return chairs.getNumberPlayersNotFolded() == 1;
		}
	}

	public boolean bettingTurnOver() {
		synchronized (this) {
			return chairs.getNumberPlayersNotFoldedNotAllin() <= 1
					|| chairs.getNumberPlayersWhoHaventSpoken() == 0;
		}
	}

	public void initializeGame() {
		synchronized (this) {
			Initialization.initializeGame(this);
		}
	}

	public void initializeTurn() {
		synchronized (this) {
			Initialization.initializeTurn(this);
		}

	}

	public void putBlinds() {
		synchronized (this) {
			ChipsManagement.putBlinds(this);
		}

	}

	public void dealHands() {
		synchronized (this) {
			Dealing.dealHands(this);
		}

	}

	public void splitPots() {
		synchronized (this) {
			ChipsManagement.splitPots(this);
		}

	}

	public void resetTurn() {
		synchronized (this) {
			Resetting.resetTurn(this);
		}

	}

	public void resetBettingTurn() {
		synchronized (this) {
			Resetting.resetAfterBettingTurn(this);
		}

	}

	public void askDecision() {
		synchronized (this) {
			DecisionManagement.askDecision(this);
		}
	}

	public void dealFlop() {
		synchronized (this) {
			Dealing.dealFlop(this);
		}
	}

	public void dealTurn() {
		synchronized (this) {
			Dealing.dealTurn(this);
		}
	}

	public void dealRiver() {
		synchronized (this) {
			Dealing.dealRiver(this);
		}
	}

	// METHODES EXTERNES MAIN (OPERATIONS ATOMIQUES)

	public boolean gameInitialized() {
		synchronized (this) {
			return this.gameInitialized;
		}
	}

}
