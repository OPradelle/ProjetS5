import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application
{
	private GUIManager guiManager;
	private Random rand;
	private AgentControllerFactory factory;
	
	public Application(GUIManager guiManager)
	{
		this.guiManager = guiManager;
		this.rand = new Random();
		this.factory = new AgentControllerFactory();
	}

	public void start()
	{
		do
		{
			SimulationParameters simulation;
			simulation = this.guiManager.getDisplayMainMenu().waitForAction();
			
			if(simulation != null)
				startSimulation(simulation);
		} while(true);
	}
	
	public void startSimulation(SimulationParameters simulation)
	{
		Map map = new Map();
		map.readFromFile("Map.txt");
		List<Agent> agents = new ArrayList<Agent>();
		for(int i = 0; i < simulation.getAgentNumber(); i++)
		{
			agents.add(new Agent());
			agents.get(i).setAgentController(factory.factoryMethod(simulation.getMovementType()));
			agents.get(i).setPosition(new Position(this.rand.nextInt(map.getWidth()), this.rand.nextInt(map.getHeight())));
		}


		this.guiManager.getSimulationWindow().startDisplaySimulation(new DisplaySimulation(map, agents));
		this.guiManager.showSimulationWindow();
		int numberOfRound = 0;
		
		while (map.patchNumberLeft() > 0 && this.guiManager.getSimulationWindow().isVisible())
		{
			for (Agent agent : agents)
			{
				agent.update(map);
			}

			this.guiManager.getSimulationWindow().repaint();
			numberOfRound++;
			
			try
			{
				Thread.sleep(simulation.getSleepTime());
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}

		if (map.patchNumberLeft() == 0)
		{
			this.guiManager.showResult(numberOfRound);
		}
		this.guiManager.hideimulationWindow();
	}
}
