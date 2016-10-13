import javax.swing.SwingUtilities;

public class GameLauncher
{

	public static void main(String[] args)
	{
		GUI gui = new GUI();
		
		SwingUtilities.invokeLater(gui);
		
		new Application(gui).start();
	}
}
