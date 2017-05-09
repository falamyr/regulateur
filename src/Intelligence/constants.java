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
	
	// EXPERIENCES
	public static final int SIZE_EXPERIENCES_STACK_INITIAL = 25;	
	
	// WEIGHTS
	public static final double INITIAL_WEIGHT = 0.5;
	public static final double WEIGHTS_LIMIT_UP = 0.99;
	public static final double WEIGHTS_LIMIT_DOWN = 0.01;
	
	// DECISIONS
	public static final int NUMBER_DECISIONS_MAX = 3;
}
