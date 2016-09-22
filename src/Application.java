public class Application
{
	public static void main(String[] args)
	{
		Map map;
		map = new Map(10, 10);
		map.generatePatches(5);

		Agent agent = new Agent();

		map.drawMap();
		System.out.println(agent.getPosition());
	}
}
