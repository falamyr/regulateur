package Intelligence.Events;

public interface eventClasses {
	
	public static final int NUMBER_CLASSES = 3;
	
	public static final int UNDEFINED_CLASS = -1;
	public static final int DEAL_HANDS_CLASS = 0;
	public static final int PUT_BLINDS_CLASS = 1;
	public static final int PLAYER_RAISES_CLASS = 2;
	public static final int PERSONAL_DECISION_CLASS = 3;
	
	
	public String []TOSTRING = {
			"DEAL_HANDS",
			"PUT_BLINDS",
			"PLAYER_RAISES",
			"PERSONAL_DECISION"
	};
	

}
