package display;

import javax.swing.JOptionPane;

import simulation.SimulationWindow;


public class GUIManager implements Runnable
{
	private DisplayMainMenu displayMainMenu;
	private SimulationWindow simulationWindow;
	private DisplayMapGenerator displayMapGenerator;
	
	public GUIManager()
	{
		this.displayMainMenu = new DisplayMainMenu(this);
		this.simulationWindow = new SimulationWindow();
		this.displayMapGenerator = new DisplayMapGenerator();
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
		JOptionPane.showMessageDialog(null, numberOfRound + " tours effectu�s !", "R�sultat des courses", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void showMapGenerator()
	{
		this.displayMapGenerator.setVisible(true);

	}
	
	public void hideMapGenerator()
	{
		this.displayMapGenerator.setVisible(false);

	}
}
