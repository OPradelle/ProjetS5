import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application
{
	private GUIManager guiManager;
	private Random rand;
	
	public Application(GUIManager guiManager)
	{
		this.guiManager = guiManager;
		this.rand = new Random();
	}

	public void start()
	{
		do
		{
			this.guiManager.getDisplayMainMenu().waitForAction();
			
			startSimulation();
		} while(true);
	}
	
	public void startSimulation()
	{
		Map map = new Map();
		map.readFromFile("Map.txt");
		List<Agent> agents = new ArrayList<Agent>();
		for(int i = 0; i < 1; i++)
		{
			agents.add(new Agent());
			agents.get(i).setAgentController(new LevyAgentController());
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
				Thread.sleep(1);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
		this.guiManager.showResult(numberOfRound);
		this.guiManager.hideimulationWindow();
	}
}
