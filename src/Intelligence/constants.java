package Intelligence;

public interface constants {
	
	// METEO
	public static final int NUMBER_CARDS_METEO = 2;
	
	
	// ENVIRONMENT
	public static final int LOW_STACK = 400;
	public static final int LARGE_STACK = 2500;

	// EVENTS
	public static final int SIZE_EVENT_STACK_INITIAL = 10;
	
	// SUCCESS
	public static final int SUCCESS_TRESHOLD = 200;
	public static final int SUCCESS_FOLD_LIMIT = 10;
	
	// EXPERIENCES
	public static final int SIZE_EXPERIENCES_STACK_INITIAL = 25;	
	
	// WEIGHTS
	public static final int INITIAL_WEIGHT = 50;
	public static final int WEIGHTS_LIMIT_UP = 100;
	public static final int WEIGHTS_LIMIT_DOWN = 0;
	public static final int WEIGHTS_OPPONENT_OUT_GAIN = 10;
	public static final int WEIGHTS_SELF_OUT_LOSS = -10;
	public static final int WEIGHTS_BIG_WIN_GAIN = 2;
	public static final int WEIGHTS_SMALL_WIN_GAIN = 1;
	public static final int WEIGHTS_BIG_LOSS_LOSS = -2;
	public static final int WEIGHTS_SMALL_LOSS_LOSS = -2;
	

	
	// DECISIONS
	public static final int NUMBER_DECISIONS_MAX = 3;
}
