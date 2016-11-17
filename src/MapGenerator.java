import java.io.File;

public class MapGenerator
{
	private int mapSize;
	private int proportion;
	private int patchGroupNumber;
	private int patchGroupSize;

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
	}
	
	public void GenerateMap(String filename)
	{
		GenerateMap(new File(filename));
	}
	
	public void GenerateMap(File file)
	{
	}
}
