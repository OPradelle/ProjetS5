import javax.swing.JOptionPane;


public class GUIManager implements Runnable
{
	private DisplayMainMenu displayMainMenu;
	private SimulationWindow simulationWindow;
	private DisplayMapGenerator displayMapGenerator;
	
	public GUIManager()
	{
		displayMainMenu = new DisplayMainMenu();
		simulationWindow = new SimulationWindow();
		displayMapGenerator = new DisplayMapGenerator();
	}
	
	public DisplayMainMenu getDisplayMainMenu()
	{
		return displayMainMenu;
	}
	public void setDisplayMainMenu(DisplayMainMenu displayMainMenu)
	{
		this.displayMainMenu = displayMainMenu;
	}
	public SimulationWindow getSimulationWindow()
	{
		return simulationWindow;
	}
	public void setSimulationWindow(SimulationWindow simulationWindow)
	{
		this.simulationWindow = simulationWindow;
	}
	
	@Override
	public void run()
	{
		displayMainMenu.setVisible(true);
	}

	public void showSimulationWindow()
	{
		simulationWindow.setVisible(true);
	}

	public void hideimulationWindow()
	{
		simulationWindow.setVisible(false);
	}
	
	public void showResult(int numberOfRound)
	{
		JOptionPane.showMessageDialog(null, numberOfRound + " tours effectués !", "Résultat des courses", JOptionPane.INFORMATION_MESSAGE);
	}
}
