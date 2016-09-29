public class Application
{
	public static final String FILE_NAME = "Map.txt";

	public static void main(String[] args)
	{
		Map map = new Map();

		map.readFromFile(FILE_NAME);
		map.drawMap();
		System.out.println();

		Agent agent = new Agent();
		agent.setPosition(new Position((int) map.getWidth() / 2, (int) map.getHeight() / 2));
		agent.setAgentController(new RandomAgentController());

		Agent agent2 = new Agent();
		agent2.setPosition(new Position(1, 2));
		agent2.setAgentController(new RandomAgentController());

		int i = 0;

		while (map.patchNumberLeft() > 0)
		{
			agent.update(map);
			agent2.update(map);
			i++;
		}
		System.out.println(i);
	}
}
