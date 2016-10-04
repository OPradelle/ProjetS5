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

		dessinerPremiereLigne(g);

		// lignes
		for (int i = 0; i < this.map.getWidth() + 2; i++)
		{
			// colonnes
			for (int j = 1; j < this.map.getHeight() + 1; j++)
			{
				// Upper left corner of this terrain rect
				int x = i * BLOC_SIZE;
				int y = j * BLOC_SIZE;

				Image img = null;

				if (i == 0)
				{
					try
					{
						img = ImageIO.read(new File("img/mur_gauche.png"));
					}
					catch (IOException e1)
					{
						e1.printStackTrace();
					}

					g.drawImage(img, x, y, this);
				}
				else if (i == this.map.getWidth() + 1)
				{
					try
					{
						img = ImageIO.read(new File("img/mur_droit.png"));
					}
					catch (IOException e1)
					{
						e1.printStackTrace();
					}

					g.drawImage(img, x, y, this);
				}
				else
				{
					if (this.map.getPatchIndex(new Position(i - 1, j - 1)) >= 0)
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
				}

				g.drawImage(img, x, y, this);
			}
		}

		dessinerDerniereLigne(g);

		for (Agent agent : agents)
		{
			try
			{
				Image img = ImageIO.read(new File("img/pacman.png"));
				g.drawImage(img, (int) (agent.getPosition().getX() + 1) * BLOC_SIZE, (int) (agent.getPosition().getY() + 1) * BLOC_SIZE,
						this);
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void dessinerDerniereLigne(Graphics g)
	{
		Image img;
		int i;

		int positionDerniereLigne = this.map.getHeight() + 1;

		try
		{
			img = ImageIO.read(new File("img/mur_bas_gauche.png"));
			g.drawImage(img, 0, positionDerniereLigne * BLOC_SIZE, this);

			for (i = 1; i < this.map.getWidth() + 1; i++)
			{
				img = ImageIO.read(new File("img/mur_bas.png"));
				g.drawImage(img, i * BLOC_SIZE, positionDerniereLigne * BLOC_SIZE, this);

			}

			img = ImageIO.read(new File("img/mur_bas_droit.png"));
			g.drawImage(img, (i) * BLOC_SIZE, positionDerniereLigne * BLOC_SIZE, this);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	private void dessinerPremiereLigne(Graphics g)
	{
		Image img;
		int i;

		try
		{
			img = ImageIO.read(new File("img/mur_haut_gauche.png"));
			g.drawImage(img, 0, 0, this);

			for (i = 1; i < this.map.getWidth() + 1; i++)
			{
				img = ImageIO.read(new File("img/mur_haut.png"));
				g.drawImage(img, i * BLOC_SIZE, 0, this);

			}

			img = ImageIO.read(new File("img/mur_haut_droit.png"));
			g.drawImage(img, (i) * BLOC_SIZE, 0, this);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}
}
