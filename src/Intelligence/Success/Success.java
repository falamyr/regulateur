package Intelligence.Success;

import Intelligence.constants;
import Intelligence.Environment.Environment;

public abstract class Success {

	public static int classify(Environment goal, Environment Eold,
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

	public static double updateWeight(double weight, int successClass) {
		try {
			switch (successClass) {
			case successClasses.NEUTRAL_CLASS:
				return weight;
			case successClasses.BAD_CLASS:
				return 3 * weight / 4;
			case successClasses.VERY_BAD_CLASS:
				return weight / 2;
			case successClasses.GOOD_CLASS:
				return (1 + weight) / 4;
			case successClasses.VERY_GOOD_CLASS:
				return (1 + weight) / 2;
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
		case successClasses.NEUTRAL_CLASS:
			return "SUCCESS_NEUTRAL";
		case successClasses.BAD_CLASS:
			return "SUCCESS_BAD";
		case successClasses.VERY_BAD_CLASS:
			return "SUCCESS_VERY_BAD";
		case successClasses.GOOD_CLASS:
			return "SUCCESS_GOOD";
		case successClasses.VERY_GOOD_CLASS:
			return "SUCCESS_VERY_GOOD";
		default:
			return "SUCCESS_UNDEFINED";
		}
	}

}
