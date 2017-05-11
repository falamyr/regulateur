package Main;

import Game.Player;
import Game.Table.Table;
import Intelligence.Regulateur;
import Threading.GUIThread;
import Threading.GameThread;
import Threading.RegulateurThread;


public class Run {
	
	public static void main(String args [])
	{
		if (constants.showMain)
			System.out.println("Régulateur.");


		if (constants.showMain)
			System.out.println("Création du régulateur.");
		

		
		if (constants.showMain)
			System.out.println("Création des joueurs.");
		
		Player players[] = new Player[6];

		players[0] = new Player("Bence", false);
		players[1] = new Player("Candice", false);
		players[2] = new Player("Raphaël", false);
		players[3] = new Player("Olaia", false);
		players[4] = new Player("Hasan", false);
		players[5] = new Player("Pierre", false);

		
		boolean learn = true;
		boolean save = true;
		boolean load = false;
		Regulateur []regulateurs = new Regulateur[6];
		for (int i = 0 ; i < 6 ; i++)
		{
			regulateurs[i] = new Regulateur(players[i].getName(), learn, save, load);
			players[i].setRegulateur(regulateurs[i]);
		}
		
		if (constants.showMain)
			System.out.println("Création de la table.");
		
		
		Table table = new Table(players, 6);
		
		RegulateurThread []regThreads = new RegulateurThread[6];
		Thread []tregs = new Thread[6];
		
		for (int i = 0 ; i < 6 ; i++)
		{
			regThreads[i] = new RegulateurThread(table, regulateurs[i]);
			tregs[i] = new Thread((Runnable)regThreads[i]);
		}

		GameThread gameThread = new GameThread(table);		
		Thread tgame = new Thread((Runnable)gameThread);
		
		
		tgame.start();
		for (int i = 0 ; i < 6 ; i++)
			tregs[i].start();
		
		boolean initialized = false;
		while(!initialized)
			{
				try {
					if (Main.constants.wait)
						Thread.sleep(20);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				initialized = table.gameInitialized();
			}

		
		Thread t2 = null;
		if (constants.GUI_on)
		{
			GUIThread guiThread = new GUIThread(table);
			t2 = new Thread((Runnable)guiThread);
			t2.start();
		}
		
		try 
		{
			tgame.join();
			for (int i = 0 ; i < 6 ; i++)
				tregs[i].join();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		if (constants.showMain)
			System.out.println("Fin de la partie.");
		
		
		if (constants.showMain)			
			System.out.println("Fin du programme.");
	
	}

}
