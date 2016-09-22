import java.util.ArrayList;
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
		this.width = width > 0 ? width : DEFAULT_MAP_WIDTH;
		this.height = height > 0 ? height : DEFAULT_MAP_HEIGHT;

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
