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
		return meteoClasses.TO_STRING[getIndiceFromClass(meteoClass)];
	
	}
	

	public void classify() {

		int tmpMin = Math.min(cardsValues[0], cardsValues[1]);
		int tmpMax = Math.max(cardsValues[0], cardsValues[1]);
		cardsValues[0] = tmpMax;
		cardsValues[1] = tmpMin;
		boolean suited = cardsColors[0] == cardsColors[1];
		switch (cardsValues[1]) {
		case Game.constants.TWO:
			switch (cardsValues[0]) {
			case Game.constants.TWO:
					this.classe = meteoClasses.TWOTWO_CLASS;
					break;
			case Game.constants.THREE:
				if (suited)
					this.classe = meteoClasses.TWOTHREE_SUITED_CLASS;
				else
					this.classe = meteoClasses.TWOTHREE_UNSUITED_CLASS;
				break;
			case Game.constants.FOUR:
				if (suited)
					this.classe = meteoClasses.TWOFOUR_SUITED_CLASS;
				else
					this.classe = meteoClasses.TWOFOUR_UNSUITED_CLASS;
				break;
			case Game.constants.FIVE:
				if (suited)
					this.classe = meteoClasses.TWOFIVE_SUITED_CLASS;
				else
					this.classe = meteoClasses.TWOFIVE_UNSUITED_CLASS;
				break;
			case Game.constants.SIX:
				if (suited)
					this.classe = meteoClasses.TWOSIX_SUITED_CLASS;
				else
					this.classe = meteoClasses.TWOSIX_UNSUITED_CLASS;
				break;
			case Game.constants.SEVEN:
				if (suited)
					this.classe = meteoClasses.TWOSEVEN_SUITED_CLASS;
				else
					this.classe = meteoClasses.TWOSEVEN_UNSUITED_CLASS;
				break;
			case Game.constants.EIGHT:
				if (suited)
					this.classe = meteoClasses.TWOEIGHT_SUITED_CLASS;
				else
					this.classe = meteoClasses.TWOEIGHT_UNSUITED_CLASS;
				break;
			case Game.constants.NINE:
				if (suited)
					this.classe = meteoClasses.TWONINE_SUITED_CLASS;
				else
					this.classe = meteoClasses.TWONINE_UNSUITED_CLASS;
				break;
			case Game.constants.TEN:
				if (suited)
					this.classe = meteoClasses.TWOTEN_SUITED_CLASS;
				else
					this.classe = meteoClasses.TWOTEN_UNSUITED_CLASS;
				break;
			case Game.constants.JACK:
				if (suited)
					this.classe = meteoClasses.TWOJACK_SUITED_CLASS;
				else
					this.classe = meteoClasses.TWOJACK_UNSUITED_CLASS;
				break;
			case Game.constants.QUEEN:
				if (suited)
					this.classe = meteoClasses.TWOQUEEN_SUITED_CLASS;
				else
					this.classe = meteoClasses.TWOQUEEN_UNSUITED_CLASS;
				break;
			case Game.constants.KING:
				if (suited)
					this.classe = meteoClasses.TWOKING_SUITED_CLASS;
				else
					this.classe = meteoClasses.TWOKING_UNSUITED_CLASS;
				break;
			case Game.constants.ACE:
				if (suited)
					this.classe = meteoClasses.TWOACE_SUITED_CLASS;
				else
					this.classe = meteoClasses.TWOACE_UNSUITED_CLASS;
				break;
			default:
				this.classe = meteoClasses.UNDEFINED_CLASS;
				break;
			}
			break;
		case Game.constants.THREE:
			switch (cardsValues[0]) {
			case Game.constants.THREE:
				this.classe = meteoClasses.THREETHREE_CLASS;
				break;
			case Game.constants.FOUR:
				if (suited)
					this.classe = meteoClasses.THREEFOUR_SUITED_CLASS;
				else
					this.classe = meteoClasses.THREEFOUR_UNSUITED_CLASS;
				break;
			case Game.constants.FIVE:
				if (suited)
					this.classe = meteoClasses.THREEFIVE_SUITED_CLASS;
				else
					this.classe = meteoClasses.THREEFIVE_UNSUITED_CLASS;
				break;
			case Game.constants.SIX:
				if (suited)
					this.classe = meteoClasses.THREESIX_SUITED_CLASS;
				else
					this.classe = meteoClasses.THREESIX_UNSUITED_CLASS;
				break;
			case Game.constants.SEVEN:
				if (suited)
					this.classe = meteoClasses.THREESEVEN_SUITED_CLASS;
				else
					this.classe = meteoClasses.THREESEVEN_UNSUITED_CLASS;
				break;
			case Game.constants.EIGHT:
				if (suited)
					this.classe = meteoClasses.THREEEIGHT_SUITED_CLASS;
				else
					this.classe = meteoClasses.THREEEIGHT_UNSUITED_CLASS;
				break;
			case Game.constants.NINE:
				if (suited)
					this.classe = meteoClasses.THREENINE_SUITED_CLASS;
				else
					this.classe = meteoClasses.THREENINE_UNSUITED_CLASS;
				break;
			case Game.constants.TEN:
				if (suited)
					this.classe = meteoClasses.THREETEN_SUITED_CLASS;
				else
					this.classe = meteoClasses.THREETEN_UNSUITED_CLASS;
				break;
			case Game.constants.JACK:
				if (suited)
					this.classe = meteoClasses.THREEJACK_SUITED_CLASS;
				else
					this.classe = meteoClasses.THREEJACK_UNSUITED_CLASS;
				break;
			case Game.constants.QUEEN:
				if (suited)
					this.classe = meteoClasses.THREEQUEEN_SUITED_CLASS;
				else
					this.classe = meteoClasses.THREEQUEEN_UNSUITED_CLASS;
				break;
			case Game.constants.KING:
				if (suited)
					this.classe = meteoClasses.THREEKING_SUITED_CLASS;
				else
					this.classe = meteoClasses.THREEKING_UNSUITED_CLASS;
				break;
			case Game.constants.ACE:
				if (suited)
					this.classe = meteoClasses.THREEKING_SUITED_CLASS;
				else
					this.classe = meteoClasses.THREEKING_UNSUITED_CLASS;
				break;
			default:
				this.classe = meteoClasses.UNDEFINED_CLASS;
				break;
			}
			break;
		case Game.constants.FOUR:
			switch (cardsValues[0]) {
			case Game.constants.FOUR:
				this.classe = meteoClasses.FOURFOUR_CLASS;
				break;
			case Game.constants.FIVE:
				if (suited)
					this.classe = meteoClasses.FOURFIVE_SUITED_CLASS;
				else
					this.classe = meteoClasses.FOURFIVE_UNSUITED_CLASS;
				break;
			case Game.constants.SIX:
				if (suited)
					this.classe = meteoClasses.FOURSIX_SUITED_CLASS;
				else
					this.classe = meteoClasses.FOURSIX_UNSUITED_CLASS;
				break;
			case Game.constants.SEVEN:
				if (suited)
					this.classe = meteoClasses.FOURSEVEN_SUITED_CLASS;
				else
					this.classe = meteoClasses.FOURSEVEN_UNSUITED_CLASS;
				break;
			case Game.constants.EIGHT:
				if (suited)
					this.classe = meteoClasses.FOUREIGHT_SUITED_CLASS;
				else
					this.classe = meteoClasses.FOUREIGHT_UNSUITED_CLASS;
				break;
			case Game.constants.NINE:
				if (suited)
					this.classe = meteoClasses.FOURNINE_SUITED_CLASS;
				else
					this.classe = meteoClasses.FOURNINE_UNSUITED_CLASS;
				break;
			case Game.constants.TEN:
				if (suited)
					this.classe = meteoClasses.FOURTEN_SUITED_CLASS;
				else
					this.classe = meteoClasses.FOURTEN_UNSUITED_CLASS;
				break;
			case Game.constants.JACK:
				if (suited)
					this.classe = meteoClasses.FOURJACK_SUITED_CLASS;
				else
					this.classe = meteoClasses.FOURJACK_UNSUITED_CLASS;
				break;
			case Game.constants.QUEEN:
				if (suited)
					this.classe = meteoClasses.FOURQUEEN_SUITED_CLASS;
				else
					this.classe = meteoClasses.FOURQUEEN_UNSUITED_CLASS;
				break;
			case Game.constants.KING:
				if (suited)
					this.classe = meteoClasses.FOURKING_SUITED_CLASS;
				else
					this.classe = meteoClasses.FOURKING_UNSUITED_CLASS;
				break;
			case Game.constants.ACE:
				if (suited)
					this.classe = meteoClasses.FOURACE_SUITED_CLASS;
				else
					this.classe = meteoClasses.FOURACE_UNSUITED_CLASS;
				break;
			default:
				this.classe = meteoClasses.UNDEFINED_CLASS;
				break;
			}
			break;
		case Game.constants.FIVE:
			switch (cardsValues[0]) {
			case Game.constants.FIVE:
				this.classe = meteoClasses.FIVEFIVE_CLASS;
				break;
			case Game.constants.SIX:
				if (suited)
					this.classe = meteoClasses.FIVESIX_SUITED_CLASS;
				else
					this.classe = meteoClasses.FIVESIX_UNSUITED_CLASS;
				break;
			case Game.constants.SEVEN:
				if (suited)
					this.classe = meteoClasses.FIVESEVEN_SUITED_CLASS;
				else
					this.classe = meteoClasses.FIVESEVEN_UNSUITED_CLASS;
				break;
			case Game.constants.EIGHT:
				if (suited)
					this.classe = meteoClasses.FIVEEIGHT_SUITED_CLASS;
				else
					this.classe = meteoClasses.FIVEEIGHT_UNSUITED_CLASS;
				break;
			case Game.constants.NINE:
				if (suited)
					this.classe = meteoClasses.FIVENINE_SUITED_CLASS;
				else
					this.classe = meteoClasses.FIVENINE_UNSUITED_CLASS;
				break;
			case Game.constants.TEN:
				if (suited)
					this.classe = meteoClasses.FIVETEN_SUITED_CLASS;
				else
					this.classe = meteoClasses.FIVETEN_UNSUITED_CLASS;
				break;
			case Game.constants.JACK:
				if (suited)
					this.classe = meteoClasses.FIVEJACK_SUITED_CLASS;
				else
					this.classe = meteoClasses.FIVEJACK_UNSUITED_CLASS;
				break;
			case Game.constants.QUEEN:
				if (suited)
					this.classe = meteoClasses.FIVEQUEEN_SUITED_CLASS;
				else
					this.classe = meteoClasses.FIVEQUEEN_UNSUITED_CLASS;
				break;
			case Game.constants.KING:
				if (suited)
					this.classe = meteoClasses.FIVEKING_SUITED_CLASS;
				else
					this.classe = meteoClasses.FIVEKING_UNSUITED_CLASS;
				break;
			case Game.constants.ACE:
				if (suited)
					this.classe = meteoClasses.FIVEACE_SUITED_CLASS;
				else
					this.classe = meteoClasses.FIVEACE_UNSUITED_CLASS;
				break;
			default:
				this.classe = meteoClasses.UNDEFINED_CLASS;
				break;
			}
			break;
		case Game.constants.SIX:
			switch (cardsValues[0]) {
			case Game.constants.SIX:
				this.classe = meteoClasses.SIXSIX_CLASS;
				break;
			case Game.constants.SEVEN:
				if (suited)
					this.classe = meteoClasses.SIXSEVEN_SUITED_CLASS;
				else
					this.classe = meteoClasses.SIXSEVEN_UNSUITED_CLASS;
				break;
			case Game.constants.EIGHT:
				if (suited)
					this.classe = meteoClasses.SIXEIGHT_SUITED_CLASS;
				else
					this.classe = meteoClasses.SIXEIGHT_UNSUITED_CLASS;
				break;
			case Game.constants.NINE:
				if (suited)
					this.classe = meteoClasses.SIXNINE_SUITED_CLASS;
				else
					this.classe = meteoClasses.SIXNINE_UNSUITED_CLASS;
				break;
			case Game.constants.TEN:
				if (suited)
					this.classe = meteoClasses.SIXTEN_SUITED_CLASS;
				else
					this.classe = meteoClasses.SIXTEN_UNSUITED_CLASS;
				break;
			case Game.constants.JACK:
				if (suited)
					this.classe = meteoClasses.SIXJACK_SUITED_CLASS;
				else
					this.classe = meteoClasses.SIXJACK_UNSUITED_CLASS;
				break;
			case Game.constants.QUEEN:
				if (suited)
					this.classe = meteoClasses.SIXQUEEN_SUITED_CLASS;
				else
					this.classe = meteoClasses.SIXQUEEN_UNSUITED_CLASS;
				break;
			case Game.constants.KING:
				if (suited)
					this.classe = meteoClasses.SIXKING_SUITED_CLASS;
				else
					this.classe = meteoClasses.SIXKING_UNSUITED_CLASS;
				break;
			case Game.constants.ACE:
				if (suited)
					this.classe = meteoClasses.SIXACE_SUITED_CLASS;
				else
					this.classe = meteoClasses.SIXACE_UNSUITED_CLASS;
				break;
			default:
				this.classe = meteoClasses.UNDEFINED_CLASS;
				break;
			}
			break;
		case Game.constants.SEVEN:
			switch (cardsValues[0]) {
			case Game.constants.SEVEN:
				this.classe = meteoClasses.SEVENSEVEN_CLASS;
				break;
			case Game.constants.EIGHT:
				if (suited)
					this.classe = meteoClasses.SEVENEIGHT_SUITED_CLASS;
				else
					this.classe = meteoClasses.SEVENEIGHT_UNSUITED_CLASS;
				break;
			case Game.constants.NINE:
				if (suited)
					this.classe = meteoClasses.SEVENNINE_SUITED_CLASS;
				else
					this.classe = meteoClasses.SEVENNINE_UNSUITED_CLASS;
				break;
			case Game.constants.TEN:
				if (suited)
					this.classe = meteoClasses.SEVENTEN_SUITED_CLASS;
				else
					this.classe = meteoClasses.SEVENTEN_UNSUITED_CLASS;
				break;
			case Game.constants.JACK:
				if (suited)
					this.classe = meteoClasses.SEVENJACK_SUITED_CLASS;
				else
					this.classe = meteoClasses.SEVENJACK_UNSUITED_CLASS;
				break;
			case Game.constants.QUEEN:
				if (suited)
					this.classe = meteoClasses.SEVENQUEEN_SUITED_CLASS;
				else
					this.classe = meteoClasses.SEVENQUEEN_UNSUITED_CLASS;
				break;
			case Game.constants.KING:
				if (suited)
					this.classe = meteoClasses.SEVENKING_SUITED_CLASS;
				else
					this.classe = meteoClasses.SEVENKING_UNSUITED_CLASS;
				break;
			case Game.constants.ACE:
				if (suited)
					this.classe = meteoClasses.SEVENACE_SUITED_CLASS;
				else
					this.classe = meteoClasses.SEVENACE_UNSUITED_CLASS;
				break;
			default:
				this.classe = meteoClasses.UNDEFINED_CLASS;
				break;
			}
			break;
		case Game.constants.EIGHT:
			switch (cardsValues[0]) {
			case Game.constants.EIGHT:
				this.classe = meteoClasses.EIGHTEIGHT_CLASS;
				break;
			case Game.constants.NINE:
				if (suited)
					this.classe = meteoClasses.EIGHTNINE_SUITED_CLASS;
				else
					this.classe = meteoClasses.EIGHTNINE_UNSUITED_CLASS;
				break;
			case Game.constants.TEN:
				if (suited)
					this.classe = meteoClasses.EIGHTTEN_SUITED_CLASS;
				else
					this.classe = meteoClasses.EIGHTTEN_UNSUITED_CLASS;
				break;
			case Game.constants.JACK:
				if (suited)
					this.classe = meteoClasses.EIGHTJACK_SUITED_CLASS;
				else
					this.classe = meteoClasses.EIGHTJACK_UNSUITED_CLASS;
				break;
			case Game.constants.QUEEN:
				if (suited)
					this.classe = meteoClasses.EIGHTQUEEN_SUITED_CLASS;
				else
					this.classe = meteoClasses.EIGHTQUEEN_UNSUITED_CLASS;
				break;
			case Game.constants.KING:
				if (suited)
					this.classe = meteoClasses.EIGHTKING_SUITED_CLASS;
				else
					this.classe = meteoClasses.EIGHTKING_UNSUITED_CLASS;
				break;
			case Game.constants.ACE:
				if (suited)
					this.classe = meteoClasses.EIGHTACE_SUITED_CLASS;
				else
					this.classe = meteoClasses.EIGHTACE_UNSUITED_CLASS;
				break;
			default:
				this.classe = meteoClasses.UNDEFINED_CLASS;
				break;
			}
			break;
		case Game.constants.NINE:
			switch (cardsValues[0]) {
			case Game.constants.NINE:
				this.classe = meteoClasses.NINENINE_CLASS;
				break;
			case Game.constants.TEN:
				if (suited)
					this.classe = meteoClasses.NINETEN_SUITED_CLASS;
				else
					this.classe = meteoClasses.NINETEN_UNSUITED_CLASS;
				break;
			case Game.constants.JACK:
				if (suited)
					this.classe = meteoClasses.NINEJACK_SUITED_CLASS;
				else
					this.classe = meteoClasses.NINEJACK_UNSUITED_CLASS;
				break;
			case Game.constants.QUEEN:
				if (suited)
					this.classe = meteoClasses.NINEQUEEN_SUITED_CLASS;
				else
					this.classe = meteoClasses.NINEQUEEN_UNSUITED_CLASS;
				break;
			case Game.constants.KING:
				if (suited)
					this.classe = meteoClasses.NINEKING_SUITED_CLASS;
				else
					this.classe = meteoClasses.NINEKING_UNSUITED_CLASS;
				break;
			case Game.constants.ACE:
				if (suited)
					this.classe = meteoClasses.NINEACE_SUITED_CLASS;
				else
					this.classe = meteoClasses.NINEACE_UNSUITED_CLASS;
				break;
			default:
				this.classe = meteoClasses.UNDEFINED_CLASS;
				break;
			}
			break;
		case Game.constants.TEN:
			switch (cardsValues[0]) {
			case Game.constants.TEN:
				this.classe = meteoClasses.TENTEN_CLASS;
				break;
			case Game.constants.JACK:
				if (suited)
					this.classe = meteoClasses.TENJACK_SUITED_CLASS;
				else
					this.classe = meteoClasses.TENJACK_UNSUITED_CLASS;
				break;
			case Game.constants.QUEEN:
				if (suited)
					this.classe = meteoClasses.TENQUEEN_SUITED_CLASS;
				else
					this.classe = meteoClasses.TENQUEEN_UNSUITED_CLASS;
				break;
			case Game.constants.KING:
				if (suited)
					this.classe = meteoClasses.TENKING_SUITED_CLASS;
				else
					this.classe = meteoClasses.TENKING_UNSUITED_CLASS;
				break;
			case Game.constants.ACE:
				if (suited)
					this.classe = meteoClasses.TENACE_SUITED_CLASS;
				else
					this.classe = meteoClasses.TENACE_UNSUITED_CLASS;
				break;
			default:
				this.classe = meteoClasses.UNDEFINED_CLASS;
				break;
			}
			break;
		case Game.constants.JACK:
			switch (cardsValues[0]) {
			case Game.constants.JACK:
				this.classe = meteoClasses.JACKJACK_CLASS;
				break;
			case Game.constants.QUEEN:
				if (suited)
					this.classe = meteoClasses.JACKQUEEN_SUITED_CLASS;
				else
					this.classe = meteoClasses.JACKQUEEN_UNSUITED_CLASS;
				break;
			case Game.constants.KING:
				if (suited)
					this.classe = meteoClasses.JACKKING_SUITED_CLASS;
				else
					this.classe = meteoClasses.JACKKING_UNSUITED_CLASS;
				break;
			case Game.constants.ACE:
				if (suited)
					this.classe = meteoClasses.JACKACE_SUITED_CLASS;
				else
					this.classe = meteoClasses.JACKACE_UNSUITED_CLASS;
				break;
			default:
				this.classe = meteoClasses.UNDEFINED_CLASS;
				break;
			}
			break;
		case Game.constants.QUEEN:
			switch (cardsValues[0]) {
			case Game.constants.QUEEN:
				this.classe = meteoClasses.QUEENQUEEN_CLASS;
				break;
			case Game.constants.KING:
				if (suited)
					this.classe = meteoClasses.QUEENKING_SUITED_CLASS;
				else
					this.classe = meteoClasses.QUEENKING_UNSUITED_CLASS;
				break;
			case Game.constants.ACE:
				if (suited)
					this.classe = meteoClasses.QUEENACE_SUITED_CLASS;
				else
					this.classe = meteoClasses.QUEENACE_UNSUITED_CLASS;
				break;
			default:
				this.classe = meteoClasses.UNDEFINED_CLASS;
				break;
			}
			break;
		case Game.constants.KING:
			switch (cardsValues[0]) {
			case Game.constants.KING:
				this.classe = meteoClasses.KINGKING_CLASS;
				break;
			case Game.constants.ACE:
				if (suited)
					this.classe = meteoClasses.KINGACE_SUITED_CLASS;
				else
					this.classe = meteoClasses.KINGACE_UNSUITED_CLASS;
				break;
			default:
				this.classe = meteoClasses.UNDEFINED_CLASS;
				break;
			}
			break;
		case Game.constants.ACE:
			switch (cardsValues[0]) {
			case Game.constants.ACE:
				this.classe = meteoClasses.ACEACE_CLASS;
				break;
			default:
				this.classe = meteoClasses.UNDEFINED_CLASS;
				break;
			}
			break;
		default:
			this.classe = meteoClasses.UNDEFINED_CLASS;
			break;
		}
	}

}
