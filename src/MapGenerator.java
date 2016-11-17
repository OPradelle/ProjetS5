import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapGenerator
{
	private int mapSize;
	private int proportion;
	private int patchGroupNumber;
	private int patchGroupSize;

	private List<Position> patches;
	private Random rand;

	// Constructeur utilisé pour la génération sans groupe de patchs
	public MapGenerator(int mapSize, int proportion)
	{
		this(mapSize, proportion, 0, 0);
	}

	// Constructeur utilisé pour la génération avec groupe de patchs
	public MapGenerator(int mapSize, int proportion, int patchGroupNumber, int patchGroupSize)
	{
		this.mapSize = mapSize;
		this.proportion = proportion;
		this.patchGroupNumber = patchGroupNumber;
		this.patchGroupSize = patchGroupSize;

		this.rand = new Random();
	}

	public void generateMap(String filename)
	{
		generateMap(new File(filename));
	}

	public void generateMap(File file)
	{
		if (mapSize == 0)
			return;

		this.patches = new ArrayList<Position>();
		// Generate map
		for (int x = 0; x < mapSize; x++)
		{
			for (int y = 0; y < mapSize; y++)
			{
			}
		}

		writeToFile(file);
	}

	private void writeToFile(File file)
	{
	}
}
