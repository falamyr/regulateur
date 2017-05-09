package Game.Table;

import Game.Player;
import Game.constants;

public abstract class ToString {

	protected static String toString(Table table) {
		String ret = "";
		ret += "--- PLAYERS ---\n";

		Player D = table.chairs.getDealer();
		Player P = D;
		do {
			ret += P.toString() + "\n";
			P = table.chairs.nextPlayer(P);
		} while (!P.equals(D));
		
		if (!Main.constants.tableShowOnlyCards) {
			ret += "\n";

			ret += "--- POTS ---\n";
			for (int i = 0; i < table.numberPots; i++)
				ret += table.pots[i].toString() + "\n";
			ret += "\n";

			ret += "--- CARTES ---\n";
			ret += table.board.toString();

			ret += "\n";
		}
		return ret;
	}

	protected static String decisionToString(int decision, Player P) {
		if (decision > 0)
			decision = constants.RAISE;

		String ret = "";
		ret += P.getName();

		switch (decision) {
		case constants.CHECK:
			ret += " dit parole.";
			break;
		case constants.FOLD:
			ret += " se couche.";
			break;
		case constants.RAISE:
			ret += " relance à " + P.getBet();
			break;
		case constants.CALL:
			ret += " suit à " + P.getBet() + ".";
			if (P.getStack() == 0)
				ret += " " + P.getName() + " est tapis.";
			break;
		}
		return ret;
	}

}
