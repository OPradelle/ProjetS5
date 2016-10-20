import javax.swing.SwingUtilities;

public class GameLauncher
{

	public static void main(String[] args)
	{
		GUIManager guiManager = new GUIManager();
		
		SwingUtilities.invokeLater(guiManager);
		
		new Application(guiManager).start();
	}
}
