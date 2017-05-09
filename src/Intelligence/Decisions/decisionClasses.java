package Intelligence.Decisions;

public interface decisionClasses {
		
	public static final int UNDEFINED_CLASS = -28;
	public static final int CHECK_CLASS = 112;
	public static final int CALL_CLASS = 113;
	public static final int FOLD_CLASS = 114;
	public static final int RAISE_CLASS = 115;
	
	
	public static final int []NUMBER_CLASSES = 
		{
			2,
			3,
			3
		};
	
	public static final int [][]CLASSES = {
		{CALL_CLASS, FOLD_CLASS},
		{CHECK_CLASS, FOLD_CLASS, RAISE_CLASS},
		{CALL_CLASS, FOLD_CLASS, RAISE_CLASS}
	};

}
