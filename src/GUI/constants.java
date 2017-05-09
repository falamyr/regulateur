package GUI;

public interface constants {
	
	// MEASURES
	
	public static final int WIDTH_CARD = 60;
	public static final int HEIGHT_CARD = 88;
	
	public static final int WIDTH_LABEL_MIN= 60;
	public static final int HEIGHT_LABEL_MIN = 20;

	public static final int WIDTH_LABELDECISION_MIN= 60;
	public static final int HEIGHT_LABELDECISION_MIN = 20;
	
	

	public static final int h1Player = 10;
	public static final int h2Player = 0;
	public static final int h3Player = 10;
	public static final int h4Player = 10;
	public static final int h5Player = 10;
	public static final int h6Player = 4;

	public static final int w1Player = 20;
	public static final int w2Player = 4;
	public static final int w3Player = 20;
	public static final int w4Player = 20;
	public static final int w5Player = 30;
	public static final int w6Player = 30;
	
	public static final int WIDTH_PLAYER_PANEL = 2 * WIDTH_CARD + 2*w4Player + w5Player;
	public static final int HEIGHT_PLAYER_PANEL = HEIGHT_LABEL_MIN * 2 + HEIGHT_LABELDECISION_MIN + HEIGHT_CARD + 2*h1Player + h2Player + h3Player;
	
	public static final int h1Panel = 50;
	public static final int h2Panel = 25;
	public static final int h3Panel = 50;

	public static final int w1Panel = 200;
	public static final int w2Panel = 75;
	public static final int w3Panel = 25;
	public static final int w4Panel = 120;
	
	
	public static final int h1Board = 10;
	public static final int w1Board = 20;
	public static final int w2Board = 10;

	
	public static final int WIDTH_BOARD = 5*WIDTH_CARD + 2*w1Board + 4*w2Board;
	public static final int HEIGHT_BOARD = HEIGHT_CARD + 2*h1Board;
	
	
	public static final int WIDTH_FRAME = 4*WIDTH_PLAYER_PANEL + 2*w1Panel + 2*w2Panel + 2*w3Panel + w4Panel;
	public static final int HEIGHT_FRAME = 3*HEIGHT_PLAYER_PANEL + 2*h1Panel + 2*h2Panel + 2*h3Panel;
	
	
	
	// IMAGES PATHS
	public static final String IMAGE_BACKGROUND_PATH = "Images/Background.png";
	public static final String IMAGE_CARDS_PATH = "Images/Cards/";
	public static final String IMAGE_PLAYER_PANEL_PATH = "Images/PlayerPanel";
	public static final String IMAGE_PLAYER_PANEL_PERSO_PATH [] = 
		{
		"Candice",
		"Olaia",
		"Raphael",
		"Hasan",
		"Bence",
		"Pierre",
		};
	public static final String IMAGE_BOARD_PANEL_PATH = "Images/BoardPanel.png";
	public static final String IMAGE_BUTTON_PATH = "Images/";
	public static final String IMAGE_ICONE_PATH = "Images/Icone.png";
	
	// PLAYERS
	public static final int CANDICE = 0;
	public static final int OLAIA = 1;
	public static final int RAPHAEL = 2;
	public static final int HASAN = 3;
	public static final int BENCE = 4;
	public static final int PIERRE = 5;
	
	// PRINT
	public static final boolean printSizes = false;

}
