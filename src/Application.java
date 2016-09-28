public class Application
{
	public static final String FILE_NAME = "Map.txt";

	public static void main(String[] args)
	{
		Map map = new Map();

		map.readFromFile(FILE_NAME);
		map.drawMap();

		Agent agent = new Agent();
		agent.setAgentController(new RandomAgentController());

		for (int i = 0; i < 1000; i++)
		{
			agent.update(map);
			System.out.println(i + ": " + agent.getPosition());
		}
	}
}
