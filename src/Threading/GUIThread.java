package Threading;

import GUI.Frame;
import GUI.InformationGUI;
import Game.Table.Table;

public class GUIThread implements Runnable {

	
	
	// DONNEES
	
	private Table table = null;
	
	public GUIThread(Table table)
	{
		this.table = table;
	}
	
	public void run() 
	{
		Frame F = new Frame();
		try {
			if (Main.constants.wait)
				Thread.sleep(Main.constants.waitBetweenFrameUpdates);
			while(!table.gameOver())
			{		
				InformationGUI info = table.getInformationGUI();
				F.update(info);
				F.validate();
				F.repaint();	
				if (Main.constants.wait)
					Thread.sleep(10);							
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		F.setVisible(false);
		F.dispose();
	}
	
}
