package Intelligence.Decisions;

public interface decisionClasses {
		
	public static final int UNDEFINED_CLASS = -28;
	public static final int CHECK_CLASS = 112;
	public static final int CALL_CLASS = 113;
	public static final int RAISE_CLASS = 115;
	public static final int FOLD_CLASS = 116;
	
	
	public static final int []NUMBER_CLASSES = 
		{
			1,
			2,
			2
		};
	
	public static final int [][]CLASSES = {
		{CALL_CLASS},
		{CHECK_CLASS,RAISE_CLASS},
		{CALL_CLASS, RAISE_CLASS}
	};

}
