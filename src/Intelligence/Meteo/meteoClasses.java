package Intelligence.Meteo;

public interface meteoClasses {
	
	
	public static final int NUMBER_CLASSES = 169;
	
	public static final int UNDEFINED_CLASS = -40;
	public static final int LOW_CLASS = 52;
	public static final int MEDIUM_CLASS = 53;
	public static final int HIGH_CLASS = 54;
	public static final int MIXED_CLASS = 55;
	
	
	public static final int TWOTWO_CLASS = 0;
	public static final int THREETHREE_CLASS = 1;
	public static final int FOURFOUR_CLASS = 2;
	public static final int FIVEFIVE_CLASS = 3;
	public static final int SIXSIX_CLASS = 4;
	public static final int SEVENSEVEN_CLASS = 5;
	public static final int EIGHTEIGHT_CLASS = 6;
	public static final int NINENINE_CLASS = 7;
	public static final int TENTEN_CLASS = 8;
	public static final int JACKJACK_CLASS = 9;
	public static final int QUEENQUEEN_CLASS = 10;
	public static final int KINGKING_CLASS = 11;
	public static final int ACEACE_CLASS = 12;
	
	
	public static final int TWOTHREE_SUITED_CLASS = 13;
	public static final int TWOFOUR_SUITED_CLASS = 14;
	public static final int TWOFIVE_SUITED_CLASS = 15;
	public static final int TWOSIX_SUITED_CLASS = 16;
	public static final int TWOSEVEN_SUITED_CLASS = 17;
	public static final int TWOEIGHT_SUITED_CLASS = 18;
	public static final int TWONINE_SUITED_CLASS = 19;
	public static final int TWOTEN_SUITED_CLASS = 20;
	public static final int TWOJACK_SUITED_CLASS = 21;
	public static final int TWOQUEEN_SUITED_CLASS = 22;
	public static final int TWOKING_SUITED_CLASS = 23;
	public static final int TWOACE_SUITED_CLASS = 24;

	public static final int THREEFOUR_SUITED_CLASS = 25;
	public static final int THREEFIVE_SUITED_CLASS = 26;
	public static final int THREESIX_SUITED_CLASS = 27;
	public static final int THREESEVEN_SUITED_CLASS = 28;
	public static final int THREEEIGHT_SUITED_CLASS = 29;
	public static final int THREENINE_SUITED_CLASS = 30;
	public static final int THREETEN_SUITED_CLASS = 31;
	public static final int THREEJACK_SUITED_CLASS = 32;
	public static final int THREEQUEEN_SUITED_CLASS = 33;
	public static final int THREEKING_SUITED_CLASS = 34;
	public static final int THREEACE_SUITED_CLASS = 35;
	
	public static final int FOURFIVE_SUITED_CLASS = 36;
	public static final int FOURSIX_SUITED_CLASS = 37;
	public static final int FOURSEVEN_SUITED_CLASS = 38;
	public static final int FOUREIGHT_SUITED_CLASS = 39;
	public static final int FOURNINE_SUITED_CLASS = 40;
	public static final int FOURTEN_SUITED_CLASS = 41;
	public static final int FOURJACK_SUITED_CLASS = 42;
	public static final int FOURQUEEN_SUITED_CLASS = 43;
	public static final int FOURKING_SUITED_CLASS = 44;
	public static final int FOURACE_SUITED_CLASS = 45;
	
	public static final int FIVESIX_SUITED_CLASS = 46;
	public static final int FIVESEVEN_SUITED_CLASS = 47;
	public static final int FIVEEIGHT_SUITED_CLASS = 48;
	public static final int FIVENINE_SUITED_CLASS = 49;
	public static final int FIVETEN_SUITED_CLASS = 50;
	public static final int FIVEJACK_SUITED_CLASS = 51;
	public static final int FIVEQUEEN_SUITED_CLASS = 52;
	public static final int FIVEKING_SUITED_CLASS = 53;
	public static final int FIVEACE_SUITED_CLASS = 54;
	
	public static final int SIXSEVEN_SUITED_CLASS = 55;
	public static final int SIXEIGHT_SUITED_CLASS = 56;
	public static final int SIXNINE_SUITED_CLASS = 57;
	public static final int SIXTEN_SUITED_CLASS = 58;
	public static final int SIXJACK_SUITED_CLASS = 59;
	public static final int SIXQUEEN_SUITED_CLASS = 60;
	public static final int SIXKING_SUITED_CLASS = 61;
	public static final int SIXACE_SUITED_CLASS = 62;
	
	public static final int SEVENEIGHT_SUITED_CLASS = 63;
	public static final int SEVENNINE_SUITED_CLASS = 64;
	public static final int SEVENTEN_SUITED_CLASS = 65;
	public static final int SEVENJACK_SUITED_CLASS = 66;
	public static final int SEVENQUEEN_SUITED_CLASS = 67;
	public static final int SEVENKING_SUITED_CLASS = 68;
	public static final int SEVENACE_SUITED_CLASS = 69;
	
	public static final int EIGHTNINE_SUITED_CLASS = 70;
	public static final int EIGHTTEN_SUITED_CLASS = 71;
	public static final int EIGHTJACK_SUITED_CLASS = 72;
	public static final int EIGHTQUEEN_SUITED_CLASS = 73;
	public static final int EIGHTKING_SUITED_CLASS = 74;
	public static final int EIGHTACE_SUITED_CLASS = 75;
	
	public static final int NINETEN_SUITED_CLASS = 76;
	public static final int NINEJACK_SUITED_CLASS = 77;
	public static final int NINEQUEEN_SUITED_CLASS = 78;
	public static final int NINEKING_SUITED_CLASS = 79;
	public static final int NINEACE_SUITED_CLASS = 80;
	
	public static final int TENJACK_SUITED_CLASS = 81;
	public static final int TENQUEEN_SUITED_CLASS = 82;
	public static final int TENKING_SUITED_CLASS = 83;
	public static final int TENACE_SUITED_CLASS = 84;
	
	public static final int JACKQUEEN_SUITED_CLASS = 85;
	public static final int JACKKING_SUITED_CLASS = 86;
	public static final int JACKACE_SUITED_CLASS = 87;
	
	public static final int QUEENKING_SUITED_CLASS = 88;
	public static final int QUEENACE_SUITED_CLASS = 89;
	
	public static final int KINGACE_SUITED_CLASS = 90;

	
	
	
	public static final int TWOTHREE_UNSUITED_CLASS = 91;
	public static final int TWOFOUR_UNSUITED_CLASS = 92;
	public static final int TWOFIVE_UNSUITED_CLASS = 93;
	public static final int TWOSIX_UNSUITED_CLASS = 94;
	public static final int TWOSEVEN_UNSUITED_CLASS = 95;
	public static final int TWOEIGHT_UNSUITED_CLASS = 96;
	public static final int TWONINE_UNSUITED_CLASS = 97;
	public static final int TWOTEN_UNSUITED_CLASS = 98;
	public static final int TWOJACK_UNSUITED_CLASS = 99;
	public static final int TWOQUEEN_UNSUITED_CLASS = 100;
	public static final int TWOKING_UNSUITED_CLASS = 101;
	public static final int TWOACE_UNSUITED_CLASS = 102;

	public static final int THREEFOUR_UNSUITED_CLASS = 103;
	public static final int THREEFIVE_UNSUITED_CLASS = 104;
	public static final int THREESIX_UNSUITED_CLASS = 105;
	public static final int THREESEVEN_UNSUITED_CLASS = 106;
	public static final int THREEEIGHT_UNSUITED_CLASS = 107;
	public static final int THREENINE_UNSUITED_CLASS = 108;
	public static final int THREETEN_UNSUITED_CLASS = 109;
	public static final int THREEJACK_UNSUITED_CLASS = 110;
	public static final int THREEQUEEN_UNSUITED_CLASS = 111;
	public static final int THREEKING_UNSUITED_CLASS = 112;
	public static final int THREEACE_UNSUITED_CLASS = 113;
	
	public static final int FOURFIVE_UNSUITED_CLASS = 114;
	public static final int FOURSIX_UNSUITED_CLASS = 115;
	public static final int FOURSEVEN_UNSUITED_CLASS = 116;
	public static final int FOUREIGHT_UNSUITED_CLASS = 117;
	public static final int FOURNINE_UNSUITED_CLASS = 118;
	public static final int FOURTEN_UNSUITED_CLASS = 119;
	public static final int FOURJACK_UNSUITED_CLASS = 120;
	public static final int FOURQUEEN_UNSUITED_CLASS = 121;
	public static final int FOURKING_UNSUITED_CLASS = 122;
	public static final int FOURACE_UNSUITED_CLASS = 123;
	
	public static final int FIVESIX_UNSUITED_CLASS = 124;
	public static final int FIVESEVEN_UNSUITED_CLASS = 125;
	public static final int FIVEEIGHT_UNSUITED_CLASS = 126;
	public static final int FIVENINE_UNSUITED_CLASS = 127;
	public static final int FIVETEN_UNSUITED_CLASS = 128;
	public static final int FIVEJACK_UNSUITED_CLASS = 129;
	public static final int FIVEQUEEN_UNSUITED_CLASS = 130;
	public static final int FIVEKING_UNSUITED_CLASS = 131;
	public static final int FIVEACE_UNSUITED_CLASS = 132;
	
	public static final int SIXSEVEN_UNSUITED_CLASS = 133;
	public static final int SIXEIGHT_UNSUITED_CLASS = 134;
	public static final int SIXNINE_UNSUITED_CLASS = 135;
	public static final int SIXTEN_UNSUITED_CLASS = 136;
	public static final int SIXJACK_UNSUITED_CLASS = 137;
	public static final int SIXQUEEN_UNSUITED_CLASS = 138;
	public static final int SIXKING_UNSUITED_CLASS = 139;
	public static final int SIXACE_UNSUITED_CLASS = 140;
	
	public static final int SEVENEIGHT_UNSUITED_CLASS = 141;
	public static final int SEVENNINE_UNSUITED_CLASS = 142;
	public static final int SEVENTEN_UNSUITED_CLASS = 143;
	public static final int SEVENJACK_UNSUITED_CLASS = 144;
	public static final int SEVENQUEEN_UNSUITED_CLASS = 145;
	public static final int SEVENKING_UNSUITED_CLASS = 146;
	public static final int SEVENACE_UNSUITED_CLASS = 147;
	
	public static final int EIGHTNINE_UNSUITED_CLASS = 148;
	public static final int EIGHTTEN_UNSUITED_CLASS = 148;
	public static final int EIGHTJACK_UNSUITED_CLASS = 150;
	public static final int EIGHTQUEEN_UNSUITED_CLASS = 151;
	public static final int EIGHTKING_UNSUITED_CLASS = 152;
	public static final int EIGHTACE_UNSUITED_CLASS = 153;
	
	public static final int NINETEN_UNSUITED_CLASS = 154;
	public static final int NINEJACK_UNSUITED_CLASS = 155;
	public static final int NINEQUEEN_UNSUITED_CLASS = 156;
	public static final int NINEKING_UNSUITED_CLASS = 157;
	public static final int NINEACE_UNSUITED_CLASS = 158;
	
	public static final int TENJACK_UNSUITED_CLASS = 159;
	public static final int TENQUEEN_UNSUITED_CLASS = 160;
	public static final int TENKING_UNSUITED_CLASS = 161;
	public static final int TENACE_UNSUITED_CLASS = 162;
	
	public static final int JACKQUEEN_UNSUITED_CLASS = 163;
	public static final int JACKKING_UNSUITED_CLASS = 164;
	public static final int JACKACE_UNSUITED_CLASS = 165;
	
	public static final int QUEENKING_UNSUITED_CLASS = 166;
	public static final int QUEENACE_UNSUITED_CLASS = 167;
	
	public static final int KINGACE_UNSUITED_CLASS = 168;
	
	
	public String []TO_STRING = {
			"METEO_TWOTWO",
			"METEO_THREETHREE",
			"METEO_FOURFOUR",
			"METEO_FIVEFIVE",
			"METEO_SIXSIX",
			"METEO_SEVENSEVEN",
			"METEO_EIGHTEIGHT",
			"METEO_NINENINE",
			"METEO_TENTEN",
			"METEO_JACKJACK",
			"METEO_QUEENQUEEN",
			"METEO_KINGKING",
			"METEO_ACEACE",
			
			
			"TWOTHREE_SUITED",
			"TWOFOUR_SUITED",
			"TWOFIVE_SUITED",
			"TWOSIX_SUITED",
			"TWOSEVEN_SUITED",
			"TWOEIGHT_SUITED",
			"TWONINE_SUITED",
			"TWOTEN_SUITED",
			"TWOJACK_SUITED",
			"TWOQUEEN_SUITED",
			"TWOKING_SUITED",
			"TWOACE_SUITED",

			"THREEFOUR_SUITED",
			"THREEFIVE_SUITED",
			"THREESIX_SUITED",
			"THREESEVEN_SUITED",
			"THREEEIGHT_SUITED",
			"THREENINE_SUITED",
			"THREETEN_SUITED",
			"THREEJACK_SUITED",
			"THREEQUEEN_SUITED",
			"THREEKING_SUITED",
			"THREEACE_SUITED",
			
			"FOURFIVE_SUITED",
			"FOURSIX_SUITED",
			"FOURSEVEN_SUITED",
			"FOUREIGHT_SUITED",
			"FOURNINE_SUITED",
			"FOURTEN_SUITED",
			"FOURJACK_SUITED",
			"FOURQUEEN_SUITED",
			"FOURKING_SUITED",
			"FOURACE_SUITED",
			
			"FIVESIX_SUITED",
			"FIVESEVEN_SUITED",
			"FIVEEIGHT_SUITED",
			"FIVENINE_SUITED",
			"FIVETEN_SUITED",
			"FIVEJACK_SUITED",
			"METEO_FIVEQUEEN_SUITED",
			"METEO_FIVEKING_SUITED",
			"METEO_FIVEACE_SUITED",
			
			"METEO_SIXSEVEN_SUITED",
			"METEO_SIXEIGHT_SUITED",
			"METEO_SIXNINE_SUITED",
			"METEO_SIXTEN_SUITED",
			"METEO_SIXJACK_SUITED",
			"METEO_SIXQUEEN_SUITED",
			"METEO_SIXKING_SUITED",
			"METEO_SIXACE_SUITED",
			
			"METEO_SEVENEIGHT_SUITED",
			"METEO_SEVENNINE_SUITED",
			"METEO_SEVENTEN_SUITED",
			"METEO_SEVENJACK_SUITED",
			"METEO_SEVENQUEEN_SUITED",
			"METEO_SEVENKING_SUITED",
			"METEO_SEVENACE_SUITED",
			
			"METEO_EIGHTNINE_SUITED",
			"METEO_EIGHTTEN_SUITED",
			"METEO_EIGHTJACK_SUITED",
			"METEO_EIGHTQUEEN_SUITED",
			"METEO_EIGHTKING_SUITED",
			"METEO_EIGHTACE_SUITED",
			
			"METEO_NINETEN_SUITED",
			"METEO_NINEJACK_SUITED",
			"METEO_NINEQUEEN_SUITED",
			"METEO_NINEKING_SUITED",
			"METEO_NINEACE_SUITED",
			
			"METEO_TENJACK_SUITED",
			"METEO_TENQUEEN_SUITED",
			"METEO_TENKING_SUITED",
			"METEO_TENACE_SUITED",
			
			"METEO_JACKQUEEN_SUITED",
			"METEO_JACKKING_SUITED",
			"METEO_JACKACE_SUITED",
			
			"METEO_QUEENKING_SUITED",
			"METEO_QUEENACE_SUITED",
			
			"METEO_KINGACE_SUITED",

			
			
			
			"METEO_TWOTHREE_UNSUITED",
			"METEO_TWOFOUR_UNSUITED",
			"METEO_TWOFIVE_UNSUITED",
			"METEO_TWOSIX_UNSUITED",
			"METEO_TWOSEVEN_UNSUITED",
			"METEO_TWOEIGHT_UNSUITED",
			"METEO_TWONINE_UNSUITED",
			"METEO_TWOTEN_UNSUITED",
			"METEO_TWOJACK_UNSUITED",
			"METEO_TWOQUEEN_UNSUITED",
			"METEO_TWOKING_UNSUITED",
			"METEO_TWOACE_UNSUITED",

			"METEO_THREEFOUR_UNSUITED",
			"METEO_THREEFIVE_UNSUITED",
			"METEO_THREESIX_UNSUITED",
			"METEO_THREESEVEN_UNSUITED",
			"METEO_THREEEIGHT_UNSUITED",
			"METEO_THREENINE_UNSUITED",
			"METEO_THREETEN_UNSUITED",
			"METEO_THREEJACK_UNSUITED",
			"METEO_THREEQUEEN_UNSUITED",
			"METEO_THREEKING_UNSUITED",
			"METEO_THREEACE_UNSUITED",
			
			"METEO_FOURFIVE_UNSUITED",
			"METEO_FOURSIX_UNSUITED",
			"METEO_FOURSEVEN_UNSUITED",
			"METEO_FOUREIGHT_UNSUITED",
			"METEO_FOURNINE_UNSUITED",
			"METEO_FOURTEN_UNSUITED",
			"METEO_FOURJACK_UNSUITED",
			"METEO_FOURQUEEN_UNSUITED",
			"METEO_FOURKING_UNSUITED",
			"METEO_FOURACE_UNSUITED",
			
			"METEO_FIVESIX_UNSUITED",
			"METEO_FIVESEVEN_UNSUITED",
			"METEO_FIVEEIGHT_UNSUITED",
			"METEO_FIVENINE_UNSUITED",
			"METEO_FIVETEN_UNSUITED",
			"METEO_FIVEJACK_UNSUITED",
			"METEO_FIVEQUEEN_UNSUITED",
			"METEO_FIVEKING_UNSUITED",
			"METEO_FIVEACE_UNSUITED",
			
			"METEO_SIXSEVEN_UNSUITED",
			"METEO_SIXEIGHT_UNSUITED",
			"METEO_SIXNINE_UNSUITED",
			"METEO_SIXTEN_UNSUITED",
			"METEO_SIXJACK_UNSUITED",
			"METEO_SIXQUEEN_UNSUITED",
			"METEO_SIXKING_UNSUITED",
			"METEO_SIXACE_UNSUITED",
		
			"METEO_SEVENEIGHT_UNSUITED",
			"METEO_SEVENNINE_UNSUITED",
			"METEO_SEVENTEN_UNSUITED",
			"METEO_SEVENJACK_UNSUITED",
			"METEO_SEVENQUEEN_UNSUITED",
			"METEO_SEVENKING_UNSUITED",
			"METEO_SEVENACE_UNSUITED",
			
			"METEO_EIGHTNINE_UNSUITED",
			"METEO_EIGHTTEN_UNSUITED",
			"METEO_EIGHTJACK_UNSUITED",
			"METEO_EIGHTQUEEN_UNSUITED",
			"METEO_EIGHTKING_UNSUITED",
			"METEO_EIGHTACE_UNSUITED",
			
			"METEO_NINETEN_UNSUITED",
			"METEO_NINEJACK_UNSUITED",
			"METEO_NINEQUEEN_UNSUITED",
			"METEO_NINEKING_UNSUITED",
			"METEO_NINEACE_UNSUITED",
			
			"METEO_TENJACK_UNSUITED",
			"METEO_TENQUEEN_UNSUITED",
			"METEO_TENKING_UNSUITED",
			"METEO_TENACE_UNSUITED",
			
			"METEO_JACKQUEEN_UNSUITED",
			"METEO_JACKKING_UNSUITED",
			"METEO_JACKACE_UNSUITED",
			
			"METEO_QUEENKING_UNSUITED",
			"METEO_QUEENACE_UNSUITED",
			
			"METEO_KINGACE_UNSUITED"
	};
	
}
