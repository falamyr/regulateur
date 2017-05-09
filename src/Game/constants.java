package Game;

public interface constants {
	
	public static final int NUMBER_CARDS = 52;
	public static final int NUMBER_COLORS = 4;
	public static final int NUMBER_VALUES = 13;

	public static final int NUMBER_CARDS_HAND = 2;
	public static final int NUMBER_CARDS_FLOP = 3;
	public static final int NUMBER_CARDS_TURN = 1;
	public static final int NUMBER_CARDS_RIVER = 1;
	public static final int NUMBER_CARDS_BOARD = NUMBER_CARDS_FLOP + NUMBER_CARDS_TURN + NUMBER_CARDS_RIVER;
	
	public static final int NUMBER_PLAYERS = 6;
	
	public static final int STARTING_STACK = 1500;
	public static final int TOTAL_NUMBER_CHIPS = STARTING_STACK * NUMBER_PLAYERS;
	public static final int INF = TOTAL_NUMBER_CHIPS * 2;
	
	public static final int STARTING_SMALL_BLIND = 50;
	public static final int STARTING_BIG_BLIND = 100;
	
	// BLINDS
	public static final int LAST_BLIND_AMOUNT = 12;
	public static final int []SMALL_BLIND_AMOUNTS = {
		10,
		20,
		30,
		40,
		60,
		100,
		150,
		200,
		300,
		400,
		500,
		750,
		1000
	};
	
	public static final int []BIG_BLIND_AMOUNTS = {
		2*SMALL_BLIND_AMOUNTS[0],
		2*SMALL_BLIND_AMOUNTS[1],
		2*SMALL_BLIND_AMOUNTS[2],
		2*SMALL_BLIND_AMOUNTS[3],
		2*SMALL_BLIND_AMOUNTS[4],
		2*SMALL_BLIND_AMOUNTS[5],
		2*SMALL_BLIND_AMOUNTS[6],
		2*SMALL_BLIND_AMOUNTS[7],
		2*SMALL_BLIND_AMOUNTS[8],
		2*SMALL_BLIND_AMOUNTS[9],
		2*SMALL_BLIND_AMOUNTS[10],
		2*SMALL_BLIND_AMOUNTS[11],
		2*SMALL_BLIND_AMOUNTS[12]
	};
	
	// SITUATIONS
	
	public static final int NUMBER_SITUATIONS = 9;
	public static final int SITUATION_UNDEFINED = -1;	
	public static final int SITUATION_PREBLINDS = 0;
	public static final int SITUATION_PREHANDS = 1;
	public static final int SITUATION_PREFLOP = 2;
	public static final int SITUATION_POSTFLOP = 3;
	public static final int SITUATION_POSTTURN = 4;
	public static final int SITUATION_POSTRIVER = 5;
	public static final int SITUATION_BETTING_OVER = 6;
	public static final int SITUATION_AFTER_SPLITTING_POTS = 7;
	public static final int SITUATION_TURN_OVER = 8;
	
	// DECISIONS

	public static final int UNDEFINED = 0;
	public static final int CHECK = -3;
	public static final int FOLD = -2;
	public static final int CALL = -1;
	public static final int RAISE = 1;
	
	// CARDS VALUES
	
	public static final int VALUE_UNDEFINED = -1;
	public static final int TWO = 0;
	public static final int THREE = 1;
	public static final int FOUR = 2;
	public static final int FIVE = 3;
	public static final int SIX = 4;
	public static final int SEVEN = 5;
	public static final int EIGHT = 6;
	public static final int NINE = 7;
	public static final int TEN = 8;
	public static final int JACK = 9;
	public static final int QUEEN = 10;
	public static final int KING = 11;
	public static final int ACE = 12;
	
	// CARDS COLORS
	
	public static final int HEART = 0;
	public static final int CLOVER = 1;
	public static final int SPADE = 2;
	public static final int DIAMOND = 3;
}
