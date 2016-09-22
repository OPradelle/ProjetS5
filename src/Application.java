public class Application
{
	public static final String FILE_NAME = "Map.txt";
	
	public static void main(String[] args)
	{
		String fileName;
		Map map = new Map();
		
		fileName = FILE_NAME;
		
		map.readFromFile(fileName);
		map.drawMap();
		/*map = new Map(10, 10);
		map.generatePatches(5);

		//Agent agent = new Agent();

		map.drawMap();
		//System.out.println(agent.getPosition());*/
	}
}
