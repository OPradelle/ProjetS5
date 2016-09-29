import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class DisplayMap extends JPanel
{
	private static final int BLOC_SIZE = 32;

	private static final long serialVersionUID = 1L;

	private Map map;
	private List<Agent> agents;

	public DisplayMap(Map map, List<Agent> agents)
	{
		this.map = map;
		this.agents = agents;
	}

	@Override
	public void paint(Graphics g)
	{
		super.paint(g);

		g.clearRect(0, 0, getWidth(), getHeight());

		for (int i = 0; i < this.map.getWidth(); i++)
		{
			for (int j = 0; j < this.map.getHeight(); j++)
			{
				// Upper left corner of this terrain rect
				int x = i * BLOC_SIZE;
				int y = j * BLOC_SIZE;

				Image img = null;
				if (this.map.getPatchIndex(new Position(i, j)) >= 0)
				{
					try
					{
						img = ImageIO.read(new File("img/apple2.png"));
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
				}
				else
				{
					try
					{
						img = ImageIO.read(new File("img/case_vide.png"));
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
				}

				g.drawImage(img, x, y, this);
			}
		}

		for (Agent agent : agents)
		{
			try
			{
				Image img = ImageIO.read(new File("img/pacman.png"));
				g.drawImage(img, (int) agent.getPosition().getX() * BLOC_SIZE, (int) agent.getPosition().getY() * BLOC_SIZE, this);
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
