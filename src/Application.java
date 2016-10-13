import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application
{
	private GUI gui;
	private Random rand;
	
	public Application(GUI gui)
	{
		this.gui = gui;
		this.rand = new Random();
	}

	public void start()
	{
		do
		{
			this.gui.startDisplayMainMenu();
			//startSimulation();
			
			this.gui.waitForAction();
			startSimulation();
		} while(true);
	}
	
	public void startSimulation()
	{
		Map map = new Map();
		map.readFromFile("Map.txt");
		List<Agent> agents = new ArrayList<Agent>();
		for(int i = 0; i < 10; i++)
		{
			agents.add(new Agent());
			agents.get(i).setAgentController(new LevyAgentController());
			agents.get(i).setPosition(new Position(this.rand.nextInt(map.getWidth()), this.rand.nextInt(map.getHeight())));
		}
		
		this.gui.startDisplaySimulation(new DisplaySimulation(map, agents));
		int numberOfRound = 0;
		
		while (map.patchNumberLeft() > 0)
		{
			for (Agent agent : agents)
			{
				agent.update(map);
			}
			this.gui.repaint();
			numberOfRound++;
			
			try
			{
				Thread.sleep(10);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
		System.out.println("J'ai tout mangé en " + numberOfRound + " tours");
	}
}
