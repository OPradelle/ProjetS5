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

		int blocWidth = getWidth() / (this.map.getWidth() + 2);
		int blocHeight = getHeight() / (this.map.getHeight() + 2);

		// colonnes
		for (int i = 0; i < this.map.getWidth() + 2; i++)
		{
			// lignes
			for (int j = 0; j < this.map.getHeight() + 2; j++)
			{
				// Upper left corner of this terrain rect
				int x = i * blocWidth;
				int y = j * blocHeight;

				Image img = null;

				try
				{
					if (i == 0)
					{
						// Dessiner mur de gauche
						if (j == 0)
							img = ImageIO.read(new File("img/mur_haut_gauche.png"));
						else if (j == this.map.getHeight() + 1)
							img = ImageIO.read(new File("img/mur_bas_gauche.png"));
						else
							img = ImageIO.read(new File("img/mur_gauche.png"));
					}
					else if (i == this.map.getWidth() + 1)
					{
						// Dessiner mur de droite
						if (j == 0)
							img = ImageIO.read(new File("img/mur_haut_droit.png"));
						else if (j == this.map.getHeight() + 1)
							img = ImageIO.read(new File("img/mur_bas_droit.png"));
						else
							img = ImageIO.read(new File("img/mur_droit.png"));
					}
					else
					{
						if (j == 0)
							img = ImageIO.read(new File("img/mur_haut.png"));
						else if (j == this.map.getHeight() + 1)
							img = ImageIO.read(new File("img/mur_bas.png"));
						else
						{
							if (this.map.getPatchIndex(new Position(i - 1, j - 1)) >= 0)
							{
								img = ImageIO.read(new File("img/apple2.png"));
							}
							else
							{
								img = ImageIO.read(new File("img/case_vide.png"));
							}
						}
					}

					g.drawImage(img, x, y, blocWidth, blocHeight, this);
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}

		for (Agent agent : agents)
		{
			try
			{
				Image img = ImageIO.read(new File("img/pacman.png"));
				int x = ((int) (agent.getPosition().getX() + 1)) * blocWidth;
				int y = ((int) (agent.getPosition().getY() + 1)) * blocHeight;
				g.drawImage(img, x, y, blocWidth, blocHeight, this);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}