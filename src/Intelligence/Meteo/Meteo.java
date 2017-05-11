package Intelligence.Meteo;

import Game.Card;
import Game.Player;
import Game.Table.Table;
import Intelligence.constants;
import Intelligence.Mechanics.mechanicsClasses;

public class Meteo {

	// DONNEES
	protected int[] cardsColors = null;
	protected int[] cardsValues = null;

	protected int classe = mechanicsClasses.UNDEFINED_CLASS;

	// CONSTRUCTEUR

	public Meteo() {
		this.cardsColors = new int[constants.NUMBER_CARDS_METEO];
		this.cardsValues = new int[constants.NUMBER_CARDS_METEO];
	}

	// ACCESSEURS

	public int getClasse() {
		try {
			if (this.classe == mechanicsClasses.UNDEFINED_CLASS)
				throw new Exception("La classe de la Météo est indéfénie.");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		return this.classe;
	}

	public static int getIndiceFromClass(int meteoClass) {
		return meteoClass;
	}

	public static int getClassFromIndice(int indice) {
		return indice;
	}

	// METHODES

	public void update(int[] handValues, int[] handColors) {
		cardsValues[0] = handValues[0];
		cardsValues[1] = handValues[1];
		cardsColors[0] = handColors[0];
		cardsColors[1] = handColors[1];
		classify();
	}

	// TOSTRING
	public static String toString(int meteoClass) {
		int classCard1 = meteoClass / 52;
		int classCard2 = meteoClass % 52;

		int colorCard1 = classCard1 / 13;
		int valueCard1 = classCard1 % 13;

		int colorCard2 = classCard2 / 13;
		int valueCard2 = classCard2 % 13;

		String ret = "";
		ret += meteoClasses.VALUES_STRINGS[valueCard1]
				+ meteoClasses.COLORS_STRINGS[colorCard1]
				+ meteoClasses.VALUES_STRINGS[valueCard2]
				+ meteoClasses.COLORS_STRINGS[colorCard2];
		return ret;
	}

	public void classify() {

		int classCard1 = cardsValues[0] + 13 * cardsColors[0];
		int classCard2 = cardsValues[1] + 13 * cardsColors[1];
		
		this.classe = classCard2 + 52 * classCard1;
	}
}
