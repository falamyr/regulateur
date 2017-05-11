package Main;

public interface constants {
	
	// THREADS
	
	public static final boolean wait = true;
	public static final int slow = 1;
	public static final int fast = 5;
	public static final int very_fast = 20;
	
	public static final int pace = very_fast;

	public static final long waitBeforeTurn = 800/pace;
	public static final long waitAfterInitializeTurn = 200/pace;
	public static final long waitAfterBlinds = 400/pace;
	public static final long waitAfterHands = 800/pace;
	public static final long waitAfterFlop = 600/pace;
	public static final long waitAfterTurn = 600/pace;
	public static final long waitAfterRiver = 600/pace;
	public static final long waitBeforeBettingTurn = 400/pace;
	public static final long waitBetweenBets = 600/pace;
	public static final long waitAfterBettingTurn = 400/pace;
	public static final long waitAfterPots = 500/pace;
	public static final long waitAfterResetTurn = 300/pace;
	
	// GUI
	public static final boolean GUI_on = false;
	public static final boolean GUI_big = false;
	public static final long waitBetweenFrameUpdates = 20;
	
	// REGULATEUR
	public static final long waitBetweenRegulateurUpdates = 20;
	public static final boolean saveWeightLabels = true;
	public static final boolean saveExperiencesLabels = true;
	
	// PRINT	
	public static final boolean showAll = true;
	public static final boolean showNone = false;
	
	public static final boolean tableShowOnlyCards = false;
	
	public static final boolean showMain = (false || showAll) && !showNone;
	public static final boolean showTurnNumber = (true || showAll) && !showNone;
	public static final boolean showInitialization = (true || showAll) && !showNone;
	public static final boolean showReset = (false || showAll) && !showNone;
	public static final boolean showClear = (false || showAll) && !showNone;
	public static final boolean showClear_inside = (false || showAll) && !showNone;
	public static final boolean showPlacePlayers = (false || showAll) && !showNone;
	public static final boolean showCreationPot = (false || showAll) && !showNone;
	public static final boolean showPutBlinds = (false || showAll) && !showNone;
	public static final boolean showBettingTurn = (false || showAll) && !showNone;
	public static final boolean showDealingHands = (true || showAll) && !showNone;
	public static final boolean showDealingHands_inside = (true || showAll) && !showNone;
	public static final boolean showHands = (true || showAll) && !showNone;
	public static final boolean showDealingBoard = (false || showAll) && !showNone;
	public static final boolean showFlop = (true || showAll) && !showNone;
	public static final boolean showTurn = (true || showAll) && !showNone;
	public static final boolean showRiver = (true || showAll) && !showNone;
	public static final boolean showUpdateDealer = (false || showAll) && !showNone;
	public static final boolean showUpdateDealer_inside = (false || showAll) && !showNone;
	public static final boolean showGetBets = (false || showAll) && !showNone;
	public static final boolean showGetBets_inside = (false || showAll) && !showNone;
	public static final boolean showClearBets = (false || showAll) && !showNone;
	public static final boolean showSplittingPots = (true || showAll) && !showNone;
	public static final boolean showEvaluateFigures = (false || showAll) && !showNone;
	public static final boolean showEvaluateFigures_inside = (true || showAll) && !showNone;
	

	public static final boolean showGUI = false;
	public static final boolean showRegulateur = false;
	
	

	

}
