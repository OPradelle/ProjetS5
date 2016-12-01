package simulation;

import javax.swing.SwingUtilities;
import display.GUIManager;

public class GameLauncher
{

	public static void main(String[] args)
	{
		GUIManager guiManager = new GUIManager();
		
		SwingUtilities.invokeLater(guiManager);
		
		new Application(guiManager).start();
	}
}
