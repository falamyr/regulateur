package GUI;

public interface constants {

	// MEASURES

	public static final int BIG_GUI_INDICE = 0;
	public static final int SMALL_GUI_INDICE = 1;

	public static final int[] WIDTH_CARD = { 60, 40 };

	public static final int[] HEIGHT_CARD = { 88, 59 };

	public static final int[] WIDTH_LABEL_MIN = { 60, 40, };

	public static final int[] HEIGHT_LABEL_MIN = { 20, 15 };

	public static final int[] WIDTH_LABELDECISION_MIN = { 60, 40 };

	public static final int[] HEIGHT_LABELDECISION_MIN = { 20, 15 };

	public static final int[] h1Player = { 10, 6 };
	public static final int[] h2Player = { 0, 0 };
	public static final int[] h3Player = { 10, 6 };
	public static final int[] h4Player = { 10, 6 };
	public static final int[] h5Player = { 10, 6 };
	public static final int[] h6Player = { 4, 2 };

	public static final int[] w1Player = { 20, 12 };
	public static final int[] w2Player = { 4, 2 };
	public static final int[] w3Player = { 20, 12 };
	public static final int[] w4Player = { 20, 12 };
	public static final int[] w5Player = { 30, 18 };
	public static final int[] w6Player = { 30, 18 };

	public static final int[] WIDTH_PLAYER_PANEL = {
			2 * WIDTH_CARD[0] + 2 * w4Player[0] + w5Player[0],
			2 * WIDTH_CARD[1] + 2 * w4Player[1] + w5Player[1] };
	public static final int[] HEIGHT_PLAYER_PANEL = {
			HEIGHT_LABEL_MIN[0] * 2 + HEIGHT_LABELDECISION_MIN[0]
					+ HEIGHT_CARD[0] + 2 * h1Player[0] + h2Player[0]
					+ h3Player[0],
			HEIGHT_LABEL_MIN[1] * 2 + HEIGHT_LABELDECISION_MIN[1]
					+ HEIGHT_CARD[1] + 2 * h1Player[1] + h2Player[1]
					+ h3Player[1] };

	public static final int []h1Panel = { 50, 30};
	public static final int []h2Panel = { 25, 20};
	public static final int []h3Panel = { 50, 30};

	public static final int []w1Panel = { 200, 140};
	public static final int []w2Panel = { 75, 50};
	public static final int []w3Panel = { 25, 20};
	public static final int []w4Panel = { 120, 80};

	public static final int []h1Board = { 10, 6};
	public static final int []w1Board = { 20, 14};
	public static final int []w2Board = { 10, 6};

	public static final int[] WIDTH_BOARD = {
			5 * WIDTH_CARD[0] + 2 * w1Board[0] + 4 * w2Board[0],
			5 * WIDTH_CARD[1] + 2 * w1Board[1] + 4 * w2Board[1], };
	public static final int[] HEIGHT_BOARD = { HEIGHT_CARD[0] + 2 * h1Board[0],
			HEIGHT_CARD[1] + 2 * h1Board[1] };

	public static final int[] WIDTH_FRAME = {
			4 * WIDTH_PLAYER_PANEL[0] + 2 * w1Panel[0] + 2 * w2Panel[0] + 2
					* w3Panel[0] + w4Panel[0],
			4 * WIDTH_PLAYER_PANEL[1] + 2 * w1Panel[1] + 2 * w2Panel[1] + 2
					* w3Panel[1] + w4Panel[1] };
	public static final int[] HEIGHT_FRAME = {
			3 * HEIGHT_PLAYER_PANEL[0] + 2 * h1Panel[0] + 2 * h2Panel[0] + 2
					* h3Panel[0],
			3 * HEIGHT_PLAYER_PANEL[1] + 2 * h1Panel[1] + 2 * h2Panel[1] + 2
					* h3Panel[1], };

	// IMAGES PATHS
	public static final String[] IMAGE_BACKGROUND_PATH = {
			"Images/BackgroundBIG.png", "Images/BackgroundSMALL.png", };
	public static final String[] IMAGE_CARDS_PATH = { "Images/Cards/BIG/",
			"Images/Cards/SMALL/", };
	public static final String[] IMAGE_PLAYER_PANEL_PATH = {
			"Images/PlayerPanelBIG", "Images/PlayerPanelSMALL" };
	public static final String[] IMAGE_PLAYER_PANEL_PERSO_PATH = {
			"Candice", "Olaia", "Raphael", "Hasan", "Bence", "Pierre" };
	public static final String[] IMAGE_BOARD_PANEL_PATH = {
			"Images/BoardPanelBIG.png", "Images/BoardPanelSMALL.png", };
	public static final String[] IMAGE_BUTTON_PATH = { "Images/", "Images/", };
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
