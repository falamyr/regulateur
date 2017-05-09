package Threading;

import Game.Table.Table;

public class GameThread implements Runnable {

	private Table table = null;

	public GameThread(Table table) {
		this.table = table;
	}

	// THREAD

	public void run() {
		try {
			playGame();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// METHODES

	public void playGame() throws InterruptedException {
		table.initializeGame();

		while (!table.gameOver()) {
			playTurn();
		}

	}

	public void playTurn() throws InterruptedException 
	{
		if (Main.constants.wait)
			Thread.sleep(Main.constants.waitBeforeTurn);


		table.initializeTurn();
		
		if (Main.constants.wait)
			Thread.sleep(Main.constants.waitAfterInitializeTurn);
		
		table.putBlinds();

		
		if (Main.constants.wait)
			Thread.sleep(Main.constants.waitAfterBlinds);
		
		table.dealHands();

		
		if (Main.constants.wait)
			Thread.sleep(Main.constants.waitAfterHands);
		
		
		playBettingTurn();
		if(!table.turnOver())		
		{
			table.dealFlop();
			
			if (Main.constants.wait)
				Thread.sleep(Main.constants.waitAfterFlop);
			
			playBettingTurn();
		}
		if(!table.turnOver())
		{		
			table.dealTurn();
			
			if (Main.constants.wait)
				Thread.sleep(Main.constants.waitAfterTurn);
			
			playBettingTurn();
		}
		if(!table.turnOver())
		{		
			table.dealRiver();
			
			if (Main.constants.wait)
				Thread.sleep(Main.constants.waitAfterRiver);
			
			playBettingTurn();
		}
		
		table.splitPots();
		
		if (Main.constants.wait)
			Thread.sleep(Main.constants.waitAfterPots);
		

		table.resetTurn();
		
		if (Main.constants.wait)
			Thread.sleep(Main.constants.waitAfterResetTurn);

	}

	private void playBettingTurn() throws InterruptedException {
		if (Main.constants.showBettingTurn)
			System.out.println("Tour de mise.");

		if (Main.constants.wait)
			Thread.sleep(Main.constants.waitBeforeBettingTurn);

		while (!table.bettingTurnOver())
		{
			table.askDecision();
			
			if (Main.constants.wait)
				Thread.sleep(Main.constants.waitBetweenBets);
			
		}
		table.resetBettingTurn();

		if (Main.constants.wait)
			Thread.sleep(Main.constants.waitAfterBettingTurn);

		if (Main.constants.showBettingTurn)
			System.out.println("Tour de mise terminé.");
	}

	

}
