package Intelligence.Success;

import Intelligence.constants;
import Intelligence.Environment.Environment;

public abstract class Success {

	public static int classify(Environment Eold,
			Environment Enew) {
		
		if (Main.constants.showRegulateur)
			System.out.println("Calcul du succès.");
		
		int distanceOld = Environment.distance(goal, Eold);
		int distanceNew = Environment.distance(goal, Enew);

		int success = distanceOld - distanceNew;
		
		if (Main.constants.showRegulateur)
			System.out.println("Distance goal, Eold = " + distanceOld + "\n"
					+ " distance goal, Enew = " + distanceNew + "\n"
					+ " success = " + success + ".");
		
		if (success == 0)
		{
			if (Main.constants.showRegulateur)
				System.out.println("SUCCES = NEUTRE.");
			return successClasses.NEUTRAL_CLASS;
		}
		else {
			if (success < -constants.SUCCESS_TRESHOLD)
			{
				if (Main.constants.showRegulateur)
					System.out.println("SUCCES = TRES MAUVAIS.");			
				return successClasses.VERY_BAD_CLASS;
			}
			else if (success < 0)
			{
				if (Main.constants.showRegulateur)
					System.out.println("SUCCESS = MAUVAIS.");
				return successClasses.BAD_CLASS;
			}
			else if (success > constants.SUCCESS_TRESHOLD)
			{
				if (Main.constants.showRegulateur)
					System.out.println("SUCCES = TRES BON.");
				return successClasses.VERY_GOOD_CLASS;
			}
			else
			{
				if (Main.constants.showRegulateur)
					System.out.println("SUCCES = BON.");				
				return successClasses.GOOD_CLASS;
			}
		}
		
	}

	public static int updateWeight(int weight, int successClass) {
		try {
			switch (successClass) {
			case successClasses.OPPONENT_OUT_CLASS:
				return Math.min(Intelligence.constants.WEIGHTS_LIMIT_UP, weight + 10);
			case successClasses.SELF_OUT_CLASS:
				return Math.max(Intelligence.constants.WEIGHTS_LIMIT_DOWN, weight - 10);
			case successClasses.BIG_WIN_CLASS:
				return Math.min(Intelligence.constants.WEIGHTS_LIMIT_UP, weight + 2);
			case successClasses.SMALL_WIN_CLASS:
				return Math.min(Intelligence.constants.WEIGHTS_LIMIT_UP, weight + 1);
			case successClasses.BIG_LOSS_CLASS:
				return Math.max(Intelligence.constants.WEIGHTS_LIMIT_DOWN, weight - 2);
			case successClasses.SMALL_LOSS_CLASS:
				return Math.max(Intelligence.constants.WEIGHTS_LIMIT_DOWN, weight - 1);
			case successClasses.ZERO_WIN_CLASS:
				return weight;
			default:
				throw new Exception("La classe du succès est inconnue.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public static String toString(int classSuccess)
	{
		switch (classSuccess) {
		case successClasses.OPPONENT_OUT_CLASS:
			return "SUCCESS_OPPONENT_OUT";
		case successClasses.SELF_OUT_CLASS:
			return "SUCCESS_SELF_OUT";			
		case successClasses.BIG_WIN_CLASS:
			return "SUCCESS_BIG_WIN";			
		case successClasses.SMALL_WIN_CLASS:
			return "SUCCESS_SMALL_WIN";			
		case successClasses.BIG_LOSS_CLASS:
			return "SUCCESS_BIG_LOSS";			
		case successClasses.SMALL_LOSS_CLASS:
			return "SUCCESS_SMALL_LOSS";			
		case successClasses.ZERO_WIN_CLASS:
			return "SUCCESS_ZERO_WIN";			
		default:
			return "SUCCESS_UNDEFINED";
		}
	}

}
