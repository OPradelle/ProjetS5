import java.util.ArrayList;
import java.io.*;
import java.util.List;
import java.util.Random;

public class Map
{
	public static final int DEFAULT_MAP_WIDTH = 10;
	public static final int DEFAULT_MAP_HEIGHT = 10;

	private int width, height;
	private List<Position> patches;

	public Map()
	{
		this(DEFAULT_MAP_WIDTH, DEFAULT_MAP_HEIGHT);
	}

	public Map(int width, int height)
	{
		setWidth(width);
		setHeight(height);

	}

	public void setHeight(int height)
	{
		this.height = height > 0 ? height : DEFAULT_MAP_HEIGHT;
	}

	public void setWidth(int width)
	{
		this.width = width > 0 ? width : DEFAULT_MAP_WIDTH;
	}

	public void generatePatches(int nb)
	{
		this.patches = new ArrayList<Position>();
		Random rand = new Random();

		for (int i = 0; i < nb; i++)
		{
			Position position;

			do
			{
				position = new Position(rand.nextInt(this.width), rand.nextInt(this.height));

			} while (patches.contains(position));

			this.patches.add(position);
		}
	}

	public void readFromFile(String filename)
	{
		int mapSize = 0;
		int index;
		int nbLine = 0;

		this.patches = new ArrayList<Position>();

		try
		{
			InputStream inputStream = new FileInputStream(new File(filename));
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String line;
			if ((line = bufferedReader.readLine()) != null)
			{
				mapSize = Integer.parseInt(line);
			}
			setHeight(mapSize);
			setWidth(mapSize);
			while ((line = bufferedReader.readLine()) != null)
			{
				for (index = 0; index < line.length(); index++)
				{
					if (line.charAt(index) == '*')
					{
						this.patches.add(new Position(nbLine, index));
					}
				}
				nbLine++;
			}
			bufferedReader.close();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}

	}

	public void removePatch(Position pos)
	{
		if (pos == null)
			return;

		this.patches.remove(getPatchIndex(pos));
	}

	public int getPatchIndex(Position pos)
	{
		for (int i = 0; i < this.patches.size(); i++)
		{
			if (this.patches.get(i).equals(pos))
				return i;
		}

		return -1;
	}

	public void drawMap()
	{
		for (int x = 0; x < this.height; x++)
		{
			for (int y = 0; y < this.width; y++)
			{
				if (patches.contains(new Position(x, y)))
				{
					System.out.print("X");
				}
				else
				{
					System.out.print(".");
				}
			}
			System.out.println();
		}
	}

	public Position getPatch(int index)
	{
		if (index >= 0 && index < this.patches.size())
		{
			return this.patches.get(index);
		}

		return null;
	}
}
