import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application
{
	public static final String FILE_NAME = "Map.txt";

	public static void main(String[] args)
	{
		Random rand = new Random();

		Map map = new Map();
		List<Agent> agents = new ArrayList<Agent>();
		map.readFromFile(FILE_NAME);

		for (int i = 0; i < 10; i++)
		{
			agents.add(new Agent());
			agents.get(i).setAgentController(new LessRandomAgentController());
			agents.get(i).setPosition(new Position(rand.nextInt(map.getWidth()), rand.nextInt(map.getHeight())));
		}

		int i = 0;
		GameWindow window = new GameWindow(map, agents);

		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		while (map.patchNumberLeft() > 0)
		{
			for (Agent agent : agents)
			{
				agent.update(map);
			}
			
			window.repaint();
			
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}

			i++;
		}
		System.out.println(i);
	}
}
