package Threading;

import Game.Table.Table;
import Intelligence.Regulateur;

public class RegulateurThread implements Runnable {

	private Table table = null;
	private Regulateur reg = null;

	public RegulateurThread(Table table, Regulateur reg) {
		this.table = table;
		this.reg = reg;
	}

	// THREADING
	public void run() {
		if (Main.constants.showRegulateur)
			System.out.println("Initialisation du Regulateur.");
		
		

		while (!table.gameOver()) {
			if (Main.constants.wait) {
				try {
					Thread.sleep(Main.constants.waitBetweenRegulateurUpdates);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			reg.update(table.getInformationRegulateur(reg.getPlayerName()));

		}

		if (reg.isLearning())
			reg.learn();

		if (reg.saving())
			reg.save();

	}
}
