import java.util.ArrayList;
import java.util.List;

public class Application
{
	public static final String FILE_NAME = "Map.txt";

	public static void main(String[] args)
	{
		Map map = new Map();
		List<Agent> agents = new ArrayList<Agent>();

		for (int i = 0; i < 10; i++)
		{
			agents.add(new Agent());
			agents.get(i).setAgentController(new RandomAgentController());
			agents.get(i).setPosition(new Position(i, 0));
		}

		map.readFromFile(FILE_NAME);
		map.drawMap();
		System.out.println();

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
				Thread.sleep(100);
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
